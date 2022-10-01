package com.adel.springwebflux5.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@Slf4j
public class StockMarketClient {

    private WebClient webClient;

    public StockMarketClient(@Value("${clients.stock.market.baseUrl}") String url) {
        this.webClient = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    public Flux<String> getStockMarkteData(){
        return webClient.get()
                .uri("/someendpoint")
                .retrieve()
                .bodyToFlux(String.class)
                .doFirst(() -> log.info("Do first"))
                .doOnNext(n -> log.info("Do next "+n));

    }

    public Flux<String> postStockmarket(List<String> stringList){
        return webClient.post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(stringList))
                .retrieve()
                .bodyToFlux(String.class);
    }

//    public Flux<String> postStockmarket2(List<String> stringList){
//        return webClient.post()
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(stringList))
//                .exchangeToFlux();
//    }
}

package com.adel.springwebflux5.service;

import com.adel.springwebflux5.model.Stock;
import com.adel.springwebflux5.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository stockRepository;

    public Mono<Stock> getOneStock(String id){
        return stockRepository.findById(id);
    }

    public Flux<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public Mono<Stock> createStock(Stock stock){
        return stockRepository.save(stock);
    }

}

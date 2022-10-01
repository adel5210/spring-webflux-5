package com.adel.springwebflux5.controller;

import com.adel.springwebflux5.model.Stock;
import com.adel.springwebflux5.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StocksController {

    private StockService stockService;

    @GetMapping("/{id}")
    public Mono<Stock> getOneStock(@PathVariable String id){
        return stockService.getOneStock(id);
    }

    @GetMapping
    public Flux<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Mono<Stock> createStock(@RequestBody Stock stock){
        return stockService.createStock(stock);
    }
}

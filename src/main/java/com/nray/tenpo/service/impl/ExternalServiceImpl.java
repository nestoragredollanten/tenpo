package com.nray.tenpo.service.impl;

import com.nray.tenpo.service.ExternalService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalServiceImpl implements ExternalService {

    private final WebClient webClient;

    public ExternalServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://localhost:8080").build();
    }

    @Override
    public Mono<Double> getPercentage() {
        return webClient
                .get()
                .uri("/mock")
                .retrieve()
                .bodyToMono(Double.class);
    }
}
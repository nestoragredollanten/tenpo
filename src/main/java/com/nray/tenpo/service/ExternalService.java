package com.nray.tenpo.service;

import reactor.core.publisher.Mono;

public interface ExternalService {

    Mono<Double> getPercentage();
}

package com.nray.tenpo.service;

import reactor.core.publisher.Mono;

public interface PercentageCacheService {

    Mono<Double> getCachedPercentage();
}

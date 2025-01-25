package com.nray.tenpo.service;

import reactor.core.publisher.Mono;

public interface OperationService {

    Mono<Double> sum(int x, int y);
}

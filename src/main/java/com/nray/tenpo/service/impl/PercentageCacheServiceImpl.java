package com.nray.tenpo.service.impl;

import com.nray.tenpo.service.ExternalService;
import com.nray.tenpo.service.PercentageCacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PercentageCacheServiceImpl implements PercentageCacheService {

    private final ExternalService externalService;

    public PercentageCacheServiceImpl(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    @Cacheable(value = "percentageCache", key = "'percentage'", unless = "#result == null")
    public Mono<Double> getCachedPercentage() {
        return externalService.getPercentage().retry(3);
    }
}
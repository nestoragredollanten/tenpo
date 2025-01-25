package com.nray.tenpo.service.impl;

import com.nray.tenpo.dto.CallHistoryDto;
import com.nray.tenpo.repository.CallHistoryRepository;
import com.nray.tenpo.service.OperationService;
import com.nray.tenpo.service.PercentageCacheService;
import com.nray.tenpo.service.mapper.CallHistoryMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OperationServiceImpl implements OperationService {

    private final CallHistoryRepository callHistoryRepository;
    private final PercentageCacheService percentageCacheService;

    public OperationServiceImpl(CallHistoryRepository callHistoryRepository, PercentageCacheService percentageCacheService) {
        this.callHistoryRepository = callHistoryRepository;
        this.percentageCacheService = percentageCacheService;
    }

    @Override
    public Mono<Double> sum(int x, int y) {
        return percentageCacheService.getCachedPercentage()
                .map(percentage -> (x + y) * (1 + (percentage / 100)))
                .doOnSuccess(result -> historyCall("/calculate", "x=" + x + ", y=" + y, result.toString(), null))
                .doOnError(error -> historyCall("/calculate", "x=" + x + ", y=" + y, null, error.getMessage()));
    }

    protected void historyCall(String endpoint, String parameters, String response, String error) {
        CallHistoryDto callHistory = new CallHistoryDto();
        callHistory.setTimestamp(LocalDateTime.now());
        callHistory.setEndpoint(endpoint);
        callHistory.setParameters(parameters);
        callHistory.setResponse(response);
        callHistory.setError(error);
        callHistoryRepository.save(CallHistoryMapper.INSTANCE.dtoToentity(callHistory));
    }
}

package com.nray.tenpo.controller;

import com.nray.tenpo.service.OperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class OperationController {

    private final OperationService service;

    public OperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public Mono<Double> sum(@RequestParam int x, @RequestParam int y) {
        return service.sum(x, y);
    }
}

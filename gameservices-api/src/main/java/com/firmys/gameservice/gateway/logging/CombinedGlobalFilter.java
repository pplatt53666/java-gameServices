package com.firmys.gameservice.gateway.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class CombinedGlobalFilter implements GlobalFilter, Ordered {

    final Logger logger =
            LoggerFactory.getLogger(CombinedGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        logger.info("First Pre Global Filter");
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    logger.info("Last Post Global Filter");
                }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
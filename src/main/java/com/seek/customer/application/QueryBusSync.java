package com.seek.customer.application;

import com.seek.customer.domain.exceptions.CustomerDomainException;
import com.seek.customer.domain.exceptions.HandlerNotFoundException;
import com.seek.shared.domain.bus.query.Query;
import com.seek.shared.domain.bus.query.QueryBus;
import com.seek.shared.domain.bus.query.QueryHandler;
import com.seek.shared.domain.bus.query.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class QueryBusSync implements QueryBus {

    private final Map<Class<? extends Query>, QueryHandler<? extends Query, ? extends Response>> handlers = new HashMap<>();

    public <Q extends Query, R extends Response> void register(Class<Q> query, QueryHandler<Q, R> handler) {
        handlers.put(query, handler);
    }

    @Override
    public <R extends Response, Q extends Query> R ask(Q query) {

        if(Objects.isNull(query)) {
            throw new CustomerDomainException("Query cannot be required");
        }

        @SuppressWarnings("unchecked")
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) handlers.get(query.getClass());

        Optional.ofNullable(handler)
                .orElseThrow(() ->
                        new HandlerNotFoundException("No handler registered for " + query.getClass()
                        )
                );

        return handler.handle(query);
    }
}

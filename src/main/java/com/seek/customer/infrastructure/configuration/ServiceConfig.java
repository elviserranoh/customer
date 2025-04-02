package com.seek.customer.infrastructure.configuration;

import com.seek.customer.application.CommandBusSync;
import com.seek.customer.application.Create.CustomerCreate;
import com.seek.customer.application.Create.CustomerCreateCommandHandler;
import com.seek.customer.application.Find.CustomerFind;
import com.seek.customer.application.Find.CustomerFindQueryHandler;
import com.seek.customer.application.FindAll.CustomerFindAll;
import com.seek.customer.application.FindAll.CustomerFindAllQueryHandler;
import com.seek.customer.application.Metric.CustomerMetric;
import com.seek.customer.application.Metric.CustomerMetricQueryHandler;
import com.seek.customer.application.QueryBusSync;
import com.seek.customer.domain.ports.in.LifeExpectancy;
import com.seek.customer.domain.ports.out.CustomerRepository;
import com.seek.shared.domain.bus.command.Command;
import com.seek.shared.domain.bus.command.CommandHandler;
import com.seek.shared.domain.bus.query.Query;
import com.seek.shared.domain.bus.query.QueryHandler;
import com.seek.shared.domain.bus.query.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean
    public CustomerCreate customerCreate(CustomerRepository repository) {
        return new CustomerCreate(repository);
    }

    @Bean
    public CustomerCreateCommandHandler createCommandHandler(CustomerCreate service) {
        return new CustomerCreateCommandHandler(service);
    }

    @Bean
    public CustomerFind customerFind(CustomerRepository repository, LifeExpectancy lifeExpectancy) {
        return new CustomerFind(repository, lifeExpectancy);
    }

    @Bean
    public CustomerFindAll customerFindAll(CustomerRepository repository, LifeExpectancy lifeExpectancy) {
        return new CustomerFindAll(repository, lifeExpectancy);
    }

    @Bean
    public CustomerMetric customerMetric(CustomerRepository repository) {
        return new CustomerMetric(repository);
    }

    @Bean
    public CustomerFindQueryHandler customerFindQueryHandler(CustomerFind customerFind) {
        return new CustomerFindQueryHandler(customerFind);
    }

    @Bean
    public CustomerFindAllQueryHandler  customerFindAllQueryHandler(CustomerFindAll customerFindAll) {
        return new CustomerFindAllQueryHandler(customerFindAll);
    }

    @Bean
    public CustomerMetricQueryHandler customerMetricQueryHandler(CustomerMetric customerMetric) {
        return new CustomerMetricQueryHandler(customerMetric);
    }

    @Bean
    public CommandBusSync commandBusSync(List<CommandHandler<? extends Command>> handlers) {
        CommandBusSync bus = new CommandBusSync();
        for(CommandHandler<? extends Command> handler : handlers) {
            registerCommandHandler(bus, handler);
        }
        return bus;
    }

    @Bean
    public QueryBusSync queryBusSync(List<QueryHandler<? extends Query, ? extends Response>> queryHandlers) {
        QueryBusSync bus = new QueryBusSync();
        for(QueryHandler<? extends Query, ? extends Response> handler : queryHandlers) {
            registerQueryHandler(bus, handler);
        }
        return bus;
    }

    // Método auxiliar para forzar la coincidencia de tipos.
    private <Q extends Query, R extends Response> void registerQueryHandler(
            QueryBusSync bus,
            QueryHandler<Q, R> handler
    ) {
        bus.register(handler.getQueryClass(), handler);
    }

    // Método auxiliar para forzar la coincidencia de tipos.
    private <C extends Command> void registerCommandHandler(
            CommandBusSync bus,
            CommandHandler<C> handler
    ) {
        bus.register(handler.getCommandClass(), handler);
    }
}

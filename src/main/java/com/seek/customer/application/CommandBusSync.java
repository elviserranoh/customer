package com.seek.customer.application;

import com.seek.shared.domain.bus.command.Command;
import com.seek.shared.domain.bus.command.CommandBus;
import com.seek.shared.domain.bus.command.CommandHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class CommandBus implements CommandBus {

    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> handlers = new HashMap<>();

    public <C extends Command> void register(Class<C> command, CommandHandler<C> commandHandler) {
        handlers.put(command, commandHandler);
    }
    @Override
    public <C extends Command> void dispatch(C command) {

        if(Objects.isNull(command)) {
            throw new IllegalArgumentException("Command cannot be null");
        }

        CommandHandler<C> handler = (CommandHandler<C>) this.handlers.get(command);

        Optional.ofNullable(handler).orElseThrow(() -> new IllegalArgumentException("No handler registered for " + command.getClass()));

        try {
            handler.handle(command);
        } catch (Exception e) {
            throw new RuntimeException("Error handling command " + command.getClass());
        }
    }
}

package com.seek.customer.infrastructure.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // ElementType.TYPE indica que solo se puede aplicar a clases/interfaces/enum
@Retention(RetentionPolicy.RUNTIME) // disponible en tiempo de ejecucion
@Inherited
@Component
public @interface Service {
}

package com.episode6.hackit.android.inject.context.scope;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Scope annotation for an android Context. Preferably paired with one of the other
 * scopes in this package when assigned to an injecting Component of SubComponent.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextScope {
}

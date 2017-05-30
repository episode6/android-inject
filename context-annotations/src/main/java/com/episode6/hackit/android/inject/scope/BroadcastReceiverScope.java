package com.episode6.hackit.android.inject.scope;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Scope annotation for an Android BroadcastReceiver
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface BroadcastReceiverScope {
}

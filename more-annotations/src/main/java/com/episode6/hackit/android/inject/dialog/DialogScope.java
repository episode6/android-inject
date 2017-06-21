package com.episode6.hackit.android.inject.dialog;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Scope annotation for an Android Dialog
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DialogScope {
}

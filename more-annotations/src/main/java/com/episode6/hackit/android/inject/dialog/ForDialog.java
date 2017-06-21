package com.episode6.hackit.android.inject.dialog;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Qualifier annotation for dialog-scoped instances of objects.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ForDialog {
}

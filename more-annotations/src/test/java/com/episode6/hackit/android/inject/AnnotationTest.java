package com.episode6.hackit.android.inject;

import com.episode6.hackit.android.inject.dialog.DialogScope;
import com.episode6.hackit.android.inject.dialog.ForDialog;
import com.episode6.hackit.android.inject.thread.ForUiThread;
import com.episode6.hackit.android.inject.thread.ForWorkerThread;
import org.fest.util.Lists;
import org.junit.Test;

import javax.inject.Qualifier;
import javax.inject.Scope;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Tests qualifier and scope annotations to ensure they have the correct annotations
 * themselves.
 */
public class AnnotationTest {

  @SuppressWarnings("unchecked")
  private static final List<Class<? extends Annotation>> QUALIFIERS = Lists.newArrayList(
      ForDialog.class,
      ForUiThread.class,
      ForWorkerThread.class);

  @SuppressWarnings("unchecked")
  private static final List<Class<? extends Annotation>> SCOPES = Lists.<Class<? extends Annotation>>newArrayList(
      DialogScope.class);

  @Test
  public void testAllRetention() {
    for (Class<? extends Annotation> annotationUnderTest : QUALIFIERS) {
      assertRuntimeRetention(annotationUnderTest);
    }
    for (Class<? extends Annotation> annotationUnderTest : SCOPES) {
      assertRuntimeRetention(annotationUnderTest);
    }
  }

  @Test
  public void testScopeAnnotations() {
    for (Class<? extends Annotation> annotationUnderTest : SCOPES) {
      assertThat(annotationUnderTest.isAnnotationPresent(Scope.class)).isTrue();
    }
  }

  @Test
  public void testQualifierAnnotations() {
    for (Class<? extends Annotation> annotationUnderTest : QUALIFIERS) {
      assertThat(annotationUnderTest.isAnnotationPresent(Qualifier.class)).isTrue();
    }
  }

  private void assertRuntimeRetention(Class<? extends Annotation> annotationUnderTest) {
    Retention retention = annotationUnderTest.getAnnotation(Retention.class);
    assertThat(retention).isNotNull();
    assertThat(retention.value()).isEqualTo(RetentionPolicy.RUNTIME);
  }
}

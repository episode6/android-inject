package com.episode6.hackit.android.inject;

import com.episode6.hackit.android.inject.qualifier.ForApplication;
import com.episode6.hackit.android.inject.scope.*;
import org.fest.util.Lists;
import org.junit.Test;

import javax.inject.Qualifier;
import javax.inject.Scope;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class AnnotationTest {

  private static final List<Class<? extends Annotation>> QUALIFIERS = Lists.<Class<? extends Annotation>>newArrayList(
      ForApplication.class);
  private static final List<Class<? extends Annotation>> SCOPES = Lists.<Class<? extends Annotation>>newArrayList(
      ActivityScope.class,
      BroadcastReceiverScope.class,
      ContentProviderScope.class,
      ContextScope.class,
      ServiceScope.class);

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

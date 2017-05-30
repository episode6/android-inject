package com.episode6.hackit.android.inject.module;

import android.app.WallpaperManager;
import android.content.Context;
import com.episode6.hackit.android.inject.qualifier.ForApplication;
import com.episode6.hackit.android.inject.scope.ContextScope;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * Tests {@link ContextModule}
 */
@PrepareForTest({WallpaperManager.class})
@RunWith(PowerMockRunner.class)
public class ContextModuleTest {

  @Mock Context mContext;

  @Before
  public void setup() {
    PowerMockito.mockStatic(WallpaperManager.class);
  }

  @Test
  public void testContextModule() throws InvocationTargetException, IllegalAccessException {
    ContextModuleTester tester = new ContextModuleTester(ContextModule.class);
    tester.verifyMethods(mContext);
  }

  @Test
  public void testScopedContextModule() throws InvocationTargetException, IllegalAccessException {
    ContextModuleTester tester = new ContextModuleTester(ScopedContextModule.class);
    tester.verifyMethods(mContext, ContextScope.class);
  }

  @Test
  public void testApplicationContextModule() throws InvocationTargetException, IllegalAccessException {
    ContextModuleTester tester = new ContextModuleTester(ApplicationContextModule.class);
    tester.verifyMethods(mContext, ForApplication.class);
  }
}

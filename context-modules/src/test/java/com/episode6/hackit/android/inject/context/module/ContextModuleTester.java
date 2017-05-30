package com.episode6.hackit.android.inject.context.module;

import android.accounts.AccountManager;
import android.app.*;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.midi.MidiManager;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.*;
import android.os.health.SystemHealthManager;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import org.powermock.api.mockito.PowerMockito;

import javax.inject.Qualifier;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;

/**
 * Reflectively tests a context module's methods and annotations
 */
public class ContextModuleTester {

  // These maps are keyed to each method's return type
  private static final Map<Class<?>, Verifier> VERIFIERS;
  private static final Map<Class<?>, Verifier> POWERMOCK_VERIFIERS;

  static {
    VERIFIERS = new HashMap<>();
    POWERMOCK_VERIFIERS = new HashMap<>();
    VERIFIERS.put(Resources.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        verify(mockContext).getResources();
      }
    });
    VERIFIERS.put(ContentResolver.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        verify(mockContext).getContentResolver();
      }
    });
    VERIFIERS.put(AssetManager.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        verify(mockContext).getAssets();
      }
    });
    VERIFIERS.put(PackageManager.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        verify(mockContext).getPackageManager();
      }
    });
    VERIFIERS.put(ApplicationInfo.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        verify(mockContext).getApplicationInfo();
      }
    });
    VERIFIERS.put(WindowManager.class, new SystemServiceVerifier(Context.WINDOW_SERVICE));
    VERIFIERS.put(LayoutInflater.class, new SystemServiceVerifier(Context.LAYOUT_INFLATER_SERVICE));
    VERIFIERS.put(PowerManager.class, new SystemServiceVerifier(Context.POWER_SERVICE));
    VERIFIERS.put(AlarmManager.class, new SystemServiceVerifier(Context.ALARM_SERVICE));
    VERIFIERS.put(NotificationManager.class, new SystemServiceVerifier(Context.NOTIFICATION_SERVICE));
    VERIFIERS.put(KeyguardManager.class, new SystemServiceVerifier(Context.KEYGUARD_SERVICE));
    VERIFIERS.put(LocationManager.class, new SystemServiceVerifier(Context.LOCATION_SERVICE));
    VERIFIERS.put(SearchManager.class, new SystemServiceVerifier(Context.SEARCH_SERVICE));
    VERIFIERS.put(Vibrator.class, new SystemServiceVerifier(Context.VIBRATOR_SERVICE));
    VERIFIERS.put(ConnectivityManager.class, new SystemServiceVerifier(Context.CONNECTIVITY_SERVICE));
    VERIFIERS.put(WifiManager.class, new SystemServiceVerifier(Context.WIFI_SERVICE));
    VERIFIERS.put(WifiP2pManager.class, new SystemServiceVerifier(Context.WIFI_P2P_SERVICE));
    VERIFIERS.put(InputMethodManager.class, new SystemServiceVerifier(Context.INPUT_METHOD_SERVICE));
    VERIFIERS.put(UiModeManager.class, new SystemServiceVerifier(Context.UI_MODE_SERVICE));
    VERIFIERS.put(DownloadManager.class, new SystemServiceVerifier(Context.DOWNLOAD_SERVICE));
    VERIFIERS.put(BatteryManager.class, new SystemServiceVerifier(Context.BATTERY_SERVICE));
    VERIFIERS.put(JobScheduler.class, new SystemServiceVerifier(Context.JOB_SCHEDULER_SERVICE));
    VERIFIERS.put(NetworkStatsManager.class, new SystemServiceVerifier(Context.NETWORK_STATS_SERVICE));
    VERIFIERS.put(HardwarePropertiesManager.class, new SystemServiceVerifier(Context.HARDWARE_PROPERTIES_SERVICE));
    VERIFIERS.put(SensorManager.class, new SystemServiceVerifier(Context.SENSOR_SERVICE));
    VERIFIERS.put(StorageManager.class, new SystemServiceVerifier(Context.STORAGE_SERVICE));
    VERIFIERS.put(AudioManager.class, new SystemServiceVerifier(Context.AUDIO_SERVICE));
    VERIFIERS.put(MediaRouter.class, new SystemServiceVerifier(Context.MEDIA_ROUTER_SERVICE));
    VERIFIERS.put(TelephonyManager.class, new SystemServiceVerifier(Context.TELEPHONY_SERVICE));
    VERIFIERS.put(SubscriptionManager.class, new SystemServiceVerifier(Context.TELEPHONY_SUBSCRIPTION_SERVICE));
    VERIFIERS.put(CarrierConfigManager.class, new SystemServiceVerifier(Context.CARRIER_CONFIG_SERVICE));
    VERIFIERS.put(AccessibilityManager.class, new SystemServiceVerifier(Context.ACCESSIBILITY_SERVICE));
    VERIFIERS.put(AccountManager.class, new SystemServiceVerifier(Context.ACCOUNT_SERVICE));
    VERIFIERS.put(AppWidgetManager.class, new SystemServiceVerifier(Context.APPWIDGET_SERVICE));
    VERIFIERS.put(BluetoothManager.class, new SystemServiceVerifier(Context.BLUETOOTH_SERVICE));
    VERIFIERS.put(CameraManager.class, new SystemServiceVerifier(Context.CAMERA_SERVICE));
    VERIFIERS.put(CaptioningManager.class, new SystemServiceVerifier(Context.CAPTIONING_SERVICE));
    VERIFIERS.put(ClipboardManager.class, new SystemServiceVerifier(Context.CLIPBOARD_SERVICE));
    VERIFIERS.put(ConsumerIrManager.class, new SystemServiceVerifier(Context.CONSUMER_IR_SERVICE));
    VERIFIERS.put(DevicePolicyManager.class, new SystemServiceVerifier(Context.DEVICE_POLICY_SERVICE));
    VERIFIERS.put(DisplayManager.class, new SystemServiceVerifier(Context.DISPLAY_SERVICE));
    VERIFIERS.put(DropBoxManager.class, new SystemServiceVerifier(Context.DROPBOX_SERVICE));
    VERIFIERS.put(FingerprintManager.class, new SystemServiceVerifier(Context.FINGERPRINT_SERVICE));
    VERIFIERS.put(InputManager.class, new SystemServiceVerifier(Context.INPUT_SERVICE));
    VERIFIERS.put(LauncherApps.class, new SystemServiceVerifier(Context.LAUNCHER_APPS_SERVICE));
    VERIFIERS.put(MediaProjectionManager.class, new SystemServiceVerifier(Context.MEDIA_PROJECTION_SERVICE));
    VERIFIERS.put(MediaSessionManager.class, new SystemServiceVerifier(Context.MEDIA_SESSION_SERVICE));
    VERIFIERS.put(MidiManager.class, new SystemServiceVerifier(Context.MIDI_SERVICE));
    VERIFIERS.put(NfcManager.class, new SystemServiceVerifier(Context.NFC_SERVICE));
    VERIFIERS.put(NsdManager.class, new SystemServiceVerifier(Context.NSD_SERVICE));
    VERIFIERS.put(PrintManager.class, new SystemServiceVerifier(Context.PRINT_SERVICE));
    VERIFIERS.put(RestrictionsManager.class, new SystemServiceVerifier(Context.RESTRICTIONS_SERVICE));
    VERIFIERS.put(SystemHealthManager.class, new SystemServiceVerifier(Context.SYSTEM_HEALTH_SERVICE));
    VERIFIERS.put(TelecomManager.class, new SystemServiceVerifier(Context.TELECOM_SERVICE));
    VERIFIERS.put(TextServicesManager.class, new SystemServiceVerifier(Context.TEXT_SERVICES_MANAGER_SERVICE));
    VERIFIERS.put(UsageStatsManager.class, new SystemServiceVerifier(Context.USAGE_STATS_SERVICE));
    VERIFIERS.put(UsbManager.class, new SystemServiceVerifier(Context.USB_SERVICE));
    VERIFIERS.put(UserManager.class, new SystemServiceVerifier(Context.USER_SERVICE));

    POWERMOCK_VERIFIERS.put(WallpaperManager.class, new Verifier() {
      @Override
      public void doVerify(Context mockContext) {
        WallpaperManager.getInstance(mockContext);
      }
    });

  }

  private final List<Method> mStaticMethods;

  public ContextModuleTester(Class<?> moduleClass) {
    mStaticMethods = new LinkedList<>();

    for (Method method : moduleClass.getDeclaredMethods()) {
      if (Modifier.isStatic(method.getModifiers()) &&
          method.getParameterTypes().length == 1 &&
          method.getParameterTypes()[0] == Context.class) {
        mStaticMethods.add(method);
      }
    }
  }

  public void verifyMethods(Context mockContext) throws InvocationTargetException, IllegalAccessException {
    verifyMethods(mockContext, null);
  }

  public void verifyMethods(Context mockContext, Class<? extends Annotation> annotationToCheck) throws InvocationTargetException, IllegalAccessException {
    boolean isQualifierAnnotation = annotationToCheck != null && annotationToCheck.isAnnotationPresent(Qualifier.class);
    List<Method> powermockRequiredMethods = new LinkedList<>();
    for (Method method : mStaticMethods) {

      if (annotationToCheck != null && !method.isAnnotationPresent(annotationToCheck)) {
        throw new AssertionError(
            "Expected annotation " + annotationToCheck.toString() + " on method " + method.toGenericString());
      }
      if (isQualifierAnnotation && method.getParameterAnnotations()[0][0].annotationType() != annotationToCheck) {
        throw new AssertionError(
            "Expected annotation " + annotationToCheck.toString() + " on method param in method " + method.toGenericString());
      }

      Class<?> returnType = method.getReturnType();

      if (VERIFIERS.containsKey(returnType)) {
        method.invoke(null, mockContext);
        VERIFIERS.get(returnType).doVerify(mockContext);
      } else if (POWERMOCK_VERIFIERS.containsKey(returnType)) {
        powermockRequiredMethods.add(method);
      } else {
        throw new NullPointerException("Unexpected return type for method: " + method.toGenericString());
      }
    }

    List<Class<?>> returnTypes = new LinkedList<>();
    for (Method method : powermockRequiredMethods) {
      Class<?> returnType = method.getReturnType();
      returnTypes.add(returnType);
      method.invoke(null, mockContext);
    }

    PowerMockito.verifyStatic();
    for (Class<?> returnType : returnTypes) {
      POWERMOCK_VERIFIERS.get(returnType).doVerify(mockContext);
    }
  }

  interface Verifier {
    void doVerify(Context mockContext);
  }

  static class SystemServiceVerifier implements Verifier {

    private final String mSystemServiceName;

    SystemServiceVerifier(String systemServiceName) {
      mSystemServiceName = systemServiceName;
    }

    @Override
    public void doVerify(Context mockContext) {
      verify(mockContext).getSystemService(mSystemServiceName);
    }
  }
}

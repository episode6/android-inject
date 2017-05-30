package com.episode6.hackit.android.inject.context.module;

import android.accounts.AccountManager;
import android.annotation.TargetApi;
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
import com.episode6.hackit.android.inject.context.qualifier.ForApplication;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Context module for android Applications. Provides @ForApplication qualified objects given
 * a bound {@link Application} instance
 */
@Module
public abstract class ApplicationContextModule {

  @Binds
  @Singleton
  abstract @ForApplication Context bindApplicationContext(Application application);

  @Provides
  @TargetApi(4)
  @ForApplication
  static Resources provideResources(@ForApplication Context context) {
    return context.getResources();
  }

  @Provides
  @ForApplication
  static ContentResolver provideContentResolver(@ForApplication Context context) {
    return context.getContentResolver();
  }

  @Provides
  @ForApplication
  static AssetManager provideAssetManager(@ForApplication Context context) {
    return context.getAssets();
  }

  @Provides
  @ForApplication
  static PackageManager providePackageManager(@ForApplication Context context) {
    return context.getPackageManager();
  }

  @Provides
  @TargetApi(4)
  @ForApplication
  static ApplicationInfo provideApplicationInfo(@ForApplication Context context) {
    return context.getApplicationInfo();
  }

  @Provides
  @ForApplication
  static WindowManager provideWindowManager(@ForApplication Context context) {
    return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
  }

  @Provides
  @ForApplication
  static LayoutInflater provideLayoutInflater(@ForApplication Context context) {
    return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Provides
  @ForApplication
  static PowerManager providePowerManager(@ForApplication Context context) {
    return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
  }

  @Provides
  @ForApplication
  static AlarmManager provideAlarmManager(@ForApplication Context context) {
    return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
  }

  @Provides
  @ForApplication
  static NotificationManager provideNotificationManaer(@ForApplication Context context) {
    return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
  }

  @Provides
  @ForApplication
  static KeyguardManager provideKeyguardManager(@ForApplication Context context) {
    return (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
  }

  @Provides
  @ForApplication
  static LocationManager provideLocationManager(@ForApplication Context context) {
    return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
  }

  @Provides
  @ForApplication
  static SearchManager provideSearchManager(@ForApplication Context context) {
    return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
  }

  @Provides
  @ForApplication
  static Vibrator provideVibrator(@ForApplication Context context) {
    return (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
  }

  @Provides
  @ForApplication
  static ConnectivityManager provideConnectivityManager(@ForApplication Context context) {
    return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  @Provides
  @TargetApi(14)
  @ForApplication
  static WifiP2pManager provideWifiP2PManager(@ForApplication Context context) {
    return (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
  }

  @Provides
  @TargetApi(3)
  @ForApplication
  static InputMethodManager provideInputMethodManager(@ForApplication Context context) {
    return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
  }

  @Provides
  @TargetApi(8)
  @ForApplication
  static UiModeManager provideUiModeManager(@ForApplication Context context) {
    return (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
  }

  @Provides
  @TargetApi(9)
  @ForApplication
  static DownloadManager provideDownloadManager(@ForApplication Context context) {
    return (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static BatteryManager provideBatteryManager(@ForApplication Context context) {
    return (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static JobScheduler provideJobScheduler(@ForApplication Context context) {
    return (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
  }

  @Provides
  @TargetApi(23)
  @ForApplication
  static NetworkStatsManager provideNetworkStatsManager(@ForApplication Context context) {
    return (NetworkStatsManager) context.getSystemService(Context.NETWORK_STATS_SERVICE);
  }

  @Provides
  @TargetApi(24)
  @ForApplication
  static HardwarePropertiesManager provideHardwarePropertiesManager(@ForApplication Context context) {
    return (HardwarePropertiesManager) context.getSystemService(Context.HARDWARE_PROPERTIES_SERVICE);
  }

  @Provides
  @ForApplication
  static SensorManager provideSensorManager(@ForApplication Context context) {
    return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
  }

  @Provides
  @TargetApi(9)
  @ForApplication
  static StorageManager provideStorageManager(@ForApplication Context context) {
    return (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
  }

  @Provides
  @ForApplication
  static AudioManager provideAudioManager(@ForApplication Context context) {
    return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
  }

  @Provides
  @TargetApi(16)
  @ForApplication
  static MediaRouter provideMediaRouter(@ForApplication Context context) {
    return (MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE);
  }

  @Provides
  @ForApplication
  static TelephonyManager provideTelephonyManager(@ForApplication Context context) {
    return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
  }

  @Provides
  @TargetApi(22)
  @ForApplication
  static SubscriptionManager provideSubscriptionManager(@ForApplication Context context) {
    return (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
  }

  @Provides
  @TargetApi(23)
  @ForApplication
  static CarrierConfigManager provideCarrierConfigManager(@ForApplication Context context) {
    return (CarrierConfigManager) context.getSystemService(Context.CARRIER_CONFIG_SERVICE);
  }

  @Provides
  @TargetApi(4)
  @ForApplication
  static AccessibilityManager provideAccessibilityManager(@ForApplication Context context) {
    return (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
  }

  @Provides
  @TargetApi(5)
  @ForApplication
  static AccountManager provideAccountManager(@ForApplication Context context) {
    return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static AppWidgetManager provideAppWidgethManager(@ForApplication Context context) {
    return (AppWidgetManager) context.getSystemService(Context.APPWIDGET_SERVICE);
  }

  @Provides
  @TargetApi(18)
  @ForApplication
  static BluetoothManager provideBluetoothManager(@ForApplication Context context) {
    return (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static CameraManager provideCameraManager(@ForApplication Context context) {
    return (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
  }

  @Provides
  @TargetApi(19)
  @ForApplication
  static CaptioningManager provideCaptioningManager(@ForApplication Context context) {
    return (CaptioningManager) context.getSystemService(Context.CAPTIONING_SERVICE);
  }

  @Provides
  @TargetApi(11)
  @ForApplication
  static ClipboardManager provideClipboardManager(@ForApplication Context context) {
    return (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
  }

  @Provides
  @TargetApi(19)
  @ForApplication
  static ConsumerIrManager provideConsumerIrManager(@ForApplication Context context) {
    return (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
  }

  @Provides
  @TargetApi(8)
  @ForApplication
  static DevicePolicyManager provideDevicePolicyManager(@ForApplication Context context) {
    return (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
  }

  @Provides
  @TargetApi(17)
  @ForApplication
  static DisplayManager provideDisplayManager(@ForApplication Context context) {
    return (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
  }

  @Provides
  @TargetApi(8)
  @ForApplication
  static DropBoxManager provideDropBoxManager(@ForApplication Context context) {
    return (DropBoxManager) context.getSystemService(Context.DROPBOX_SERVICE);
  }

  @Provides
  @TargetApi(23)
  @ForApplication
  static FingerprintManager provideFingerprintManager(@ForApplication Context context) {
    return (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
  }

  @Provides
  @TargetApi(16)
  @ForApplication
  static InputManager provideInputManager(@ForApplication Context context) {
    return (InputManager) context.getSystemService(Context.INPUT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static LauncherApps provideLauncherApps(@ForApplication Context context) {
    return (LauncherApps) context.getSystemService(Context.LAUNCHER_APPS_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static MediaProjectionManager provideMediaProjectionManager(@ForApplication Context context) {
    return (MediaProjectionManager) context.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static MediaSessionManager provideMediaSessionManager(@ForApplication Context context) {
    return (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
  }

  @Provides
  @TargetApi(23)
  @ForApplication
  static MidiManager provideMidiManager(@ForApplication Context context) {
    return (MidiManager) context.getSystemService(Context.MIDI_SERVICE);
  }

  @Provides
  @TargetApi(10)
  @ForApplication
  static NfcManager provideNfcManager(@ForApplication Context context) {
    return (NfcManager) context.getSystemService(Context.NFC_SERVICE);
  }

  @Provides
  @TargetApi(16)
  @ForApplication
  static NsdManager provideNsdManager(@ForApplication Context context) {
    return (NsdManager) context.getSystemService(Context.NSD_SERVICE);
  }

  @Provides
  @TargetApi(19)
  @ForApplication
  static PrintManager providePrintManager(@ForApplication Context context) {
    return (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static RestrictionsManager provideRestrictionsManager(@ForApplication Context context) {
    return (RestrictionsManager) context.getSystemService(Context.RESTRICTIONS_SERVICE);
  }

  @Provides
  @TargetApi(24)
  @ForApplication
  static SystemHealthManager provideSystemHealthManager(@ForApplication Context context) {
    return (SystemHealthManager) context.getSystemService(Context.SYSTEM_HEALTH_SERVICE);
  }

  @Provides
  @TargetApi(21)
  @ForApplication
  static TelecomManager provideTelecomManager(@ForApplication Context context) {
    return (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
  }

  @Provides
  @TargetApi(14)
  @ForApplication
  static TextServicesManager provideTextServicesManager(@ForApplication Context context) {
    return (TextServicesManager) context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
  }

  @Provides
  @TargetApi(22)
  @ForApplication
  static UsageStatsManager provideUsageStatsManager(@ForApplication Context context) {
    return (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
  }

  @Provides
  @TargetApi(12)
  @ForApplication
  static UsbManager provideUsbManager(@ForApplication Context context) {
    return (UsbManager) context.getSystemService(Context.USB_SERVICE);
  }

  @Provides
  @TargetApi(17)
  @ForApplication
  static UserManager providesUserManager(@ForApplication Context context) {
    return (UserManager) context.getSystemService(Context.USER_SERVICE);
  }

  @Provides
  @TargetApi(5)
  @ForApplication
  static WallpaperManager provideWallpaperManager(@ForApplication Context context) {
    return WallpaperManager.getInstance(context);
  }

  @SuppressWarnings("WifiManagerPotentialLeak")
  @Provides
  @ForApplication
  static WifiManager provideWifiManager(@ForApplication Context context) {
    return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
  }

  @Binds
  abstract WifiManager bindApplicationWifiManager(@ForApplication WifiManager wifiManager);
}

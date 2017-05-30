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
import dagger.Module;
import dagger.Provides;

/**
 * Standard context module
 */
@Module
public class ContextModule {

  @Provides
  @TargetApi(4)
  static Resources provideResources(Context context) {
    return context.getResources();
  }

  @Provides
  static ContentResolver provideContentResolver(Context context) {
    return context.getContentResolver();
  }

  @Provides
  static AssetManager provideAssetManager(Context context) {
    return context.getAssets();
  }

  @Provides
  static PackageManager providePackageManager(Context context) {
    return context.getPackageManager();
  }

  @Provides
  @TargetApi(4)
  static ApplicationInfo provideApplicationInfo(Context context) {
    return context.getApplicationInfo();
  }

  @Provides
  static WindowManager provideWindowManager(Context context) {
    return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
  }

  @Provides
  static LayoutInflater provideLayoutInflater(Context context) {
    return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Provides
  static PowerManager providePowerManager(Context context) {
    return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
  }

  @Provides
  static AlarmManager provideAlarmManager(Context context) {
    return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
  }

  @Provides
  static NotificationManager provideNotificationManaer(Context context) {
    return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
  }

  @Provides
  static KeyguardManager provideKeyguardManager(Context context) {
    return (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
  }

  @Provides
  static LocationManager provideLocationManager(Context context) {
    return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
  }

  @Provides
  static SearchManager provideSearchManager(Context context) {
    return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
  }

  @Provides
  static Vibrator provideVibrator(Context context) {
    return (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
  }

  @Provides
  static ConnectivityManager provideConnectivityManager(Context context) {
    return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  @Provides
  @TargetApi(14)
  static WifiP2pManager provideWifiP2PManager(Context context) {
    return (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
  }

  @Provides
  @TargetApi(3)
  static InputMethodManager provideInputMethodManager(Context context) {
    return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
  }

  @Provides
  @TargetApi(8)
  static UiModeManager provideUiModeManager(Context context) {
    return (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
  }

  @Provides
  @TargetApi(9)
  static DownloadManager provideDownloadManager(Context context) {
    return (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static BatteryManager provideBatteryManager(Context context) {
    return (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static JobScheduler provideJobScheduler(Context context) {
    return (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
  }

  @Provides
  @TargetApi(23)
  static NetworkStatsManager provideNetworkStatsManager(Context context) {
    return (NetworkStatsManager) context.getSystemService(Context.NETWORK_STATS_SERVICE);
  }

  @Provides
  @TargetApi(24)
  static HardwarePropertiesManager provideHardwarePropertiesManager(Context context) {
    return (HardwarePropertiesManager) context.getSystemService(Context.HARDWARE_PROPERTIES_SERVICE);
  }

  @Provides
  static SensorManager provideSensorManager(Context context) {
    return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
  }

  @Provides
  @TargetApi(9)
  static StorageManager provideStorageManager(Context context) {
    return (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
  }

  @Provides
  static AudioManager provideAudioManager(Context context) {
    return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
  }

  @Provides
  @TargetApi(16)
  static MediaRouter provideMediaRouter(Context context) {
    return (MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE);
  }

  @Provides
  static TelephonyManager provideTelephonyManager(Context context) {
    return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
  }

  @Provides
  @TargetApi(22)
  static SubscriptionManager provideSubscriptionManager(Context context) {
    return (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
  }

  @Provides
  @TargetApi(23)
  static CarrierConfigManager provideCarrierConfigManager(Context context) {
    return (CarrierConfigManager) context.getSystemService(Context.CARRIER_CONFIG_SERVICE);
  }

  @Provides
  @TargetApi(4)
  static AccessibilityManager provideAccessibilityManager(Context context) {
    return (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
  }

  @Provides
  @TargetApi(5)
  static AccountManager provideAccountManager(Context context) {
    return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static AppWidgetManager provideAppWidgethManager(Context context) {
    return (AppWidgetManager) context.getSystemService(Context.APPWIDGET_SERVICE);
  }

  @Provides
  @TargetApi(18)
  static BluetoothManager provideBluetoothManager(Context context) {
    return (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static CameraManager provideCameraManager(Context context) {
    return (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
  }

  @Provides
  @TargetApi(19)
  static CaptioningManager provideCaptioningManager(Context context) {
    return (CaptioningManager) context.getSystemService(Context.CAPTIONING_SERVICE);
  }

  @Provides
  @TargetApi(11)
  static ClipboardManager provideClipboardManager(Context context) {
    return (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
  }

  @Provides
  @TargetApi(19)
  static ConsumerIrManager provideConsumerIrManager(Context context) {
    return (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
  }

  @Provides
  @TargetApi(8)
  static DevicePolicyManager provideDevicePolicyManager(Context context) {
    return (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
  }

  @Provides
  @TargetApi(17)
  static DisplayManager provideDisplayManager(Context context) {
    return (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
  }

  @Provides
  @TargetApi(8)
  static DropBoxManager provideDropBoxManager(Context context) {
    return (DropBoxManager) context.getSystemService(Context.DROPBOX_SERVICE);
  }

  @Provides
  @TargetApi(23)
  static FingerprintManager provideFingerprintManager(Context context) {
    return (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
  }

  @Provides
  @TargetApi(16)
  static InputManager provideInputManager(Context context) {
    return (InputManager) context.getSystemService(Context.INPUT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static LauncherApps provideLauncherApps(Context context) {
    return (LauncherApps) context.getSystemService(Context.LAUNCHER_APPS_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static MediaProjectionManager provideMediaProjectionManager(Context context) {
    return (MediaProjectionManager) context.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static MediaSessionManager provideMediaSessionManager(Context context) {
    return (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
  }

  @Provides
  @TargetApi(23)
  static MidiManager provideMidiManager(Context context) {
    return (MidiManager) context.getSystemService(Context.MIDI_SERVICE);
  }

  @Provides
  @TargetApi(10)
  static NfcManager provideNfcManager(Context context) {
    return (NfcManager) context.getSystemService(Context.NFC_SERVICE);
  }

  @Provides
  @TargetApi(16)
  static NsdManager provideNsdManager(Context context) {
    return (NsdManager) context.getSystemService(Context.NSD_SERVICE);
  }

  @Provides
  @TargetApi(19)
  static PrintManager providePrintManager(Context context) {
    return (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static RestrictionsManager provideRestrictionsManager(Context context) {
    return (RestrictionsManager) context.getSystemService(Context.RESTRICTIONS_SERVICE);
  }

  @Provides
  @TargetApi(24)
  static SystemHealthManager provideSystemHealthManager(Context context) {
    return (SystemHealthManager) context.getSystemService(Context.SYSTEM_HEALTH_SERVICE);
  }

  @Provides
  @TargetApi(21)
  static TelecomManager provideTelecomManager(Context context) {
    return (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
  }

  @Provides
  @TargetApi(14)
  static TextServicesManager provideTextServicesManager(Context context) {
    return (TextServicesManager) context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
  }

  @Provides
  @TargetApi(22)
  static UsageStatsManager provideUsageStatsManager(Context context) {
    return (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
  }

  @Provides
  @TargetApi(12)
  static UsbManager provideUsbManager(Context context) {
    return (UsbManager) context.getSystemService(Context.USB_SERVICE);
  }

  @Provides
  @TargetApi(17)
  static UserManager providesUserManager(Context context) {
    return (UserManager) context.getSystemService(Context.USER_SERVICE);
  }

  @Provides
  @TargetApi(5)
  static WallpaperManager provideWallpaperManager(Context context) {
    return WallpaperManager.getInstance(context);
  }
}

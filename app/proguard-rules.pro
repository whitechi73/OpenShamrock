# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# Never inline methods, but allow shrinking and obfuscation.
-keepclassmembernames,allowobfuscation,allowshrinking class androidx.core.view.ViewCompat$Api* {
  <methods>;
}
-keepclassmembernames,allowobfuscation,allowshrinking class androidx.core.view.WindowInsetsCompat$*Impl* {
  <methods>;
}
-keepclassmembernames,allowobfuscation,allowshrinking class androidx.core.app.NotificationCompat$*$Api*Impl {
  <methods>;
}
-keepclassmembernames,allowobfuscation,allowshrinking class androidx.core.os.UserHandleCompat$Api*Impl {
  <methods>;
}
-keepclassmembernames,allowobfuscation,allowshrinking class androidx.core.widget.EdgeEffectCompat$Api*Impl {
  <methods>;
}

# Keep metadata about inner emulated classes. This helps with
# reflection on older platforms, but can be omitted if the
# metadata usage is not present in the app.

-keepclassmembers class * {
  ** CREATOR;
}

# Keep the special static methods that are required in all enumeration
# classes.
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

-keep public class androidx.appcompat.widget.** { *; }
-keep public class androidx.appcompat.app.** { *; }
-keep public class androidx.appcompat.view.menu.** { *; }

# Ensure that reflectively-loaded inflater is not obfuscated. This can be
# removed when we stop supporting AAPT1 builds.
-keepnames class androidx.appcompat.app.AppCompatViewInflater
# aapt is not able to read app::actionViewClass and app:actionProviderClass to produce proguard
# keep rules. Add a commonly used SearchView to the keep list until b/109831488 is resolved.
-keep class androidx.appcompat.widget.SearchView { <init>(...); }

# CoordinatorLayout resolves the behaviors of its child components with reflection.
-keep public class * extends androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>();
}

# Make sure we keep annotations for CoordinatorLayout's DefaultBehavior
-keepattributes RuntimeVisible*Annotation*


# Keep `Companion` object fields of serializable classes.
# This avoids serializer lookup through `getDeclaredClasses` as done for named companion objects.
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}

# Keep `serializer()` on companion objects (both default and named) of serializable classes.
-if @kotlinx.serialization.Serializable class ** {
    static **$* *;
}
-keepclassmembers class <2>$<3> {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep `INSTANCE.serializer()` of serializable objects.
-if @kotlinx.serialization.Serializable class ** {
    public static ** INSTANCE;
}
-keepclassmembers class <1> {
    public static <1> INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}

# @Serializable and @Polymorphic are used at runtime for polymorphic serialization.
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault

# Don't print notes about potential mistakes or omissions in the configuration for kotlinx-serialization classes
# See also https://github.com/Kotlin/kotlinx.serialization/issues/1900
-dontnote kotlinx.serialization.**

# Serialization core uses `java.lang.ClassValue` for caching inside these specified classes.
# If there is no `java.lang.ClassValue` (for example, in Android), then R8/ProGuard will print a warning.
# However, since in this case they will not be used, we can disable these warnings
-dontwarn kotlinx.serialization.internal.ClassValueReferences

# Rule to save runtime annotations on serializable class.
# If the R8 full mode is used, annotations are removed from classes-files.
#
# For the annotation serializer, it is necessary to read the `Serializable` annotation inside the serializer<T>() function - if it is present,
# then `SealedClassSerializer` is used, if absent, then `PolymorphicSerializer'.
#
# When using R8 full mode, all interfaces will be serialized using `PolymorphicSerializer`.
#
# see https://github.com/Kotlin/kotlinx.serialization/issues/2050

-if @kotlinx.serialization.Serializable class **
-keep, allowshrinking, allowoptimization, allowobfuscation class <1>

# Entry point for retaining MainDispatcherLoader which uses a ServiceLoader.
-keep class kotlinx.coroutines.Dispatchers {
  ** getMain();
}

# Entry point for retaining CoroutineExceptionHandlerImpl.handlers which uses a ServiceLoader.
-keep class kotlinx.coroutines.CoroutineExceptionHandlerKt {
  void handleCoroutineException(...);
}

# Entry point for the rest of coroutines machinery
-keep class kotlinx.coroutines.BuildersKt {
  ** runBlocking(...);
  ** launch(...);
}

# We are cheating a bit by not having android.jar on R8's library classpath. Ignore those warnings.
-ignorewarnings

-keep class kotlinx.coroutines.android.AndroidDispatcherFactory {*;}
-keep class kotlinx.coroutines.android.AndroidExceptionPreHandler {*;}

# Statically turn off all debugging facilities and assertions
-keepclassmembers class io.ktor.** { volatile <fields>; }
-keep class io.ktor.** { *; }
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.atomicfu.**
-dontwarn io.netty.**
-dontwarn com.typesafe.**
-assumenosideeffects class * implements org.slf4j.Logger {
    public *** trace(...);
    public *** debug(...);
    public *** info(...);
    public *** warn(...);
    public *** error(...);
}
-keep class kotlin.reflect.jvm.internal.** { *; }

-keep class com.arthenica.ffmpegkit.FFmpegKitConfig {
    native <methods>;
    void log(long, int, byte[]);
    void statistics(long, int, float, float, long , int, double, double);
    int safOpen(int);
    int safClose(int);
}

-keep class com.arthenica.ffmpegkit.AbiDetect {
    native <methods>;
}

-dontwarn android.view.RenderNode
-dontwarn android.view.DisplayListCanvas

-keepclassmembers class androidx.compose.ui.platform.ViewLayerContainer {
    protected void dispatchGetDisplayList();
}

-keepclassmembers class androidx.compose.ui.platform.AndroidComposeView {
    android.view.View findViewByAccessibilityIdTraversal(int);
}

# Users can create Modifier.Node instances that implement multiple Modifier.Node interfaces,
# so we cannot tell whether two modifier.node instances are of the same type without using
# reflection to determine the class type. See b/265188224 for more context.
-keep,allowshrinking class * extends androidx.compose.ui.node.ModifierNodeElement
-keep class org.jetbrains.skia.** { *; }
-keep class org.jetbrains.skiko.** { *; }

-assumenosideeffects public class androidx.compose.runtime.ComposerKt {
    void sourceInformation(androidx.compose.runtime.Composer,java.lang.String);
    void sourceInformationMarkerStart(androidx.compose.runtime.Composer,int,java.lang.String);
    void sourceInformationMarkerEnd(androidx.compose.runtime.Composer);
}

-keep class com.arthenica.ffmpegkit.NativeLoader { *; }

-keep class moe.fuqiuluo.** { *; }
-keep class com.tencent.** { *; }
-keep class com.qq.** { *; }
-keep class com.google.gson.** { *; }
-keep class de.** { *; }
-keep class mqq.** { *; }
-keep class QQService.** { *; }
-keep class SummaryCard.** { *; }
-keep class tencent.** { *; }

-keepclassmembers class * {
    native <methods>;
}
-keep class io.netty.** { *; }

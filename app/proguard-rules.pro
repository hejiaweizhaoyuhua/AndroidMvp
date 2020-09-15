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

##***********************************混淆模板*************************##
###混淆规则
## 关闭压缩
#-dontshrink
## 关闭优化
#-dontoptimize
## 关闭混淆
#-dontobfuscate
## 表示保存该包下的类，但是子类会被混淆
#-keep class com.android.xx.*
## 表示保存该包下的类, 子类不会被混淆
#-keep class com.android.xx.**
## 想避免类中的成员不会被混淆
#-keep class com.android.xx.**{*;}
#指定压缩级别 1-7
-optimizationpasses 5
#不跳过非公共的库的类成员
-dontskipnonpubliclibraryclassmembers
#混淆是采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#混淆类中额方法名也混淆了
#-useuniqueclassmembernames
#优化是允许访问并修改修饰符的类和类的成员
-allowaccessmodification
#将文件来源从命名为"SourceFile"字符串
-renamesourcefileattribute SourceFile
#保留行号
-keepattributes SourceFile,LineNumberTable
#保持泛型
-keepattributes Signature
##***********************************************************************##

#保持所有实现Serializable 接口的类成员
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator * ;
}
-keepclassmembers class * implements android.os.Parcelable {
    public <fields>;
    private <fields>;
}
# 保持测试相关代码
-dontnote junit.framework.**
-dontnote junit.runner.**
-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
#Fragment不需要在AndroidManifest.xml中注册，需要额外保护下
-keep public class * extends android.app.Fragment
-keep public class * extends androidx.fragment.app.Fragment
#Android SDK
#-keep class android.app.**{*;}
-keep public class * extends androidx.appcompat.app.AppCompatActivity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.annotation.**
-keep public class * extends android.support.v7.**
-keep public class * extends androidx.**
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep class android.support.** {*;}
-keep class androidx.** {*;}
-keep class android.**{*;}
#自定义view
-keep public class * extends android.view.View {
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context,android.util.AttributeSet);
    public <init>(android.content.Context,android.util.AttributeSet,int);
}
# 自己的view
#-keep class com.liuguilin.fragment.view.**{*;}
#枚举
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#保持native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
##****************************以上都是官方通用的模板*************************

# glide混淆
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}
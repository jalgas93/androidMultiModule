buildscript {
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.49")
    }
}
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.android.library") version "8.2.2" apply false
    id ("com.google.dagger.hilt.android") version "2.49" apply false


}
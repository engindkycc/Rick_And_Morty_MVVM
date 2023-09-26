buildscript {
    repositories {
        google()
        mavenCentral()
    }


    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")


    }
}



// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
    //id ("androidx.navigation.safeargs.kotlin") version "2.5.0" apply false

}


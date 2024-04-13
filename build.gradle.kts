buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
        //icons
        classpath ("com.google.android.gms:oss-licenses-plugin:0.10.6")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}
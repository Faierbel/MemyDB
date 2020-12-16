plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "io.github.memydb"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        exclude("META-INF/library-core_release.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        isEnabled = true
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${rootProject.extra["kotlinVersion"]}")

    implementation("androidx.core:core-ktx:1.2.0-alpha03")
    implementation("androidx.appcompat:appcompat:1.1.0-rc01")
    implementation("androidx.appcompat:appcompat-resources:1.1.0-rc01")
    implementation("androidx.activity:activity-ktx:1.1.0-alpha02")
    implementation("androidx.fragment:fragment-ktx:1.2.0-alpha02")
    implementation("androidx.recyclerview:recyclerview:1.1.0-beta03")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.1.0-alpha09")

    implementation("androidx.navigation:navigation-fragment-ktx:2.2.0-alpha01")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.0-alpha01")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0-alpha03")

    implementation("com.mikepenz:materialdrawer:7.0.0-rc05")
    implementation("com.mikepenz:fastadapter:4.0.1")
    implementation("com.mikepenz:fastadapter-extensions-scroll:4.1.0-b01")

    implementation("com.github.bumptech.glide:glide:4.9.0")
    kapt("com.github.bumptech.glide:compiler:4.9.0")
    implementation("com.google.android.exoplayer:exoplayer:2.10.4")

    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.squareup.okhttp3:logging-interceptor:3.14.9")

    implementation("com.google.dagger:dagger-android-support:2.24")
    kapt("com.google.dagger:dagger-compiler:2.24")
    kapt("com.google.dagger:dagger-android-processor:2.24")

    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
}

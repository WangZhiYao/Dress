plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "me.zhiyao.wedding"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "me.zhiyao.wedding.HiltTestRunner"
    }

    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    debugImplementation(Dependencies.leakCanary)
    testImplementation(Dependencies.roomTesting)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
    kaptAndroidTest(Dependencies.hiltCompiler)

    implementation(kotlin(Dependencies.stdlib, Versions.kotlinVersion))
    implementation(kotlin(Dependencies.stdlibJdk8, Versions.kotlinVersion))

    implementation(Dependencies.androidxCore)
    implementation(Dependencies.androidxAppCompat)
    implementation(Dependencies.androidxSupportV4)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.liveData)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.commonJava8)

    implementation(Dependencies.navigationUi)
    implementation(Dependencies.navigationUiKtx)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationFragmentKtx)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation(Dependencies.hiltLifecycleViewModel)
    kapt(Dependencies.hiltCompiler)

    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)

    implementation(Dependencies.dataStore)

    implementation(Dependencies.pagingRuntimeKtx)

    implementation(project(Dependencies.matisse))

    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)

    implementation(Dependencies.materialDialogCore)
    implementation(Dependencies.materialDialogInput)
    implementation(Dependencies.materialDialogDateTime)
    implementation(Dependencies.materialDialogBottomSheet)
    implementation(Dependencies.materialDialogLifecycle)

}
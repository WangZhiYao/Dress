object Versions {
    const val kotlinVersion = "1.4.21"
    const val leakCanaryVersion = "2.5"
    const val androidxCoreVersion = "1.3.2"
    const val androidxAppCompatVersion = "1.2.0"
    const val androidxSupportV4Version = "1.0.0"
    const val materialVersion = "1.2.1"
    const val constraintLayoutVersion = "2.0.4"
    const val lifecycleVersion = "2.2.0"
    const val navigationVersion = "2.3.2"
    const val hiltAndroidVersion = "2.28-alpha"
    const val hiltCompilerVersion = "1.0.0-alpha02"
    const val roomVersion = "2.3.0-alpha04"
    const val dataStoreVersion = "1.0.0-alpha06"
    const val pagingVersion = "3.0.0-alpha12"
    const val glideVersion = "4.11.0"
    const val materialDialogVersion = "3.3.0"
}

object Dependencies {
    const val stdlib = "stdlib"
    const val stdlibJdk8 = "stdlib-jdk8"

    const val leakCanary =
        "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanaryVersion}"

    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCoreVersion}"
    const val androidxAppCompat =
        "androidx.appcompat:appcompat:${Versions.androidxAppCompatVersion}"
    const val androidxSupportV4 =
        "androidx.legacy:legacy-support-v4:${Versions.androidxSupportV4Version}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"

    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigationVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment:${Versions.navigationVersion}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroidVersion}"
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidVersion}"
    const val hiltLifecycleViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltCompilerVersion}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"
    const val hiltAndroidTesting =
        "com.google.dagger:hilt-android-testing:${Versions.hiltAndroidVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomTesting = "androidx.room:room-testing:${Versions.roomVersion}"

    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStoreVersion}"

    const val pagingRuntimeKtx = "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    const val materialDialogCore =
        "com.afollestad.material-dialogs:core:${Versions.materialDialogVersion}"
    const val materialDialogInput =
        "com.afollestad.material-dialogs:input:${Versions.materialDialogVersion}"
    const val materialDialogDateTime =
        "com.afollestad.material-dialogs:datetime:${Versions.materialDialogVersion}"
    const val materialDialogBottomSheet =
        "com.afollestad.material-dialogs:bottomsheets:${Versions.materialDialogVersion}"
    const val materialDialogLifecycle =
        "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialogVersion}"
}

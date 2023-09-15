object Dependencies {

    /** Kotlin */
    private const val kotlin_ver = "1.6.21"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_ver"
    const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_ver"

    /** Coroutines */
    private const val coroutines_ver = "1.6.4"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_ver"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_ver"
    const val coroutinesPlayService =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutines_ver"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_ver"


    /** Android */
    const val material = "com.google.android.material:material:1.9.0"
    const val flexbox = "com.google.android.flexbox:flexbox:3.0.0"


    /** AndroidX */
    const val appcompat = "androidx.appcompat:appcompat:1.4.1"
    const val palette = "androidx.palette:palette:1.0.0"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val multidex = "androidx.multidex:multidex:2.0.1"

    /** AndroidX Activity */
    const val activityKtx = "androidx.activity:activity-ktx:1.4.0"

    /** AndroidX Fragment */
    private const val fragment_ver = "1.5.1"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragment_ver"
    const val fragmentTesting = "androidx.fragment:fragment-testing:$fragment_ver"

    /** AndroidX Layout */
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.2.0"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    /** AndroidX View */
    const val cardView = "androidx.cardview:cardview:1.0.0"
    const val recycleView = "androidx.recyclerview:recyclerview:1.2.1"
    const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"

    /** AndroidX Browser */
    const val browser = "androidx.browser:browser:1.4.0"

    /** AndroidX Paging */
    const val paging = "androidx.paging:paging-runtime:2.1.0"

    /** AndroidX Support */
    const val supportV4 = "androidx.legacy:legacy-support-v4:1.0.0"

    /** AndroidX Lifecycle */
    private const val lifecycle_ver = "2.4.0"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_ver"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_ver"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_ver"

    /** AndroidX Navigation */
    private const val navigation_ver = "2.4.2"
    const val navSafeArguments =
        "androidx.navigation:navigation-safe-args-gradle-plugin:$navigation_ver"

    const val navFragment = "androidx.navigation:navigation-fragment-ktx:$navigation_ver"
    const val navUi = "androidx.navigation:navigation-ui-ktx:$navigation_ver"
    const val navCommonKtx = "androidx.navigation:navigation-common-ktx:$navigation_ver"
    const val navDynamicFeaturesFragment =
        "androidx.navigation:navigation-dynamic-features-fragment:$navigation_ver"

    /** AndroidX Compose */
    private const val compose_ver = "1.4.0"
    const val composeUi = "androidx.compose.ui:ui:$compose_ver"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$compose_ver"
    const val composeFoundation = "androidx.compose.foundation:foundation:$compose_ver"
    const val composeRuntime = "androidx.compose.runtime:runtime:$compose_ver"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:$compose_ver"
    const val composeRxJava = "androidx.compose.runtime:runtime-rxjava2:$compose_ver"
    const val composeMaterial = "androidx.compose.material:material:$compose_ver"
    const val composeIcons = "androidx.compose.material:material-icons-core:$compose_ver"
    const val composeIconsExtended =
        "androidx.compose.material:material-icons-extended:$compose_ver"

    /** AndroidX Work */
    const val workRuntime = "androidx.work:work-runtime:2.7.1"

    /** AndroidX Room */
    private const val room_ver = "2.4.2"
    const val roomRuntime = "androidx.room:room-runtime:$room_ver"
    const val roomKtx = "androidx.room:room-ktx:$room_ver"
    const val roomCompiler = "androidx.room:room-compiler:$room_ver"


    /** Dagger */
    private const val dagger_ver = "2.41"
    const val hiltAndroid = "com.google.dagger:hilt-android:$dagger_ver"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:$dagger_ver"

    /** OkHttp */
    const val okhttp = "com.squareup.okhttp3:okhttp:4.10.0"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:4.10.0"

    /** Gson */
    const val gson = "com.google.code.gson:gson:2.9.0"

    /** Moshi */
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.9.1"

    /** Retrofit */
    private const val retrofit_ver = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_ver"
    const val retrofitCoroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofit_ver"

    /** Firebase */
    const val firebaseBom = "com.google.firebase:firebase-bom:30.0.0"
    val firebase = listOf(
        "com.google.firebase:firebase-analytics-ktx",
        "com.google.firebase:firebase-firestore-ktx",
        "com.google.firebase:firebase-messaging-ktx",
        "com.google.firebase:firebase-storage-ktx",
        "com.google.firebase:firebase-crashlytics-ndk:18.2.10",
        "com.firebaseui:firebase-ui-firestore:8.0.0"
    )

    /** Pref */
    const val securePref = "com.scottyab:secure-preferences-lib:0.1.7"

    /** Bucket */
    const val alibabaSdk = "com.aliyun.dpa:oss-android-sdk:2.9.11"

    /** Timber */
    const val timber = "com.jakewharton.timber:timber:5.0.1"

    /** Chucker */
    private const val chucker_ver = "3.5.0"
    val chucker = listOf(
        "com.github.chuckerteam.chucker:library:$chucker_ver",
        "com.github.chuckerteam.chucker:library-no-op:$chucker_ver"
    )

    /** Glide */
    private const val glide_ver = "4.13.2"
    const val glide = "com.github.bumptech.glide:glide:$glide_ver"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glide_ver"

    /** Dimens */
    private const val dimens_ver = "1.0.6"
    const val intuitSdp = "com.intuit.sdp:sdp-android:$dimens_ver"
    const val intuitSsp = "com.intuit.ssp:ssp-android:$dimens_ver"

    /** Auth */
    const val googleAuth = "com.google.android.gms:play-services-auth:20.2.0"
    const val facebookSdk = "com.facebook.android:facebook-android-sdk:13.2.0"

    /** Loading */
    const val lottie = "com.airbnb.android:lottie:5.0.3"
    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    const val spinKitView = "com.github.ybq:Android-SpinKit:1.4.0"

    /** Images */
    const val imageCropper = "com.github.CanHub:Android-Image-Cropper:3.3.5"
    const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"

    /** Midtrans */
    const val midtrans = "com.midtrans:uikit:1.31.0"
    const val midtransSanbox = "com.midtrans:uikit::1.31.0-SANDBOX"

}

plugins {
    alias(libs.plugins.runique.android.application.wear.compose)
}

android {
    namespace = "com.ragnarok.wear.app"
    defaultConfig {
        minSdk = 30
    }
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.bundles.koin.compose)

    implementation(projects.core.presentation.designsystemwear)
    implementation(projects.wear.run.presentation)
    implementation(projects.wear.run.data)

    implementation(projects.core.connectivity.domain)
    implementation(projects.core.connectivity.data)
//    implementation(projects.core.notification)
}
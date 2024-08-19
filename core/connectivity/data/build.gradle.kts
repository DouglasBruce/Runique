plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.ragnarok.core.connectivity.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.play.services)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.play.services.wearable)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.connectivity.domain)
}
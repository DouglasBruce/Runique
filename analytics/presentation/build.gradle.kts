plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.ragnarok.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}
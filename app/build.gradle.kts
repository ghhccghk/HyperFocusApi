import org.gradle.kotlin.dsl.distribution

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.hyperfocus.api"
    //noinspection GradleDependency
    compileSdk = 35

    defaultConfig {
        minSdk = 20
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
    }
}

dependencies {
    compileOnly(project(":stub"))
    implementation(libs.gson)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.ghhccghk"
                artifactId = "HyperFocusApi"
                version = "1.10"
                from(components["release"])

                pom {
                    name = "HyperFocusApi"
                    description = "Support Xiaomi HyperOS Focus notification And Island"
                    inceptionYear = "2025"

                    licenses {
                        license {
                            name = "The Apache License, Version 2.0"
                            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                            distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                        }
                    }

                    developers {
                        developer {
                            id = "ghhccghk"
                            name = "李太白"
                            url = "https://github.com/ghhccghk"
                        }
                        developer {
                            id = "HChenX"
                            name = "焕晨"
                            url = "https://github.com/HChenX"
                        }
                    }
                    scm {
                        url = "https://github.com/ghhccghk/HyperFocusApi"
                        connection = "scm:git:git://github.com/ghhccghk/HyperFocusApi.git"
                        developerConnection = "scm:git:ssh://git@github.com/ghhccghk/HyperFocusApi.git"
                    }


                }
            }
        }
    }
}



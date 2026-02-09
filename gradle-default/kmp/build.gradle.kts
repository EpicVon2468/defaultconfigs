@file:OptIn(ExperimentalKotlinGradlePluginApi::class)
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	alias(libs.plugins.kotlin.multiplatform)
}

group = "io.github.epicvon2468.project_name_here"
version = libs.versions.self.get()

repositories {
	mavenCentral()
}

tasks.withType<JavaCompile> {
	options.apply {
		encoding = "UTF-8"
		isIncremental = true
	}
}

tasks.withType<JavaExec> {
	jvmArgs("-XX:+UseCompactObjectHeaders", "--enable-native-access=ALL-UNNAMED")
}

kotlin {
	kotlinDaemonJvmArgs = listOf("-XX:+UseCompactObjectHeaders", "--enable-native-access=ALL-UNNAMED")
	jvmToolchain {
		vendor.set(JvmVendorSpec.JETBRAINS)
		languageVersion.set(JavaLanguageVersion.of(25))
	}
	jvm {
		binaries {
			executable {
				applicationDefaultJvmArgs.add("-XX:+UseCompactObjectHeaders")
				applicationDefaultJvmArgs.add("--enable-native-access=ALL-UNNAMED")
//				mainClass.set("io.github.epicvon2468.project_name_here.MainKt")
			}
		}
		mainRun {
//			mainClass.set("io.github.epicvon2468.project_name_here.MainKt")
		}
	}
	sourceSets {
		commonMain.dependencies {
			compileOnly(libs.jetBrains.annotations)
		}
	}
}
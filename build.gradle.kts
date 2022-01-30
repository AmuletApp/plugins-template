import com.android.build.gradle.BaseExtension
import com.github.redditvanced.gradle.RedditVancedExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenLocal()
		google()
		mavenCentral()
		maven("https://jitpack.io")
	}
	dependencies {
		classpath("com.android.tools.build:gradle:7.0.4")
		classpath("com.github.redditvanced:gradle:1.0.0")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
	}
}

subprojects {
	apply(plugin = "com.android.library")
	apply(plugin = "kotlin-android")
	apply(plugin = "redditvanced")

	redditVanced {
		author("YourName", 1234567890L, "redditUsername")
	}

	android {
		compileSdkVersion(30)

		defaultConfig {
			minSdk = 24
			targetSdk = 30
		}

		compileOptions {
			sourceCompatibility = JavaVersion.VERSION_11
			targetCompatibility = JavaVersion.VERSION_11
		}

		tasks.withType<KotlinCompile> {
			kotlinOptions {
				jvmTarget = "11"
				freeCompilerArgs = freeCompilerArgs +
					"-Xno-call-assertions" +
					"-Xno-param-assertions" +
					"-Xno-receiver-assertions"
			}
		}
	}

	repositories {
		mavenLocal()
		google()
		mavenCentral()
		maven("https://jitpack.io")
	}

	dependencies {
		val compileOnly by configurations
		val redditApk by configurations

		compileOnly("com.github.redditvanced:Core:1.0.0")
		redditApk("::SNAPSHOT")
	}
}

fun Project.android(configuration: BaseExtension.() -> Unit) =
	extensions.getByName<BaseExtension>("android").configuration()

fun Project.redditVanced(configuration: RedditVancedExtension.() -> Unit) =
	extensions.getByName<RedditVancedExtension>("redditVanced").configuration()

task<Delete>("clean") {
	delete(rootProject.buildDir)
}

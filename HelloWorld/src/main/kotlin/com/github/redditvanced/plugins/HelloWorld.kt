package com.github.redditvanced.plugins

import com.github.redditvanced.common.models.PluginManifest
import com.github.redditvanced.core.annotations.RedditVancedPlugin
import com.github.redditvanced.core.entities.Plugin
import com.github.redditvanced.core.util.Utils

// This is the required annotation for marking a class as the plugin class.
// It contains other attributes, for example you can pass in `requiresRestart = true` to restart the plugin when its updated.
@RedditVancedPlugin
@Suppress("unused")
class HelloWorld(manifest: PluginManifest) : Plugin(manifest) {
	// This is the main entry point of your plugin,
	// Do any patching, requests, etc. here.
	// There are other lifecycle methods as well, use Ctrl+n + "Plugin" to quick jump to the class.
	override fun onStart() {
		// This is a utility function for showing a toast
		// Ctrl+Click on "Utils" to jump to the source
		Utils.showToast("[HelloWorld] Hello World!")
	}

	// This is run when your plugin gets disabled, updated (on the old instance), or reinstalled.
	// Unpatching is automatically done for you in the super method.
	override fun onStop() {
		super.onStop()
		Utils.showToast("Goodbye World!")
	}
}

// TO RUN YOUR PLUGIN, enable USB debugging on your phone, install the proper ADB driver on your pc and connect your phone.
// Then, run the "deployWithAdb" gradle task to build ("make" task) your plugin and push it your device.

// To PUBLISH YOUR PLUGIN, instantiate a git repository in the project root,
// Commit your changes and push to your repository.
// Afterwords, return back here and execute the "requestPublishPlugin" gradle task for the specific plugin you want to publish.
// This will send a notification to the RedditVanced maintainers to review your plugin for any malicious code.
// Once this has been completed, your plugin will be built & published to the centralized plugin store.
// It may take between a few hours and 2 days to review depending on who is available.

// TO PUSH UPDATES TO YOUR PLUGIN:
// Increase the version in the "build.gradle.kts" file + add a new entry to the changelog
// Commit & push your changes, and run "requestPublishPlugin" again (same process)
// If this is an urgent change, ping one of the maintainers on Discord.

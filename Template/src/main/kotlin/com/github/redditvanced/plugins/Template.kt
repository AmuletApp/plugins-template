package com.github.redditvanced.plugins

import com.github.redditvanced.common.models.PluginManifest
import com.github.redditvanced.core.annotations.RedditVancedPlugin
import com.github.redditvanced.core.entities.Plugin

@RedditVancedPlugin
@Suppress("unused")
class Template(manifest: PluginManifest) : Plugin(manifest) {
	override fun onStart() {

	}
}

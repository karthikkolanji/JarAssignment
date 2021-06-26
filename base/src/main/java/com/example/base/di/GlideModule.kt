package com.example.base.di

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions


@GlideModule
class GlideModule : AppGlideModule() {

    /**
     * ARG8888
     * uses 4 bytes for each pixel,has the advantage of a higher image quality and the ability to store an alpha channel
     */
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.apply {
            setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888))
            setMemoryCache(LruResourceCache(1024 * 1024 * 20))
            setDefaultTransitionOptions(
                Drawable::class.java,
                DrawableTransitionOptions.withCrossFade()
            )
        }
    }
}
package com.example.photos.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.base.di.GlideApp
import com.example.photos.R
import com.example.photos.data.response.PhotosItem
import com.example.photos.databinding.ItemPhotosBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class PhotosAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var lastPosition: Int = -1
    lateinit var resultsItem: MutableList<PhotosItem>

    fun setPhotos(resultsItem: List<PhotosItem>) {
        this.resultsItem = resultsItem.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotosBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return resultsItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PhotoViewHolder
        viewHolder.bindViews(position)
    }

    inner class PhotoViewHolder(val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("CheckResult")
        fun bindViews(position: Int) {
            val photos = resultsItem[position]
            binding.apply {

                tvMovieName.text =
                    String.format(
                        binding.tvMovieName.context.getString(R.string.uploaded_user_name),
                        photos.user.name
                    )

                tvMovieDesc.text =
                    String.format(
                        binding.tvMovieDesc.context.getString(R.string.description),
                        photos.alt_description
                    )

                tvMovieDate.text =
                    String.format(
                        binding.tvMovieDate.context.getString(
                            R.string.total_likes
                        ), photos.likes
                    )
            }
            GlideApp.with(binding.ivPoster.context)
                .load(photos.urls.full)
                .placeholder(R.drawable.ic_photo)
                .error(R.drawable.ic_error)
                .into(binding.ivPoster)

            enterAnimation(binding.cvRoot, position)

        }

        private fun enterAnimation(cardView: CardView, position: Int) {
            if (position > lastPosition) {
                val animation = AnimationUtils.loadLayoutAnimation(
                    cardView.context,
                    R.anim.layout_animation_fall_down
                )
                cardView.layoutAnimation = animation
                lastPosition = position
            }
        }
    }
}
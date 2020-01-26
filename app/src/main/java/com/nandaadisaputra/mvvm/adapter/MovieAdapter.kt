package com.nandaadisaputra.mvvm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.mvvm.BuildConfig.BASE_URL_IMAGE
import com.nandaadisaputra.mvvm.R
import com.nandaadisaputra.mvvm.model.ResultsItem
import com.nandaadisaputra.mvvm.ui.activity.DetailMovieActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieAdapter(private val data: List<ResultsItem?>) :
    RecyclerView.Adapter<MovieAdapter.MyHolder>(){
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(get: ResultsItem) {
            itemView.tv_title.text = get.title
            itemView.tv_date.text = get.releaseDate
            itemView.tv_vote.text = get.voteAverage.toString()
            itemView.tv_language.text = get.originalLanguage
            itemView.tv_genre.text = get.genreIds.toString()
            itemView.tv_popularity.text = get.popularity.toString()
            itemView.tv_overview.text = get.overview
            Picasso.get().load(BASE_URL_IMAGE + get.backdropPath)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(itemView.iv_image)
            itemView.onClick {
                itemView.context.startActivity(
                    itemView.context.intentFor<DetailMovieActivity>("movie" to get)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            = MyHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_movie,p0,false))


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        data[p1]?.let { p0.bindView(it) }
    }

}
package com.nandaadisaputra.mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nandaadisaputra.mvvm.BuildConfig.BASE_URL_IMAGE
import com.nandaadisaputra.mvvm.R
import com.nandaadisaputra.mvvm.model.ResultsItem
import kotlinx.android.synthetic.main.activity_detail_movie.*

class  DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        getDataParcel()
    }

    private fun getDataParcel() {
        val movie =
            intent.getParcelableExtra<ResultsItem>("movie")
        tv_title.text = movie.title
        tv_genre.text = movie.genreIds.toString()
        tv_release_date.text = movie.releaseDate
        tv_description.text = movie.overview
        Glide.with(this).load(BASE_URL_IMAGE+movie.posterPath).into(iv_image)
    }
}

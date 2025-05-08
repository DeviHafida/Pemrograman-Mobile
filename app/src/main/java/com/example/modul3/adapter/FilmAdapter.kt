package com.example.modul3.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modul3.databinding.ItemFilmBinding
import com.example.modul3.model.Film

class FilmAdapter(
    private val filmList: List<Film>,
    private val onDetailClick: (Film) -> Unit
) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        with(holder.binding) {
            tvTitle.text = film.title
            tvGenre.text = film.genre
            tvYear.text = film.year
            ivPoster.setImageResource(film.imageResId)
            ivPoster.clipToOutline = true

            btnTrailer.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(film.trailerUrl))
                it.context.startActivity(intent)
            }

            btnDetail.setOnClickListener {
                onDetailClick(film)
            }
        }
    }

    override fun getItemCount(): Int = filmList.size
}

package com.example.modul3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.modul3.R
import com.example.modul3.databinding.FragmentFilmDetailBinding
import com.example.modul3.model.Film

class FilmDetailFragment<FilmDetailFragmentArgs> : Fragment() {

    private var _binding: FragmentFilmDetailBinding? = null
    private val binding get() = _binding!!

    private val args: FilmDetailFragmentArgs by navArgs()

    private val filmList = listOf(
        Film("Our Beloved Summer", "Romance, Slice of Life", "2021", R.drawable.ourbelovedsummer, "https://youtu.be/wpW6aVWgvMc?feature=shared", "When a decade-old documentary about high school sweethearts goes viral..."),
        Film("Trauma Code", "Medical, Thriller", "2024", R.drawable.traumacode, "https://youtu.be/pdDXO-dMjAc?feature=shared", "Genius surgeon and former combat medic Baek Kang-hyuk..."),
        Film("Resident Playbook", "Medical, Drama", "2024", R.drawable.residentplaybook, "https://youtu.be/VTjfJ5kWxUE?feature=shared", "First-year OBGYN residents..."),
        Film("Under the Queen’s Umbrella", "Historical, Drama", "2022", R.drawable.underthequeensumbrela, "https://youtu.be/PW6oCJXONYk?feature=shared", "A spirited queen tries to rein in her rowdy sons..."),
        Film("Descendants of the Sun", "Romance, Action", "2016", R.drawable.dots, "https://youtu.be/wkHjOTFv60g?feature=shared", "A soldier belonging to the South Korean Special Forces...")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFilmDetailBinding.inflate(inflater, container, false)

        val film = filmList.find { it.title == args.filmTitle }

        film?.let {
            binding.ivDetailPoster.setImageResource(it.imageResId)
            binding.tvDetailTitle.text = it.title
            binding.tvDetailGenre.text = it.genre
            binding.tvDetailYear.text = it.year
            binding.tvDetailDescription.text = it.description
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

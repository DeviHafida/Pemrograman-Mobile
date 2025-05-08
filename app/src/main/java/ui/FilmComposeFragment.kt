package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul3.R
import com.example.modul3.adapter.FilmAdapter
import com.example.modul3.databinding.FragmentFilmListBinding
import com.example.modul3.model.Film

class FilmComposeFragment : Fragment() {

    private var _binding: FragmentFilmListBinding? = null
    private val binding get() = _binding!!

    private val filmList = listOf(
        Film("Our Beloved Summer", "Romance, Slice of Life", "2021", R.drawable.ourbelovedsummer, "https://youtu.be/wpW6aVWgvMc", "When a decade-old documentary about high school sweethearts goes viral..."),
        Film("Trauma Code", "Medical, Thriller", "2024", R.drawable.traumacode, "https://youtu.be/pdDXO-dMjAc", "Genius surgeon and former combat medic Baek Kang-hyuk..."),
        Film("Resident Playbook", "Medical, Drama", "2024", R.drawable.residentplaybook, "https://youtu.be/VTjfJ5kWxUE", "First-year OBGYN residents at Yulje Medical Center..."),
        Film("Under the Queen’s Umbrella", "Historical, Drama", "2022", R.drawable.underthequeensumbrela, "https://youtu.be/PW6oCJXONYk", "A spirited queen tries to rein in her rowdy sons..."),
        Film("Descendants of the Sun", "Romance, Action", "2016", R.drawable.dots, "https://youtu.be/wkHjOTFv60g", "A soldier from the South Korean Special Forces falls in love...")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFilmListBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FilmAdapter(filmList) { film ->
                val action = FilmComposeFragmentDirections.actionFilmComposeToDetail(film.title)
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
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

class FilmListFragment : Fragment() {

    private var _binding: FragmentFilmListBinding? = null
    private val binding get() = _binding!!

    private val filmList = listOf(
        Film("Our Beloved Summer", "Romance, Slice of Life", "2021", R.drawable.ourbelovedsummer, "https://youtu.be/wpW6aVWgvMc?feature=shared", "When a decade-old documentary about high school sweethearts goes viral, the two ex-sweethearts are hurled into the spotlight and back into each other’s lives. It’s a reluctant reunion, but standing in front of the camera once again might just rekindle feelings that were thought to be lost forever."),
        Film("Trauma Code", "Medical, Thriller", "2024", R.drawable.traumacode, "https://youtu.be/pdDXO-dMjAc?feature=shared", "Genius surgeon and former combat medic Baek Kang-hyuk breathes life into a titular trauma team in this exhilarating medical series."),
        Film("Resident Playbook", "Medical, Drama", "2024", R.drawable.residentplaybook, "https://youtu.be/VTjfJ5kWxUE?feature=shared", "First-year OBGYN residents at Yulje Medical Center navigate the chaos of their work and personal lives, all in their quest to become exceptional doctors."),
        Film("Under the Queen’s Umbrella", "Historical, Drama", "2022", R.drawable.underthequeensumbrela, "https://youtu.be/PW6oCJXONYk?feature=shared", "A spirited queen tries to rein in her rowdy sons in order to make one of them the next king of Joseon, while her competitors vie to snatch the throne."),
        Film("Descendants of the Sun", "Romance, Action", "2016", R.drawable.dots, "https://youtu.be/wkHjOTFv60g?feature=shared", "A soldier belonging to the South Korean Special Forces falls in love with a beautiful surgeon. However, their relationship is short-lived as their professions keep them apart.")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmListBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FilmAdapter(filmList) { film ->
                val action = FilmListFragmentDirections.actionFilmListToDetail(film.title)
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

package com.example.recuandroidsgcnv.fragments
import com.example.recuandroidsgcnv.adapters.LlibresAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.ChipGroup
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recuandroidsgcnv.R
import com.example.recuandroidsgcnv.data.LlibresRepository
import com.example.recuandroidsgcnv.models.Estat
import com.example.recuandroidsgcnv.models.Genere
import com.google.android.material.chip.Chip


class LlibresFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chipGroup: ChipGroup
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: LlibresAdapter
    private var genereSeleccionat: Genere? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_llibres, container, false)
    }


    companion object {

        private const val TITOL_BUNDLE = "titol_bundle"
        private const val AUTOR_BUNDLE = "autor_bundle"
        private const val GENERE_BUNDLE = "genere_bundle"
        private const val ANY_BUNDLE = "any_bundle"
        private const val ESTAT_BUNDLE = "estat_bundle"

        @JvmStatic
        fun newInstance(titol: String, autor: String, genere: Genere, any: Int, estat: Estat ) =
            LlibresFragment().apply {
                arguments = Bundle().apply {
                    putString(TITOL_BUNDLE, titol)
                    putString(AUTOR_BUNDLE, autor)
                    genere
                    putInt(ANY_BUNDLE, any)
                    estat
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.toolbar)
        recyclerView = view.findViewById(R.id.recyclerview)
        chipGroup = view.findViewById(R.id.chipGroup)

        setupRecyclerView()
        setupChips()
        setupToolbarBehavior()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = LlibresAdapter { llibres ->
            val bundle = Bundle().apply { putInt("llibre_id", llibres.id)
            }
            val fragment = LlibresFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter
    }

    private fun setupChips() {
        val chipTots: Chip = view?.findViewById(R.id.chipTots) ?: return
        val chipNovella: Chip = view?.findViewById(R.id.chipNovella) ?: return
        val chipAssaig: Chip = view?.findViewById(R.id.chipAssaig) ?: return
        val chipComic: Chip = view?.findViewById(R.id.chipComic) ?: return

        chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            genereSeleccionat = when {
                checkedIds.contains(R.id.chipNovella) -> Genere.Novella
                checkedIds.contains(R.id.chipAssaig) -> Genere.Assaig
                checkedIds.contains(R.id.chipComic) -> Genere.Comic
                else -> null
            }
            actualitzarLlibres()
        }
    }

    private fun setupToolbarBehavior() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0) {
                    // Scroll cap avall - amagar toolbar
                    toolbar.animate()
                        .translationY(-toolbar.height.toFloat())
                        .setDuration(200)
                        .start()
                } else if (dy < 0) {
                    // Scroll cap amunt - mostrar toolbar
                    toolbar.animate()
                        .translationY(0f)
                        .setDuration(200)
                        .start()
                }
            }
        })
    }

    private fun actualitzarLlibres() {
        if (this::adapter.isInitialized) {


            val llibresFiltrats = if (genereSeleccionat != null) {
                LlibresRepository.llibres.filter {
                    it.genere::class == genereSeleccionat!!::class
                }
            } else {
                LlibresRepository.llibres
            }
            adapter.setLlibres(llibresFiltrats)
        }
    }
}
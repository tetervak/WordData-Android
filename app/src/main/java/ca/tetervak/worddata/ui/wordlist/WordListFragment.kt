package ca.tetervak.worddata.ui.wordlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ca.tetervak.worddata.R
import ca.tetervak.worddata.databinding.FragmentWordListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)

        val adapter = WordListAdapter()
        binding.recyclerView.adapter = adapter


        return binding.root

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
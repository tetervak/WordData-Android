package ca.tetervak.worddata.ui.wordlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ca.tetervak.worddata.MainViewModel
import ca.tetervak.worddata.R
import ca.tetervak.worddata.databinding.FragmentWordListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)

        val adapter = WordListAdapter()
        binding.recyclerView.adapter = adapter

        mainViewModel.liveAllWords.observe(viewLifecycleOwner){ wordList ->
            adapter.submitList(wordList)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_WordListFragment_to_AddWordFragment)
        }

        return binding.root

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package ca.tetervak.worddata.ui.addword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ca.tetervak.worddata.MainViewModel
import ca.tetervak.worddata.R
import ca.tetervak.worddata.databinding.FragmentAddWordBinding
import ca.tetervak.worddata.model.Word
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWordFragment : Fragment() {

    private var _binding: FragmentAddWordBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddWordBinding.inflate(inflater, container, false)

        binding.saveButton.setOnClickListener {
            onSave()
        }

        return binding.root

    }

    private fun onSave() {
        val userInput = binding.editWord.text.toString().trim()
        if (userInput.isNotEmpty()) {
            mainViewModel.insertWord(Word(userInput))
            findNavController().popBackStack()
        } else {
            binding.editWord.error = getString(R.string.should_not_be_blank)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
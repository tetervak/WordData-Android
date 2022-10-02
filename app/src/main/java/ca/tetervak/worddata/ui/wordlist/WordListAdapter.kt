
package ca.tetervak.worddata.ui.wordlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.tetervak.worddata.databinding.WordListItemBinding
import ca.tetervak.worddata.model.Word

class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WordListItemBinding.inflate(layoutInflater,parent,false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = getItem(position)
        holder.bind(word.value)
    }

    class WordViewHolder(
        private val binding: WordListItemBinding
    ) : RecyclerView.ViewHolder(binding.wordView) {

        fun bind(word: String) {
            binding.wordView.text = word
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.value == newItem.value
            }
        }
    }
}

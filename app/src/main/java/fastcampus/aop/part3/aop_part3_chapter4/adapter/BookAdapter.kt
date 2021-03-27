package fastcampus.aop.part3.aop_part3_chapter4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fastcampus.aop.part3.aop_part3_chapter4.databinding.ItemBookBinding
import fastcampus.aop.part3.aop_part3_chapter4.model.Book

class BookAdapter : ListAdapter<Book, BookAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(bookModel: Book) {
            binding.titleTextView.text = bookModel.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Book>() {
            override fun areContentsTheSame(oldItem: Book, newItem: Book) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Book, newItem: Book) =
                oldItem.id == newItem.id
        }
    }

}
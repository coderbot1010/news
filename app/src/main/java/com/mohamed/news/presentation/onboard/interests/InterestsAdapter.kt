package com.mohamed.news.presentation.onboard.interests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.news.R
import com.mohamed.news.data.model.Interest
import com.mohamed.news.databinding.ViewSelectableItemBinding

class InterestsAdapter(private val listener: (Interest) -> Unit) : RecyclerView.Adapter<InterestsAdapter.ViewHolder>()
{
    private var interests: MutableList<Interest> = mutableListOf()

    fun setData(interests: MutableList<Interest>)
    {
        this.interests = mutableListOf()
        this.interests.addAll(interests)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ViewSelectableItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = interests.size

    private fun getItem(position: Int) = interests[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val interest = getItem(position)
        holder.binding.item.setText(interest.interest)
        if (interest.selected) holder.binding.item.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_selected, 0)
        else holder.binding.item.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
    }

    inner class ViewHolder(val binding: ViewSelectableItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init
        {
            binding.root.setOnClickListener {
                val interest = getItem(layoutPosition)
                listener(interest)
                notifyItemChanged(layoutPosition)
            }
        }
    }
}
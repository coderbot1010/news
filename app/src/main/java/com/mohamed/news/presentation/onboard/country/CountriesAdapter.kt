package com.mohamed.news.presentation.onboard.country

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.news.databinding.ViewBasicItemBinding

class CountriesAdapter(private val listener: (String) -> Unit) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>()
{
    private var countries: MutableList<String> = mutableListOf()

    fun setData(countries: MutableList<String>)
    {
        this.countries = mutableListOf()
        this.countries.addAll(countries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ViewBasicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = countries.size

    private fun getItem(position: Int) = countries[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.binding.item.text = getItem(position).split(",")[0]
    }

    inner class ViewHolder(val binding: ViewBasicItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init
        {
            binding.root.setOnClickListener { listener(getItem(layoutPosition)) }
        }
    }
}
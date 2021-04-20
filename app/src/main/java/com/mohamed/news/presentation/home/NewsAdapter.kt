package com.mohamed.news.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.news.R
import com.mohamed.news.data.model.News
import com.mohamed.news.databinding.ViewNewsItemBinding
import com.mohamed.news.utils.DateFormatter
import com.mohamed.news.utils.Views
import com.mohamed.news.utils.setTextWithVisibilityCheck

class NewsAdapter(private val context: Context, private val listener: (News) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>()
{
    private var news: MutableList<News> = mutableListOf()

    fun setData(news: MutableList<News>)
    {
        this.news = mutableListOf()
        this.news.addAll(news)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ViewNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = news.size

    private fun getItem(position: Int) = news[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = getItem(position)
        holder.binding.image.setImageResource(R.drawable.ic_logo)
        if (!item.image.isNullOrEmpty()) Views.ImageLoader.load(context, holder.binding.image, item.image!!)
        holder.binding.title.setTextWithVisibilityCheck(item.title)
        holder.binding.date.setTextWithVisibilityCheck(DateFormatter.format(item.date!!.time))
        holder.binding.source.setTextWithVisibilityCheck(item.source?.name)
        holder.binding.description.setTextWithVisibilityCheck(item.description)
    }

    private fun addItem(newModelData: News, position: Int)
    {
        news.add(position, newModelData)
        notifyItemInserted(position)
    }

    private fun moveItem(fromPosition: Int, toPosition: Int)
    {
        val itinerary: News = news.removeAt(fromPosition)
        news.add(toPosition, itinerary)
        notifyItemMoved(fromPosition, toPosition)
    }

    private fun removeItem(position: Int)
    {
        news.removeAt(position)
        notifyItemRemoved(position)
    }

    fun animateTo(models: List<News>)
    {
        applyAndAnimateRemovals(models)
        applyAndAnimateAdditions(models)
        applyAndAnimateMovedStrings(models)
    }

    private fun applyAndAnimateRemovals(newModels: List<News>)
    {
        for (i in news.indices.reversed())
        {
            val model: News = news[i]
            if (!newModels.contains(model))
            {
                removeItem(i)
            }
        }
    }

    private fun applyAndAnimateAdditions(news: List<News>)
    {
        var i = 0
        val count = news.size
        while (i < count)
        {
            val model = news[i]
            if (!this.news.contains(model))
            {
                addItem(model, i)
            }
            i++
        }
    }

    private fun applyAndAnimateMovedStrings(newModels: List<News>)
    {
        for (toPosition in newModels.indices.reversed())
        {
            val model = newModels[toPosition]
            val fromPosition: Int = news.indexOf(model)
            if (fromPosition >= 0 && fromPosition != toPosition)
            {
                moveItem(fromPosition, toPosition)
            }
        }
    }

    inner class ViewHolder(val binding: ViewNewsItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init
        {
            binding.root.setOnClickListener { listener(getItem(layoutPosition)) }
        }
    }
}
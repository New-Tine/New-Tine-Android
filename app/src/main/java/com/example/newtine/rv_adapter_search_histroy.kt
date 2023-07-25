package com.example.new_tine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newtine.databinding.RvItemSearchHistoryBinding

class rv_adapter_search_histroy(val historyList:ArrayList<article>):RecyclerView.Adapter<rv_adapter_search_histroy.Holder>() {
    private lateinit var binding: RvItemSearchHistoryBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): rv_adapter_search_histroy.Holder {
        binding= RvItemSearchHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: rv_adapter_search_histroy.Holder, position: Int) {
        holder.title.text=historyList[position].title
        holder.press.text=historyList[position].press
        holder.date.text=historyList[position].date.toString()
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    inner class Holder(val binding:RvItemSearchHistoryBinding):RecyclerView.ViewHolder(binding.root){
        val title=binding.articleTitle
        val press=binding.articlePress
        val date=binding.articleDate
    }
}
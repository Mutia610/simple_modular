package com.mutia.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mutia.base.utils.BaseViewHolder
import com.mutia.home.databinding.ItemSourceBinding
import com.mutia.remote.dto_res.source.Source

class HomeAdapter : RecyclerView.Adapter<BaseViewHolder>(){
    private val listData: ArrayList<Source> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(ItemSourceBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.onBind(listData[position])

    inner class ItemViewHolder(
        val binding: ItemSourceBinding
    ) : BaseViewHolder(binding.root) {

        override fun onBind(obj: Any) {
            val data = obj as Source
            binding.sourceName.text = data.name
            binding.sourceCarbons.text = data.carbos
            binding.sourceFats.text = data.fats
            binding.sourceProteins.text = data.proteins
            binding.descrip.text = HtmlCompat.fromHtml(data.description ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)

            data.thumb?.let {
                Glide.with(itemView.context).load(data.thumb).into(binding.imageSource)
            }

            itemView.setOnClickListener {
//                notifyItemChanged(layoutPosition)
            }
        }
    }

    fun setData(list: List<Source>?) {
        if (list == null) return
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }
}
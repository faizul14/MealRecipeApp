package com.faezolmp.mealrecipeapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import com.faezolmp.mealrecipeapp.databinding.ItemMealBinding

class ListDataByCategoryAdapter : RecyclerView.Adapter<ListDataByCategoryAdapter.ViewHolder>() {

    private val listDataMealByCategory = ArrayList<ModelListMealByCategory>()

    fun setData(newData: List<ModelListMealByCategory>) {
        listDataMealByCategory.clear()
        listDataMealByCategory.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModelListMealByCategory) {
            binding.apply {
                Glide.with(itemView.context).load("${data.strMealThumb}/preview").into(imgTumbnail)
                strMeal.text = data.strMeal
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDataMealByCategory[position])
    }

    override fun getItemCount(): Int = listDataMealByCategory.size
}
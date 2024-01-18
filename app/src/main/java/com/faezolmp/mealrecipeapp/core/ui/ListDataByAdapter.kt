package com.faezolmp.mealrecipeapp.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import com.faezolmp.mealrecipeapp.databinding.ItemMealBinding
import com.faezolmp.mealrecipeapp.presentation.detailReceipe.DetailReceipeActivity

class ListDataByAdapter : RecyclerView.Adapter<ListDataByAdapter.ViewHolder>() {

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

            itemView.setOnClickListener {
                val move = Intent(itemView.context, DetailReceipeActivity::class.java)
                move.putExtra(DetailReceipeActivity.ID_MEAL, data.idMeal.toString())
                itemView.context.startActivity(move)
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
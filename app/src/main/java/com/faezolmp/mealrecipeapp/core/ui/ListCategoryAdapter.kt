package com.faezolmp.mealrecipeapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.databinding.ItemCategoryBinding

class ListCategoryAdapter(private val callBackInterface: CallBackInterface) : RecyclerView.Adapter<ListCategoryAdapter.ViewHolder>() {

    private val listDataCategory = ArrayList<ModelListCategory>()
    private var isInitial: Boolean = true

    fun setData(newData: List<ModelListCategory>) {
        listDataCategory.clear()
        listDataCategory.addAll(newData)
        notifyDataSetChanged()
    }

    interface CallBackInterface{
        fun passingDataFromAdapterToActivity(category: String)
    }

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModelListCategory) {
            Glide.with(itemView.context).load("${data.strCategoryThumb}").into(binding.tumbCategory)
            binding.txtCategory.text = data.strCategory

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDataCategory[position])
        if (position == 0 && isInitial){
            callBackInterface.passingDataFromAdapterToActivity(listDataCategory[position].strCategory.toString())
            isInitial = false
        }
        holder.itemView.setOnClickListener {
            callBackInterface.passingDataFromAdapterToActivity(listDataCategory[position].strCategory.toString())
        }
    }

    override fun getItemCount(): Int = listDataCategory.size
}
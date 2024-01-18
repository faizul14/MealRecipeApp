package com.faezolmp.mealrecipeapp.presentation.detailReceipe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.faezolmp.mealrecipeapp.R
import com.faezolmp.mealrecipeapp.core.data.Resource
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.databinding.ActivityDetailReceipeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailReceipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailReceipeBinding
    private val viewModel: DetailReceipeViewModel by viewModels()
    private lateinit var idmeal: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailReceipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idmeal = intent.getStringExtra(ID_MEAL) as String
//        Toast.makeText(this@DetailReceipeActivity, idmeal, Toast.LENGTH_SHORT).show()

        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.getDetailDataMeal(idmeal).observe(this) { dataMeal ->
            when (dataMeal) {
                is Resource.Loading -> {
//                    loading(true)
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this, "Error: ${dataMeal.message.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }

                is Resource.Success -> {
                    dataMeal.data?.let { hitView(it[0]) }
//                    binding.rcview.adapter = listDataSearchAdapter
//                    loading(false)
                }
            }
        }
    }

    private fun hitView(dataDetail: ModelDetailDataMeal) {
        binding.apply {

            toolbarDetail.setOnClickListener {
                this@DetailReceipeActivity.finish()
            }
            //Button Favorite
            imgFavorite.setOnClickListener {
                Toast.makeText(
                    this@DetailReceipeActivity, "Feature under development", Toast.LENGTH_SHORT
                ).show()
            }
            Glide
                .with(this@DetailReceipeActivity)
                .load(dataDetail.strMealThumb)
                .placeholder(R.drawable.pizza_sample)
                .into(imgThumb)
            tvInstructions.text = dataDetail.strInstructions
            tvTitle.text = dataDetail.strMeal
            tvSubTitle.text = "${dataDetail.strCategory} | ${dataDetail.strArea}"

//            val ing = dataDetail.
            //Komposisi start
            val ingredient ="\n \u2022 ${dataDetail.strIngredient1}\n"+
                    " \u2022 ${dataDetail.strIngredient2}\n"+
                    " \u2022 ${dataDetail.strIngredient3}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient4}\n"+
                    " \u2022 ${dataDetail.strIngredient5}\n"+
                    " \u2022 ${dataDetail.strIngredient6}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient7}\n"+
                    " \u2022 ${dataDetail.strIngredient8}\n"+
                    " \u2022 ${dataDetail.strIngredient9}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient10}\n"+
                    " \u2022 ${dataDetail.strIngredient11}\n"+
                    " \u2022 ${dataDetail.strIngredient12}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient13}\n"+
                    " \u2022 ${dataDetail.strIngredient14}\n"+
                    " \u2022 ${dataDetail.strIngredient15}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient16}\n"+
                    " \u2022 ${dataDetail.strIngredient17}\n"+
                    " \u2022 ${dataDetail.strIngredient18}" +
                    "\n"+
                    " \u2022 ${dataDetail.strIngredient19}\n"+
                    " \u2022 ${dataDetail.strIngredient20}\n"+
                    " "
                        .replace("null", "")
                        .replace(" ", "")
            tvIngredients.append("$ingredient")

            val measure ="\n : ${dataDetail.strMeasure1}\n"+
                    " : ${dataDetail.strMeasure2}\n"+
                    " : ${dataDetail.strMeasure3}\n"+
                    " : ${dataDetail.strMeasure4}\n"+
                    " : ${dataDetail.strMeasure5}" +
                    "\n"+
                    " : ${dataDetail.strMeasure6}\n"+
                    " : ${dataDetail.strMeasure7}\n"+
                    " : ${dataDetail.strMeasure8}\n"+
                    " : ${dataDetail.strMeasure9}\n"+
                    " : ${dataDetail.strMeasure10}" +
                    "\n"+
                    " : ${dataDetail.strMeasure11}\n"+
                    " : ${dataDetail.strMeasure12}\n"+
                    " : ${dataDetail.strMeasure13}\n"+
                    " : ${dataDetail.strMeasure14}\n"+
                    " : ${dataDetail.strMeasure15}" +
                    "\n"+
                    " : ${dataDetail.strMeasure16}\n"+
                    " : ${dataDetail.strMeasure17}\n"+
                    " : ${dataDetail.strMeasure18}\n"+
                    " : ${dataDetail.strMeasure19}\n"+
                    " : ${dataDetail.strMeasure20}\n"+
                    " "
                        .replace("null", "")
                        .replace(" ", "")
            tvMeasure.append("$measure")
            //komposisi end

            val Source = dataDetail.strSource//temp.getString("strSource")
            tvSource!!.setOnClickListener { v: View? ->
                val intentYoutube = Intent(Intent.ACTION_VIEW)
                intentYoutube.data = Uri.parse(Source)
                startActivity(intentYoutube)
            }

            val Youtube = dataDetail.strYoutube//temp.getString("strYoutube")
            tvYoutube!!.setOnClickListener { v: View? ->
                val intentYoutube = Intent(Intent.ACTION_VIEW)
                intentYoutube.data = Uri.parse(Youtube)
                startActivity(intentYoutube)
            }

            val ShareRecipe = dataDetail.strSource//temp.getString("strSource")
            tvShareRecipe!!.setOnClickListener {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, ShareRecipe);
                startActivity(Intent.createChooser(shareIntent, "Share with"))
            }
        }
    }

    companion object {
        val ID_MEAL: String = "ID_MEAL"
    }
}
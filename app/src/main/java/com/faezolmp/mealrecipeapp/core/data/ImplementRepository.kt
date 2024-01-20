package com.faezolmp.mealrecipeapp.core.data

import com.faezolmp.mealrecipeapp.core.data.source.local.LocalDataSource
import com.faezolmp.mealrecipeapp.core.data.source.local.entity.EntityMeal
import com.faezolmp.mealrecipeapp.core.data.source.local.room.DaoMeal
import com.faezolmp.mealrecipeapp.core.data.source.remote.RemoteDataSource
import com.faezolmp.mealrecipeapp.core.data.source.remote.network.ApiResponse
import com.faezolmp.mealrecipeapp.core.data.source.remote.response.MealsItemDetail
import com.faezolmp.mealrecipeapp.core.domain.model.ModelDetailDataMeal
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealBookMark
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListMealByCategory
import com.faezolmp.mealrecipeapp.core.domain.repository.Repository
import com.faezolmp.mealrecipeapp.core.helper.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ImplementRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : Repository {
    override fun sampleinterface() = "retunvaluesample"
    override fun getListCategory(): Flow<Resource<List<ModelListCategory>>> {
        return flow {
            emit(Resource.Loading())
           try {
               val dataResponse = remoteDataSource.getListCategory().first()
               when (dataResponse) {
                   is ApiResponse.Success -> {
                       val data =
                           DataMapper.mapperListCategoryFromDataLayerToDomainLayer(dataResponse.data)
                       val dataResult = flowOf(Resource.Success(data))
                       emitAll(dataResult)
                   }

                   is ApiResponse.Error -> {
                       emit(Resource.Error(dataResponse.errorMessage))
                   }

                   is ApiResponse.Empty -> {
                       emit(Resource.Loading())
                   }
               }
           }catch (e: Exception){
               emit(Resource.Error(e.message.toString()))
           }
        }
    }

    override fun getDataListByCategoryy(category: String, meal: String): Flow<Resource<List<ModelListMealByCategory>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val dataResponse = remoteDataSource.getDataListBy(category, meal).first()
                when (dataResponse) {
                    is ApiResponse.Success -> {
                        val data =
                            DataMapper.mapperDataListByCategoryFromDataLayerToDomainLayer(dataResponse.data)
                        val dataResult = flowOf(Resource.Success(data))
                        emitAll(dataResult)
                    }

                    is ApiResponse.Error -> {
                        emit(Resource.Error(dataResponse.errorMessage))
                    }

                    is ApiResponse.Empty -> {
                        emit(Resource.Loading())
                    }
                }
            }catch (e: Exception){
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override fun getDetailMealBy(idmeal: String): Flow<Resource<List<ModelDetailDataMeal>>> {
        return flow {
            emit(Resource.Loading())
           try {
               val dataResponse = remoteDataSource.getDetailMealBy(idmeal).first()
               when (dataResponse) {
                   is ApiResponse.Success -> {
                       val data =
                           DataMapper.mapperDataDetailFromDataLayerToDomainLayer(dataResponse.data)
                       val dataResult = flowOf(Resource.Success(data))
                       emitAll(dataResult)
                   }

                   is ApiResponse.Error -> {
                       emit(Resource.Error(dataResponse.errorMessage))
                   }

                   is ApiResponse.Empty -> {
                       emit(Resource.Loading())
                   }
               }
           }catch (e: Exception){
               emit(Resource.Error(e.message.toString()))
           }
        }
    }

    override fun getDataMailBookmark(): Flow<Resource<List<ModelListMealBookMark>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val dataResponse = localDataSource.getDataListMeal().first()
                if (dataResponse.isNotEmpty()){
                    val data = DataMapper.mapperDataListBookMarkFromDataLayerToDomainLayer(dataResponse)
                    val dataResult = flowOf(Resource.Success(data))
                    emitAll(dataResult)
                }else{
                    emit(Resource.Loading())
                }
            }catch (e : Exception){
                emit(Resource.Error(e.message.toString()))
            }
        }
    }

    override suspend fun addDataMealBooMark(dataBookMarkMeal: ModelListMealBookMark) {
        localDataSource.addDataMeal(DataMapper.mapperDataListBookMarkFromDomainLyerToDataLayer(dataBookMarkMeal))
    }

    override fun deleteDataMealBooMark(dataBookMarkMeal: ModelListMealBookMark) {
        localDataSource.deleteDataMeal(DataMapper.mapperDataListBookMarkFromDomainLyerToDataLayer(dataBookMarkMeal))
    }
}
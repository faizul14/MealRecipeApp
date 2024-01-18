package com.faezolmp.mealrecipeapp.core.data

import com.faezolmp.mealrecipeapp.core.data.source.remote.RemoteDataSource
import com.faezolmp.mealrecipeapp.core.data.source.remote.network.ApiResponse
import com.faezolmp.mealrecipeapp.core.domain.model.ModelListCategory
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
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun sampleinterface() = "retunvaluesample"
    override fun getListCategory(): Flow<Resource<List<ModelListCategory>>> {
        return flow {
            emit(Resource.Loading())
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
        }
    }

    override fun getDataListByCategoryy(category: String): Flow<Resource<List<ModelListMealByCategory>>> {
        return flow {
            emit(Resource.Loading())
            val dataResponse = remoteDataSource.getDataListByCategory().first()
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
        }
    }
}
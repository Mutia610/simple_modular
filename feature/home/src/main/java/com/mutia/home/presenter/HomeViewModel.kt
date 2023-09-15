package com.mutia.home.presenter

import androidx.lifecycle.viewModelScope
import com.mutia.base.domain.subscribers.DataSource
import com.mutia.base.domain.subscribers.Resource
import com.mutia.remote.dto_res.source.SourceRes
import com.mutia.remote.interactor.SourceByCategoryUseCase
import com.mutia.uicomponents.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val sourceByCategoryUseCase: SourceByCategoryUseCase
): BaseViewModel() {

    private val _getSource : MutableStateFlow<Resource<SourceRes>> = MutableStateFlow(Resource.Loading)
    val getSourceLliveData : StateFlow<Resource<SourceRes>> = _getSource

    fun getSourceList(){
        viewModelScope.launch(Dispatchers.IO){
            if (_getSource.value != Resource.Loading){
                _getSource.value = Resource.Loading
            }

            sourceByCategoryUseCase.invoke().collect{when(it){
                    is Resource.Success -> {
                        Timber.d("Success Product : ${it.data}")
                        _getSource.value = Resource.Success(data = it.data, DataSource.REMOTE)
                    }

                    is Resource.Failure -> {
                        _getSource.value = Resource.Failure(it.failureData)
                    } else -> {}
                }
            }
        }
    }
}
package com.colodin.mvicompose.product.presentation

import androidx.lifecycle.MediatorLiveData
import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.presentation.BaseViewModel
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort

class ProductViewModel(appController: AppController) : BaseViewModel(appController) {
    val mediatorProductItems: MediatorLiveData<List<QAProductShort>> = MediatorLiveData(emptyList())
    val mediatorProductShowProgress: MediatorLiveData<Boolean> = MediatorLiveData(false)
    val mediatorProductErrorMessage: MediatorLiveData<String?> = MediatorLiveData()

    val mediatorProductFull: MediatorLiveData<QAProductFull> = MediatorLiveData()

    init {

        mediatorProductItems.addSource(state) { appState ->
            appState.productState.productItems?.consume()?.let {
                mediatorProductItems.postValue(it)
            }
        }

        mediatorProductShowProgress.addSource(state) { appState ->
            appState.productState.productShowProgress?.consume()?.let {
                mediatorProductShowProgress.postValue(it)
            }
        }

        mediatorProductErrorMessage.addSource(state) { appState ->
            appState.productState.productErrorMessage?.consume()?.let {
                mediatorProductErrorMessage.postValue(it)
            }
        }

        mediatorProductFull.addSource(state) { appState ->
            appState.productState.fullProduct?.consume()?.let {
                mediatorProductFull.postValue(it)
            }
        }

    }

    override fun onCleared() {
        mediatorProductItems.removeSource(state)
        mediatorProductShowProgress.removeSource(state)
        mediatorProductErrorMessage.removeSource(state)
        super.onCleared()
    }
}
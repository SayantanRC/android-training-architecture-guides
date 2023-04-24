package com.example.mvp.model

import com.example.common.Utils
import com.example.mvp.contract.ModelContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Implementation of [ModelContract].
 * A single Model generally deals with a single data source and its manipulation.
 * Like shared preferences, database, API.
 */
class Model: ModelContract {

    override fun doWork(
        count: Int,
        presenter: ModelContract.Presenter
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            repeat(count) {
                presenter.onLoading()
                try {
                    Utils.getRandomNumberWithDelay().run {
                        presenter.onSuccess(this.toString())
                    }
                } catch (e: Exception) {
                    presenter.onError(e::class.java.simpleName)
                }
            }
        }
    }
}
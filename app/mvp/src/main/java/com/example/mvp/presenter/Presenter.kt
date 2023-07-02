package com.example.mvp.presenter

import com.example.mvp.contract.ModelContract
import com.example.mvp.contract.ViewContract

/**
 * Presenter handles communication between view (Activity / Fragment) and models.
 * A Presenter is linked with a single view, but can use multiple models.
 *
 * Presenter must NOT have any android related code.
 *
 * Models and view are passed as constructor so that they can be easily mocked
 * and the presentation layer can be tested.
 *
 * If we want to inject the dependencies, we can do that from the view, but only for models.
 * ```
 * @Inject
 * lateinit var numberModel: ModelContract  // implement it in modules
 *
 * private val presenter: ViewContract.Presenter by lazy { Presenter(this, numberModel) }
 * ```
 */
class Presenter(
    private val view: ViewContract,
    private val numberModel: ModelContract,
) : ViewContract.Presenter, ModelContract.Presenter {

    private var resultCount = 0
    private var count = 0

    override fun onLoading() {
        view.onLoading()
    }

    override fun onSuccess(result: String) {
        view.onSuccess(result)
        resultCount++
        checkInputUnfreeze()
    }

    override fun onError(errorMessage: String) {
        view.onError(errorMessage)
        resultCount++
        checkInputUnfreeze()
    }

    override fun loadNumbers(count: Int) {
        this.count = count
        view.onInputFreeze()
        numberModel.doWork(count, this)
    }

    private fun checkInputUnfreeze() {
        if (resultCount == count) {
            view.onInputUnfreeze()
        }
    }
}
package com.example.mvp.view

import android.os.Bundle
import androidx.core.view.isVisible
import com.example.activity.BaseActivity
import com.example.common.R
import com.example.mvp.contract.ModelContract
import com.example.mvp.contract.ViewContract
import com.example.mvp.model.Model
import com.example.mvp.presenter.Presenter

/**
 * This is the view layer. It needs to implement [ViewContract].
 */
class MvpViewActivity: BaseActivity(), ViewContract {

    /*
     * Specifying type of the models and presenter as the interface is generally better.
     * This restricts us from calling unnecessary methods by mistake.
     *
     * Example: not specifying the type of presenter would have allowed us to call
     * onSuccess(), onError() etc which are only supposed to be called by the model.
     * Specifying the type restricts us to call only loanNumbers()
     */
    private val numberModel: ModelContract by lazy { Model() }  // we can inject this by DI
    private val presenter: ViewContract.Presenter by lazy { Presenter(this, numberModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        architectureName.setText(R.string.mvp)

        okButton.setOnClickListener {
            presenter.loadNumbers(countInput.text.toString().toInt())
        }
    }

    override fun onLoading() {
        loadingBar.isVisible = true
    }

    override fun onSuccess(result: String) {
        loadingBar.isVisible = false
        resultTextView.append(result + "\n")
    }

    override fun onError(errorMessage: String) {
        loadingBar.isVisible = false
        resultTextView.append(errorMessage + "\n")
    }

    override fun onInputFreeze() {
        countInput.isEnabled = false
        okButton.isEnabled = false
    }

    override fun onInputUnfreeze() {
        countInput.isEnabled = true
        okButton.isEnabled = true
    }
}
package com.example.mvc.controller

import android.os.Bundle
import androidx.core.view.isVisible
import com.example.activity.BaseActivity
import com.example.common.R
import com.example.mvc.MVC
import com.example.mvc.model.MvcModel

/**
 * In MVC, Activity/Fragment is often considered as the "Controller".
 * The "View" in that case is the layout xml for that Activity/Fragment.
 *
 * This is not a strict rule and we can have a separate Controller class if need be.
 *
 * Controllers often contain some business logic.
 * As in this case Activity is considered as the controller, hence we see some business logic here.
 */
class MvcActivity: BaseActivity(), MVC.Controller {

    private val numberModel: MVC.Model by lazy { MvcModel() }  // we can inject this by DI

    private var count = 0
    private var resultCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        architectureName.setText(R.string.mvc)

        okButton.setOnClickListener {
            count = countInput.text.toString().toInt()
            inputFreeze()
            numberModel.doWork(count, this)
        }
    }

    override fun onLoading() {
        loadingBar.isVisible = true
    }

    override fun onSuccess(result: String) {
        loadingBar.isVisible = false
        resultTextView.append(result + "\n")
        checkInputUnfreeze()
    }

    override fun onError(errorMessage: String) {
        loadingBar.isVisible = false
        resultTextView.append(errorMessage + "\n")
        checkInputUnfreeze()
    }

    private fun inputFreeze() {
        countInput.isEnabled = false
        okButton.isEnabled = false
    }

    private fun inputUnfreeze() {
        countInput.isEnabled = true
        okButton.isEnabled = true
    }

    private fun checkInputUnfreeze() {
        if (resultCount == count) {
            inputUnfreeze()
        }
    }
}
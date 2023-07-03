package com.example.mvc.model

import com.example.common.Utils
import com.example.mvc.MVC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Implementation of [MVC.Model].
 * A single Model generally deals with a single data source and its manipulation.
 * Like shared preferences, database, API.
 *
 * Models generally do not just serve the data from its source, but also perform some operation
 * on them and then serve the transformed data.
 */
class MvcModel: MVC.Model {

    override fun doWork(
        count: Int,
        controller: MVC.Controller
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            repeat(count) {
                controller.onLoading()
                try {
                    Utils.getRandomNumberWithDelay().run {
                        controller.onSuccess(this.toString())
                    }
                } catch (e: Exception) {
                    controller.onError(e::class.java.simpleName)
                }
            }
        }
    }

}
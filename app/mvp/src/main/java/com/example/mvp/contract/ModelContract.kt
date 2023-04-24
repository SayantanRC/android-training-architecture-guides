package com.example.mvp.contract

/**
 * Model class needs to override this interface.
 * Model class contains the code for the work to do.
 *
 * This contract defines how the Model class will be put to service (using [doWork]),
 * and how the Model class will send the result to the Presenter which needs to
 * implement the [Presenter] interface.
 */
interface ModelContract {

    /**
     * The caller of the Model class needs to receive the results from the work.
     * The caller i.e. Presenter needs to implement this interface, and the methods inside will
     * be called by the Model as the work progresses.
     */
    interface Presenter {
        fun onLoading()
        fun onSuccess(result: String)
        fun onError(errorMessage: String)
    }

    /**
     * The Presenter will use this method to ask the Model to do work.
     *
     * @param count Number of random numbers to generate, with random delay
     * between each number.
     * @param presenter The presenter (which implements [Presenter] interface).
     * This is needed because a single instance of a model (say for shared preference)
     * may be used across different presenters.
     */
    fun doWork(
        count: Int,
        presenter: Presenter
    )
}
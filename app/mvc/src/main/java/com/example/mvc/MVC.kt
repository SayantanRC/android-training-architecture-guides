package com.example.mvc

/**
 * Interfaces for Models and Controllers.
 *
 * Note that in Android MVC, generally the layout xml is considered as the "View",
 * and the Activity/Fragment is considered as the "Controller".
 *
 * However there is no well defined restrictions as such and we can also have a separate
 * Controller class to handle work between Activity/Fragment (which are then considered as Views)
 * and Models.
 *
 * Controller classes can have business logic and Models are generally sources of data.
 *
 * Theoretically, Models can in some cases directly interact with View layer (not shown here).
 */
interface MVC {
    interface Controller {
        fun onLoading()
        fun onSuccess(result: String)
        fun onError(errorMessage: String)
    }
    interface Model {
        fun doWork(count: Int, controller: Controller)
    }
}
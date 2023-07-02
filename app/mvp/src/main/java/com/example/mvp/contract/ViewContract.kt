package com.example.mvp.contract

/**
 * Contract between presenter and view.
 * The View (activity or fragment) needs to implement this interface.
 *
 * Note that unlike ModelContract's doWork() method which takes an instance of the presenter,
 * the methods here (onLoading(), onInputFreeze() etc) don't follow that. This is because:
 * 1. One view is linked to one presenter, the presenter takes the view reference from constructor.
 * 2. A singleton instance of a model may be used in various presenters (example API calls model),
 * hence the model needs to know which presenter to send the data back to. But view and presenter
 * have one-to-one relationship.
 * 3. Data flow logic between view-presenter is not the same as presenter-model.
 */
interface ViewContract {

    /**
     * The presenter needs to implement this interface. Thus the presenter implements
     * at lease two interfaces, one from this ViewContract (to receive user interaction)
     * and another from at least one model contract (to receive processed data from models).
     */
    interface Presenter {
        fun loadNumbers(count: Int)
    }

    fun onLoading()
    fun onSuccess(result: String)
    fun onError(errorMessage: String)

    fun onInputFreeze()
    fun onInputUnfreeze()
}
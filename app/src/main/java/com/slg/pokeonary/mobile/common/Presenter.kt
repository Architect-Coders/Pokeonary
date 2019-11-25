package com.slg.pokeonary.mobile.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class Presenter<V : Presenter.View> : CoroutineScope {

    private lateinit var job: Job
    lateinit var view: V

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    fun attachView(view: V) {
        this.view = view
        job = Job()
    }

    fun detachView() {
        job.cancel()
    }

    interface View
}
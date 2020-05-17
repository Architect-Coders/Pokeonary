package com.slg.pokeonary.mobile

import android.app.Application

class PokeonaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }
}

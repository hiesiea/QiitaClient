package sample.qiitaclient

import android.app.Application
import sample.qiitaclient.dagger.AppComponent
import sample.qiitaclient.dagger.DaggerAppComponent

class QiitaClientApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}

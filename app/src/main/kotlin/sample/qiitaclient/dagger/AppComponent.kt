package sample.qiitaclient.dagger

import dagger.Component
import sample.qiitaclient.MainActivity
import javax.inject.Singleton

@Component(modules = [ClientModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}

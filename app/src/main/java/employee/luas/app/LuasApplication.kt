package employee.luas.app

import android.app.Application
import employee.luas.network.networkModule
import employee.luas.repository.repositoryModule
import employee.luas.ui.fragmentModule
import employee.luas.ui.viewmodel.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * Created by Sibaprasad Mohanty on 19/2/21.
 * prasad.mohanty2011@gmail.com
 */

class LuasApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@LuasApplication)
            modules(listOf(fragmentModule, viewmodelModule, networkModule, repositoryModule ))
        }
    }
}
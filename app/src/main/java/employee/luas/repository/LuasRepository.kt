package employee.luas.repository

import employee.luas.network.LuasApi
import org.koin.dsl.module


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

val repositoryModule = module {
    factory { LuasRepository(get()) }
}

class LuasRepository(val luasApi: LuasApi) {
    fun getForecast(stop: String) = luasApi.getForecast(stop = stop)
}
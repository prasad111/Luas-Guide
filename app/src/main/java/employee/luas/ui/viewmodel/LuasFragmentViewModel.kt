package employee.luas.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import employee.luas.model.DataState
import employee.luas.model.StopInfo
import employee.luas.model.Tram
import employee.luas.repository.LuasRepository
import employee.luas.utility.DateUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.dsl.module


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */


val viewmodelModule = module {
    factory { LuasFragmentViewModel(get()) }
}

class LuasFragmentViewModel(private val repository: LuasRepository) : ObservableViewModel() {

    val dataState = DataState()

    private val luasStop = MutableLiveData<StopInfo>()
    private val listTram = MutableLiveData<List<Tram>>()

    fun getListLuasStop() = listTram

    fun fetchLuasStopDetails() {
        dataState.setIsLoading(true)
        repository.getForecast(DateUtils.getStopNameBasedOnTime())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : SingleObserver<StopInfo> {
                override fun onSuccess(stopInfo: StopInfo) {
                    Log.i("TAG", "khkjk  " + stopInfo.message)
                    if (!stopInfo.directions.isNullOrEmpty()) {
                        listTram.value = stopInfo.directions[1].trams
                    } else {
                        dataState.setErrorMessage(stopInfo.message)
                    }
                    dataState.setLuasTitleMessage(
                        "From ${stopInfo.stop} To ${stopInfo.directions[0].name}"
                    )
                    dataState.setIsLoading(false)
                    dataState.setLuasRunningStatus(stopInfo.message)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {
                    e.message?.let { dataState.setErrorMessage(it) }
                }
            })
    }
}
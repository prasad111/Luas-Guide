package employee.luas.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import employee.luas.BR

/**
 * Created by Sibaprasad Mohanty on 22/2/21.
 * prasad.mohanty2011@gmail.com
 */

class DataState : BaseObservable() {

    private var isLoading: Boolean = true

    private var errorMessage: String = ""

    private var luasTitleMessage: String = ""

    private var luasRunningStatus: String = ""

    @Bindable
    fun getLuasRunningStatus() = luasRunningStatus

    fun setLuasRunningStatus(value: String) {
        this.luasRunningStatus = value
        notifyPropertyChanged(BR.luasRunningStatus)
    }

    @Bindable
    fun isLoading() = isLoading

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading = isLoading
        notifyPropertyChanged(BR.loading)
    }

    @Bindable
    fun getErrorMessage() = errorMessage

    fun setErrorMessage(error: String) {
        this.errorMessage = error
        notifyPropertyChanged(BR.errorMessage)
    }

    @Bindable
    fun getLuasTitleMessage() = luasTitleMessage

    fun setLuasTitleMessage(message: String) {
        this.luasTitleMessage = message
        notifyPropertyChanged(BR.luasTitleMessage)
    }
}
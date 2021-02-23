package employee.luas.utility

import android.text.TextUtils
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import employee.luas.model.Direction
import employee.luas.ui.adapter.BindableAdapter


object BindingUtils {

    @JvmStatic
    @BindingAdapter("android:error")
    fun onError(edittext: AppCompatEditText, error: String) {
        if (TextUtils.isEmpty(error)) {
            edittext.error = null
        } else {
            edittext.error = error
        }
    }

    @BindingAdapter("adapter")
    fun adapter(recyclerView: RecyclerView, listData: ArrayList<Direction>) {
        //  recyclerView.adapter = BooksAdapter(listData, this)
    }

    @BindingAdapter("data")
    fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<T>) {
        if (recyclerView.adapter is BindableAdapter<*>) {
            (recyclerView.adapter as BindableAdapter<T>).setData(items)
        }
    }
}
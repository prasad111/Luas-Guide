package employee.luas.ui.adapter

/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

interface BindableAdapter<T> {
    fun setData(items: List<T>)
    fun changedPositions(positions: Set<Int>)
}
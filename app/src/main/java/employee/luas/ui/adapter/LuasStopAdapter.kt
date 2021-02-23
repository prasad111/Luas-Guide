package employee.luas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import employee.luas.databinding.ItemviewStopBinding
import employee.luas.model.Tram

/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

class LuasStopAdapter : RecyclerView.Adapter<LuasStopAdapter.StopHolder>(),
    BindableAdapter<Tram> {

    override fun setData(items: List<Tram>) {
        tramList = items
        notifyDataSetChanged()
    }

    override fun changedPositions(positions: Set<Int>) {
        positions.forEach(this::notifyItemChanged)
    }

    var tramList = emptyList<Tram>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StopHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemviewStopBinding.inflate(layoutInflater, parent, false)
        return StopHolder(binding)
    }

    override fun getItemCount() = tramList.size

    override fun onBindViewHolder(holder: StopHolder, position: Int) {
        holder.bind(tramList[position])
    }

    class StopHolder(private val binding: ItemviewStopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tram: Tram) {
            binding.tram = tram
            binding.executePendingBindings()
        }
    }
}
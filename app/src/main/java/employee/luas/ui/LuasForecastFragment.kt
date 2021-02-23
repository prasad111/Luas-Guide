package employee.luas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import employee.luas.R
import employee.luas.databinding.FragmentLuasBinding
import employee.luas.ui.adapter.LuasStopAdapter
import employee.luas.ui.viewmodel.LuasFragmentViewModel
import kotlinx.android.synthetic.main.fragment_luas.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */


val fragmentModule = module {
    factory { LuasForecastFragment() }
}

class LuasForecastFragment : Fragment() {

    val viewModel: LuasFragmentViewModel by viewModel()
    val adapter = LuasStopAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLuasBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_luas, container, false
        )
        binding.dataState = viewModel.dataState
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchLuasStopDetails()
        initViews()
    }

    private fun initViews() {
        enableProgress(true)
        recyclerView.adapter = adapter
        viewModel.getListLuasStop().observe(viewLifecycleOwner, {
            adapter.setData(it)
            enableProgress(false)
        })

        swipeRefreshLayout.setOnRefreshListener {
            fetchLuasDetails()
        }
        swipeRefreshLayout.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
    }

    private fun fetchLuasDetails() {
        viewModel.fetchLuasStopDetails()
    }

    private fun enableProgress(isShowing: Boolean) {
        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.isRefreshing = isShowing
    }

}
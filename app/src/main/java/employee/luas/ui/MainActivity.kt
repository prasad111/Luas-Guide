package employee.luas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import employee.luas.R
import org.koin.android.ext.android.inject

/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

class MainActivity : AppCompatActivity() {
    private val luasForecastFragment: LuasForecastFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, luasForecastFragment, "luasForecast")
            .commit()
    }
}
package employee.luas.utility

import java.util.*


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

class DateUtils {

    companion object {
        private val midNightTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }.time

        private val midDayTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 12)
            set(Calendar.MINUTE, 1)
            set(Calendar.SECOND, 0)
        }.time

        fun getStopNameBasedOnTime(): String {
            val currentTime = Calendar.getInstance().time
            return if (currentTime.after(midNightTime) && currentTime.before(midDayTime)) AppConstants.MARLBOROUGH else AppConstants.STILLORGAN
        }
    }

}
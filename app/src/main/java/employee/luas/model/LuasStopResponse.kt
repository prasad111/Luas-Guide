package employee.luas.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by Sibaprasad Mohanty on 21/2/21.
 * prasad.mohanty2011@gmail.com
 */

@Root(name = "stopInfo", strict = false)
data class StopInfo @JvmOverloads constructor(
    @field: Attribute(name = "stop")
    var stop: String = "",
    @field: Attribute(name = "stopAbv")
    var stopAbv: String = "",
    @field: ElementList(inline = true, required = false)
    var directions: MutableList<Direction> = mutableListOf(),
    @field:Element(name = "message")
    var message: String = ""
)

@Root(name = "direction", strict = false)
data class Direction @JvmOverloads constructor(
    @field: Attribute(name = "name", required = false)
    var name: String = "",
    @field: ElementList(inline = true, required = false)
    var trams: MutableList<Tram> = mutableListOf()
)

@Root(name = "tram", strict = false)
data class Tram @JvmOverloads constructor(
    @field: Attribute(name = "dueMins")
    var dueMins: String = "",
    @field: Attribute(name = "destination")
    var destination: String = ""
)
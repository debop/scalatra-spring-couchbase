package example.controller

import example.annotations.ServletPath
import example.service.BreweryService
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller


@Controller
@ServletPath("/brewwery")
class BreweryController extends ScalatraServlet with ScalateSupport {

  @Autowired val breweryService: BreweryService = null

  get("/:id") {
    val id = params.getAs[String]("id").getOrElse("")
    ssp("/brewery/read", "brewery" -> breweryService.find(id))
  }

}

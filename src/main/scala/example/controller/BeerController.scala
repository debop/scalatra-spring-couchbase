package example.controller

import example.annotations.ServletPath
import example.service.BeerService
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

/**
 * BeerController
 * @author sunghyouk.bae@gmail.com
 */
@Controller
@ServletPath("/beer")
class BeerController extends ScalatraServlet with ScalateSupport {

  @Autowired val beerService: BeerService = null

  get("/") {
    ssp("/beer/index", "allBeers" -> beerService.allBeers())
  }

}

package example

import example.controller.BeerController
import org.scalatra.test.scalatest.ScalatraFunSuite


class BeerFunSuite extends ScalatraFunSuite {

  addServlet(new BeerController, "/beer")


  test("retrieve beers") {
    get("/") {
      status shouldEqual 200
    }
  }

}

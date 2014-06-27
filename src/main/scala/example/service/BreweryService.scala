package example.service

import example.domain.Brewery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component("breweryService")
class BreweryService {

  @Autowired val breweryRepo: BreweryRepository = null

  def find(id: String): Brewery = {
    breweryRepo.findOne(id)
  }

}

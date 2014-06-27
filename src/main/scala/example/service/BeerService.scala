package example.service

import java.util.{List => JList}

import com.couchbase.client.protocol.views.Query
import example.domain.Beer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * BeerService
 * @author sunghyouk.bae@gmail.com
 */
@Component("beerService")
class BeerService {

  private val DEFAULT_LIMIT = 100

  @Autowired val beerRepo: BeerRepository = null

  def allBeers(limit: Int = DEFAULT_LIMIT): JList[Beer] = {
    val query = new Query().setLimit(limit)
    beerRepo.all(query)
  }
}

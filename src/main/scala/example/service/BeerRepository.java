package example.service;

import com.couchbase.client.protocol.views.Query;
import example.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer, String> {

    List<Beer> all(Query query);
}

package example

import java.util

import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories

@Configuration
@EnableCouchbaseRepositories
class DatabaseConfig extends AbstractCouchbaseConfiguration {

  override def bootstrapHosts(): util.List[String] = util.Arrays.asList("127.0.0.1")

  override def getBucketPassword: String = ""

  override def getBucketName: String = "beer-sample"
}

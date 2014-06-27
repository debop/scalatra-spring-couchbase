package example.domain


import com.google.common.base.Objects
import org.springframework.data.couchbase.core.mapping.{Document, Field}

import scala.beans.BeanProperty

@Document
class Brewery {

  @Field
  @BeanProperty
  var name: String = _

  @Field
  @BeanProperty
  var city: String = _

  @Field
  @BeanProperty
  var state: String = _

  @Field
  @BeanProperty
  var code: String = _

  @Field
  @BeanProperty
  var country: String = _

  @Field
  @BeanProperty
  var description: String = _

  override def toString: String =
    Objects.toStringHelper(this)
    .add("name", name)
    .add("city", city)
    .add("state", state)
    .add("code", code)
    .add("country", country)
    .add("description", description)
    .toString
}

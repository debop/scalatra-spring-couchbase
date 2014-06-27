package example.domain

import com.google.common.base.Objects
import org.springframework.data.couchbase.core.mapping.{Document, Field}

import scala.beans.BeanProperty

@Document
class Beer {

  @Field
  @BeanProperty
  var name: String = _

  @Field
  @BeanProperty
  var avg: Float = _

  @Field("brewry_id")
  @BeanProperty
  var brewery: String = _

  @Field
  @BeanProperty
  var description: String = _

  override def toString: String = {
    Objects.toStringHelper(this)
    .add("name", name)
    .add("avg", avg)
    .add("brewery", brewery)
    .add("description", description)
    .toString
  }

}

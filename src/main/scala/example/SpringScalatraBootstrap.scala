package example

import javax.servlet.ServletContext

import example.annotations.ServletPath
import org.scalatra.{LifeCycle, ScalatraServlet}
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import scala.collection.JavaConverters._


abstract class SpringScalatraBootstrap extends LifeCycle {

  def configClasses: Array[Class[_]]

  var appContext: ApplicationContext = _

  def loadAppContext() = {
    appContext = new AnnotationConfigApplicationContext(configClasses: _*)
  }

  override def init(context: ServletContext) {
    loadAppContext()
    val resources = appContext.getBeansWithAnnotation(classOf[ServletPath])
    resources.values().asScala.foreach {
      case servlet: ScalatraServlet =>
        var path = servlet.getClass.getAnnotation(classOf[ServletPath]).value()
        if (!path.startsWith("/")) path = "/" + path
        context.mount(servlet, path)
      case _ =>
    }
  }
}

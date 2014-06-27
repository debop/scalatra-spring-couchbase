package example.launcher

import java.net.InetSocketAddress

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import org.slf4j.LoggerFactory

/**
 * JettyLauncher
 * @author debop created at 2014. 6. 17.
 */
trait JettyLauncherSupport extends App {

  def hostname: String = "localhost"
  def port: Int = 8080
  def contextPath: String = "/"
  def resourceBase: String = "src/main/webapp"

  private lazy val log = LoggerFactory.getLogger(getClass)

  try {
    log.info(s"Start jetty web server. " +
             s"host=$hostname, port=$port, contextPath=$contextPath, resourceBase=$resourceBase")

    val server = new Server(new InetSocketAddress(hostname, port))
    server.setStopAtShutdown(true)

    //    val connector = new NetworkTrafficServerConnector(server)
    //    connector.setHost(hostname)
    //    connector.setPort(port)
    //    connector.setIdleTimeout(90000)
    //    server.addConnector(connector)

    val context = new WebAppContext()
    context.setServer(server)
    context.setContextPath(contextPath)
    context.setResourceBase(resourceBase)

    context.addEventListener(new ScalatraListener())
    server.setHandler(context)

    server.start()
    log.info("Start jetty web server")

    server.join()

  } catch {
    case t: Throwable => log.error("JettyLauncherSupport ERROR", t)
  }
}

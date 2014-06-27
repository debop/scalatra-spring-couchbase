package example

import example.launcher.JettyLauncherSupport


object JettyLauncher extends JettyLauncherSupport {

  override def resourceBase: String = "src/main/webapp"

}

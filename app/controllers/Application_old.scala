package controllers

import play.api.mvc._

class Application_old extends Controller {

  def index = Action {
    Ok(views.html.index("Bienvenue sur Cavavin"))
  }

}

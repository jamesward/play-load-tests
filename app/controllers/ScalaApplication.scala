package controllers

import play.api.mvc.{BodyParsers, BodyParser, Action, Controller}
import play.api.libs.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.iteratee.Iteratee

object ScalaApplication extends Controller {
  
  
  def basic = Action {
    Ok("")
  }

  def sleep(millis: Long) = Action {
    Async {
      Promise.timeout(Ok, millis)
    }
  }
  
  def post() = Action(BodyParser { rh =>
    Iteratee.ignore[Array[Byte]].map { _ =>
      Right(Unit)
    }
  }) { request =>
    Ok
  }

}

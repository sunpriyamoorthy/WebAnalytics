package com.hm.routes
import spray.http.{AllOrigins, DateTime, HttpCookie}
import spray.http.{DateTime, HttpCookie}
import spray.routing.HttpService

/**
  * Created by hari on 21/2/17.
  */
trait CookieHandler extends HttpService{

  val random=new scala.util.Random
  def cookieHandle= optionalCookie("abc"){

    case Some(cookie) => setSessionCookie(cookie.content)

    case None => setSessionCookie((random.nextInt).toString)

  }


  def setSessionCookie(cookieContent:String) = {
    val expiresTimestamp = System.currentTimeMillis() +(1000*60*60*24*5)
    setCookie(new HttpCookie(
      path = Some("/"),
      content = cookieContent,
      name = "abc",
      maxAge = Some(expiresTimestamp),
      expires = Some(DateTime(expiresTimestamp))
    )){
      complete("")
    }
  }

}

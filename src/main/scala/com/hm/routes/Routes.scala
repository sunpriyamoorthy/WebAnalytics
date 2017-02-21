package com.hm.routes

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor
import spray.http.{AllOrigins, DateTime, HttpCookie}
import spray.http.MediaTypes.`text/html`
import spray.routing.HttpService
import spray.http.AllOrigins
import spray.http.HttpHeaders.{`Access-Control-Allow-Headers`, `Access-Control-Allow-Origin`}

/**
  * Created by hari on 17/2/17.
  */
trait Routes extends HttpService with CookieHandler with UserHandler
  {




  def route =  {
    respondWithHeaders(List(
      `Access-Control-Allow-Origin`(AllOrigins),
      `Access-Control-Allow-Headers`("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
    )) {
      path("bypage") {
        cookieHandle
      } ~ path("byuser") {
        cookieHandle
      } ~ path("") {

        get {
          respondWithMediaType(`text/html`) {
            // XML is marshalled to `text/xml` by default, so we simply override here
            complete {
              <html>
                <body>
                  <h1>welcome to WebAnalytics :)</h1>
                </body>
              </html>
            }
          }
        }
      }
    }


  }


}

package com.hm.routes

import spray.http.MediaTypes.`text/html`
import spray.routing.HttpService

/**
  * Created by hari on 17/2/17.
  */
trait Routes extends HttpService
  {



  val route =
path("") {

      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>welcome to Todo :)</h1>
              </body>
            </html>
          }
        }
      }
    }












}

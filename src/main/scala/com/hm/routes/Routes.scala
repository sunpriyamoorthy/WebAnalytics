package com.hm.routes
import spray.http.AllOrigins
import spray.http.HttpHeaders.{`Access-Control-Allow-Headers`, `Access-Control-Allow-Origin`}
import spray.http.MediaTypes.`text/html`
import spray.routing.HttpService

/**
  * Created by hari on 17/2/17.
  */
trait Routes extends HttpService {


  val route = options {
    respondWithHeaders(List(
      `Access-Control-Allow-Origin`(AllOrigins),
      `Access-Control-Allow-Headers`("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
    )) {
      complete("Options Request")
    }
  }~ path("") {
    respondWithHeaders(List(
      `Access-Control-Allow-Origin`(AllOrigins),
      `Access-Control-Allow-Headers`("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
    )) {
    respondWithMediaType(`text/html`) {
        // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          <html>
            <body>
              <h1>welcome to Todo :)</h1>
            </body>
          </html>
        }
      }
    }
  }~ path("test") {
    respondWithHeaders(List(
      `Access-Control-Allow-Origin`(AllOrigins),
      `Access-Control-Allow-Headers`("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
    ))


      headerValueByName("User-Agent") { userAgent =>
        headerValueByName("referer") { referer =>
          optionalCookie("ckName") {
            case Some(cookie) => complete("referer : "+referer+" ua : "+userAgent+" cookie : "+cookie.content)
            case None => complete("referer : "+referer+" ua : "+userAgent)
          }
        }
      }
    }

// Method, domainName, path, cookie, ip,ua
}














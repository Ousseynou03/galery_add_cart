package sncAddCart

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ScnAddCart extends Simulation{

  private val host: String = System.getProperty("urlCible", "https://sapapi-pp.galerieslafayette.com")


  val httpProtocol = http.baseUrl(host)
    .userAgentHeader("TESTS-DE-PERF-ADD-CART")


  val scnSelectTaille = scenario("Sélection de la taille").exec(SelectTaille.scnSelectTaille)
  val scnAjoutPanier = scenario("Ajout du panier").exec(CreateCart.scnAjoutPanier)


  setUp(
    scnSelectTaille.inject(atOnceUsers(1)),
    scnAjoutPanier.inject(atOnceUsers(1)),


  ).protocols(httpProtocol)

}

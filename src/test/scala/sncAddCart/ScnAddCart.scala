package sncAddCart

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ScnAddCart extends Simulation{

  private val host : String = System.getProperty("urlCible", "https://sapapi-int.galerieslafayette.com")


  val httpProtocol = http.baseUrl(host)
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("TESTS-DE-PERF-ADD-CART")


  val scnSelectTaille = scenario("Sélection de la taille").exec(SelectTaille.scnSelectTaille)
  val scnCreatePanier = scenario("Création du panier").exec(CreateCart.scnCreatePanier)
  val scnAddCart = scenario("Ajout du produit au panier").exec(CreateCart.scnAddCart)
  val scnAffichageProduct = scenario("Affichage du mini panier").exec(CreateCart.scnAffichageProduct)


  setUp(
    scnSelectTaille.inject(atOnceUsers(1)),
    scnCreatePanier.inject(atOnceUsers(1)),
    scnAddCart.inject(atOnceUsers(1)),
    scnAffichageProduct.inject(atOnceUsers(1)),

  ).protocols(httpProtocol)

}

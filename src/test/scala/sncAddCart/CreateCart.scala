package sncAddCart

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import sncAddCart.SelectTaille.jddDataProductVariant

object CreateCart {


  private val FichierPath: String = System.getProperty("dataDir", "data/")
  private val FichierJddPropductVariant: String = "product_variant_codes.csv"

  private val groupBy: String = System.getProperty("groupBy", "CreateCart")

  val jddDataProductVariant = csv(FichierPath + FichierJddPropductVariant).circular


  ////////////////////////////
  // Création du panier /////
  //////////////////////////
  def createCart(): ChainBuilder = {
  exec { session => session.set("detail", groupBy) }
      .doIfEqualsOrElse(session => session("detail").as[String], "Cart") {
        exec { session => session.set("LeGroup", "Cart") }
      } {
        exec { session => session.set("LeGroup", "Cart") }
      }
    .exec(http("Create Cart")
      .post("/occ/v2/gl-fr/users/anonymous/carts?fields=DEFAULT%2CpotentialProductPromotions%2CappliedProductPromotions(FULL)%2CpotentialOrderPromotions%2CappliedOrderPromotions%2Centries(totalPrice(formattedValue)%2Cproduct(images(FULL)%2Cstock(FULL))%2CbasePrice(formattedValue%2Cvalue)%2Cupdateable)%2CtotalPrice(formattedValue)%2CtotalItems%2CtotalPriceWithTax(formattedValue)%2CtotalDiscounts(value%2CformattedValue)%2CsubTotal(formattedValue)%2CdeliveryItemsQuantity%2CdeliveryCost(formattedValue)%2CtotalTax(formattedValue%2C%20value)%2CpickupItemsQuantity%2Cnet%2CappliedVouchers%2CproductDiscounts(formattedValue)%2Cuser&lang=fr&curr=EUR")
      .body(StringBody("{}"))
      .asJson
      .check(jsonPath("$.code").saveAs("cart_code"))
      .check(jsonPath("$.guid").saveAs("cart_guid"))
    )
  }



  //////////////////////////
  // Ajout du produit au panier
  /////////////////////////////
  def addToCart(): ChainBuilder = {
    exec { session => session.set("detail", groupBy) }
      .doIfEqualsOrElse(session => session("detail").as[String], "Cart") {
        exec { session => session.set("LeGroup", "Cart") }
      } {
        exec { session => session.set("LeGroup", "Cart") }
      }
    .feed(jddDataProductVariant)
      .exec(http("Add to Cart")
        .post("/occ/v2/gl-fr/users/anonymous/carts/${cart_guid}/entries?lang=fr&curr=EUR")
        .body(StringBody(
          """{
            |  "quantity": 1,
            |  "product": {
            |    "code": "${product_variant_code}"
            |  }
            |}""".stripMargin
        ))
        .asJson
      ).pause(5)
  }




  //////////////////////////////////
  /// Affichage du mini panier ////
  ///////////////////////////////

  def viewMiniCart(): ChainBuilder = {
    exec { session => session.set("detail", groupBy) }
      .doIfEqualsOrElse(session => session("detail").as[String], "Cart") {
        exec { session => session.set("LeGroup", "Cart") }
      } {
        exec { session => session.set("LeGroup", "Cart") }
      }
    .exec(http("View Mini Cart")
      .get("/occ/v2/gl-fr/users/anonymous/carts/${cart_guid}?fields=DEFAULT,potentialProductPromotions,appliedProductPromotions,potentialOrderPromotions(FULL),appliedOrderPromotions(FULL),entries(totalPrice(formattedValue),product(logisticFamily,images(FULL),stock(FULL),price(formattedValue,regularRetailPrice)),basePrice(formattedValue,value),updateable),totalPrice(formattedValue),totalItems,totalPriceWithTax(formattedValue),totalDiscounts(value,formattedValue),subTotal(formattedValue),deliveryItemsQuantity,deliveryCost(formattedValue),totalTax(formattedValue,%20value),pickupItemsQuantity,net,appliedVouchers,productDiscounts(formattedValue),user,saveTime,name,description,deliveryMode,deliveryOrderGroups(pointOfDelivery(FULL))&lang=fr&curr=EUR")
      .check(status is 200)
    ).pause(5)
  }


  val scnAjoutPanier = scenario("Test Perf Add Cart")
    .exec(createCart())
    .exec(addToCart())
    .exec(viewMiniCart())







}

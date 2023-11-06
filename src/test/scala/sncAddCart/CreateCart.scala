package sncAddCart

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import sncAddCart.SelectTaille.jddDataProductVariant

object CreateCart {


  private val FichierPath: String = System.getProperty("dataDir", "data/")
  private val FichierJddPropductVariant: String = "product_variant_codes.csv"

  val jddDataProductVariant = csv(FichierPath + FichierJddPropductVariant).circular


  ////////////////////////////
  // Création du panier /////
  //////////////////////////

  val scnCreatePanier = scenario("CreateCart")
    .exec(http("Create Cart")
      .post("/occ/v2/gl-fr/users/anonymous/carts?fields=DEFAULT%2CpotentialProductPromotions%2CappliedProductPromotions(FULL)%2CpotentialOrderPromotions%2CappliedOrderPromotions%2Centries(totalPrice(formattedValue)%2Cproduct(images(FULL)%2Cstock(FULL))%2CbasePrice(formattedValue%2Cvalue)%2Cupdateable)%2CtotalPrice(formattedValue)%2CtotalItems%2CtotalPriceWithTax(formattedValue)%2CtotalDiscounts(value%2CformattedValue)%2CsubTotal(formattedValue)%2CdeliveryItemsQuantity%2CdeliveryCost(formattedValue)%2CtotalTax(formattedValue%2C%20value)%2CpickupItemsQuantity%2Cnet%2CappliedVouchers%2CproductDiscounts(formattedValue)%2Cuser&lang=fr&curr=EUR")
      .body(StringBody("{}")).asJson
      .check(jsonPath("$.code").saveAs("cart_code"))
      .check(jsonPath("$.guid").saveAs("cart_guid"))
    ).pause(5)


  //////////////////////////
  // Ajout du produit au panier
  /////////////////////////////
  val scnAddCart = scenario("AddToCart")
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



  //////////////////////////////////
  /// Affichage du mini panier ////
  ///////////////////////////////
  val scnAffichageProduct = scenario("Vue Mini Cart")
    .exec(http("View Mini Cart")
      .get("/occ/v2/gl-fr/users/anonymous/carts/${cart_guid}?fields=DEFAULT,potentialProductPromotions,appliedProductPromotions,potentialOrderPromotions(FULL),appliedOrderPromotions(FULL),entries(totalPrice(formattedValue),product(logisticFamily,images(FULL),stock(FULL),price(formattedValue,regularRetailPrice)),basePrice(formattedValue,value),updateable),totalPrice(formattedValue),totalItems,totalPriceWithTax(formattedValue),totalDiscounts(value,formattedValue),subTotal(formattedValue),deliveryItemsQuantity,deliveryCost(formattedValue),totalTax(formattedValue,%20value),pickupItemsQuantity,net,appliedVouchers,productDiscounts(formattedValue),user,saveTime,name,description,deliveryMode,deliveryOrderGroups(pointOfDelivery(FULL))&lang=fr&curr=EUR")
      .check(status is 200)
    ).pause(5)






}

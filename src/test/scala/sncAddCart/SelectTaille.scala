package sncAddCart

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.recorder.internal.bouncycastle.est.Source

object SelectTaille {

  private val FichierPath: String = System.getProperty("dataDir", "data/")
  private val FichierJddPrpductVariant: String = "product_variant_codes.csv"

  val jddDataProductVariant = csv(FichierPath + FichierJddPrpductVariant).circular



  //Séléction de la taille
  val scnSelectTaille = scenario("GetTailleProduct")
    .exec(flushSessionCookies)
    .exec(flushHttpCache)
    .exec(flushCookieJar)
    .feed(jddDataProductVariant)
   // .feed(jddDataCustomerId)
    .exec { session =>
      println("Product Variant :" + session("product_variant_code").as[String])
      session
    }
    .exec(
      http("Get Product Taille")
        .get("/occ/v2/gl-fr/products/${product_variant_code}?fields=code,name,summary,price(formattedValue,DEFAULT),images(DEFAULT,galleryIndex),baseProduct,purchasable,baseOptions(DEFAULT),variantOptions(DEFAULT),variantType,priceRange(DEFAULT),averageRating,stock(DEFAULT),potentialPromotions(FULL),capacity,description,availableForPickup,url,numberOfReviews,manufacturer,categories(FULL),multidimensional,tags,exclusiveProduct,newProduct,brand,productLine,discountFamily,size,displaySizeGuide,goForGoodList,isMarketPlaceProduct,offerType,logisticFamily(FULL),offers(FULL),offersSummary(FULL),maxOrderQuantity,ecoPart,privateCopie,energyInformation,sapCode,gender,ages,luxury&lang=fr&curr=EUR")
        .check(status is 200)
    ).pause(5)




}

package org.justinhj

import io.grpc.ManagedChannelBuilder
import com.example.shoppingcart.shoppingcart.GetShoppingCart
import com.example.shoppingcart.shoppingcart.ShoppingCartGrpc
import com.example.shoppingcart.shoppingcart.Cart
import com.example.shoppingcart.shoppingcart.AddLineItems
import com.example.shoppingcart.shoppingcart.LineItem

object Myshoppingcartclient {

 def main(args: Array[String]) {

  val host = "localhost"
  val port = 9000

  val channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext.build
  val blockingStub = ShoppingCartGrpc.blockingStub(channel)

  val userId = "Justin1"

   // Put multiple items in the cart
  val addResult = blockingStub.addItems(
    AddLineItems(userId,
      List(LineItem("BARN109-120", "Barney the Dinosaur, Large plushy", 1),
            LineItem("DYSO101-121", "Dyson Vaccuum Super", 2),
            LineItem("CIND129-532", "Cindy Doll - Go to Party", 1))))

  println(addResult)

  // Get a Cart
  val cart: Cart = blockingStub.getCart(GetShoppingCart(userId))
  println(cart)

  // Can also do this async like this

  // val stub = ShoppingCartGrpc.stub(channel)
  // val f: Future[Cart] = stub.getCart(request)
  // f onComplete println

 }
}

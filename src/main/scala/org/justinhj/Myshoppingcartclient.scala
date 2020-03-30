package org.justinhj

import io.grpc.ManagedChannelBuilder
import com.example.shoppingcart.shoppingcart.GetShoppingCart
import com.example.shoppingcart.shoppingcart.ShoppingCartGrpc
import com.example.shoppingcart.shoppingcart.Cart

object Myshoppingcartclient {

 def main(args: Array[String]) {

  val host = "localhost"
  val port = 9000

  println("Making call")

  val channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext.build

  val request = GetShoppingCart(userId = "Justin1")

  val blockingStub = ShoppingCartGrpc.blockingStub(channel)
  val reply: Cart = blockingStub.getCart(request)
  println(reply)

 }
}

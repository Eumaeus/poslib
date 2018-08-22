package edu.furman.classics.poslib

import cats.syntax.either._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import org.scalatest.FlatSpec

class PosElementSpec extends FlatSpec {

  "The POS Element class" should "build" in {
    val pose:PosElement = PosElement("inf", "infinitive", 'n')
    assert( pose.short == "inf" )
    assert( pose.long == "infinitive" )
    assert( pose.tag == 'n' )
  }

  it should "create an empty element" in {
    val pose:PosElement = PosElement()
    assert( pose.short == "none" )
    assert( pose.long == "None" )
    assert( pose.tag == '-' )
  }

  
  


}

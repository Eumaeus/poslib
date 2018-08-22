package edu.furman.classics.poslib

import org.scalatest._

class ExportTest extends FlatSpec {

   "The POS library" should "compile" in {
   val pose:PosElement = PosElement()
    assert( pose.short == "none" )
    assert( pose.long == "None" )
    assert( pose.tag == '-' )
  }

}

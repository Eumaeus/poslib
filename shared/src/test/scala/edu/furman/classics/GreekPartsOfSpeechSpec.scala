package edu.furman.classics.poslib

import cats.syntax.either._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import org.scalatest.FlatSpec

class GreekPartsOfSpeechSpec extends FlatSpec {

  "The PartOfSpeech class" should "build" in {
    val parts:GreekPartsOfSpeech = GreekPartsOfSpeech()

    assert(parts.partsOfSpeech.filter(_("short") == "art").size == 1)

  }

it should "create a PartOfSpeech object from a postag" in {
    val parts:GreekPartsOfSpeech = GreekPartsOfSpeech()
    val postag:String = "v1spai---"
    assert( parts.posFromTag(postag).toPosTag == postag )
  }  


}

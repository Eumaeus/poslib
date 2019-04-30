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
    val postag:String = "v3spsa---"
    assert( parts.posFromTag(postag).toPosTag == postag )
  }  

  it should "throw a clear error if the tag has too few components" in {
    val parts:GreekPartsOfSpeech = GreekPartsOfSpeech()
    val postag:String = "v1spai--" // one too few
    val caught = intercept[PosException] {
		val pos:GreekPartOfSpeech = parts.posFromTag(postag)
	}
	val expectedException:String = "edu.furman.classics.poslib.PosException: 'v1spai--' has only 8 elements, instead of the 9 it should have."
	assert ( caught.toString == expectedException )
  }

  it should "throw a clear error if the tag has too many components" in {
    val parts:GreekPartsOfSpeech = GreekPartsOfSpeech()
    val postag:String = "v1spai----" // one too many
    val caught = intercept[PosException] {
		val pos:GreekPartOfSpeech = parts.posFromTag(postag)
	}
	val expectedException:String = "edu.furman.classics.poslib.PosException: 'v1spai----' has 10 elements, instead of the 9 it should have."
	assert ( caught.toString == expectedException )
  }


}

package edu.furman.classics.poslib

import cats.syntax.either._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import org.scalatest.FlatSpec

class GreekPartOfSpeechSpec extends FlatSpec {

  "The GreekPartOfSpeech class" should "build an empty part of speech" in {
    val pos:GreekPartOfSpeech = GreekPartOfSpeech(
      None,
      None,
      None,
      None,
      None,
      None,
      None,
      None,
      None
    )

    assert(pos.toPosTag == "---------")

  }

  it should "built a legitimate part of speech" in {
    val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
    )
    assert( pos.toPosTag == "v1spai---")
  }

  it should "fail on an invalid pos" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("XXX","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }


  it should "fail on an invalid person" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'x')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }


  it should "fail on an invalid number" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","xxx",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }


  it should "fail on an invalid tense" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("xxx","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }


  it should "fail on an invalid voice" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'x')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }

  it should "fail on an invalid mood" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","xxx",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }


  it should "fail on an invalid gender" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("xxx","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-'))
      )
    }
  }

  it should "fail on an invalid grammaticalcase" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'x')),
        Some(PosElement("none","None",'-'))
      )
    }
  }

  it should "fail on an invalid degree" in {
    assertThrows[PosException] {
      val pos:GreekPartOfSpeech = GreekPartOfSpeech(
        Some(PosElement("verb","Verb",'v')),
        Some(PosElement("1st","First Person",'1')),
        Some(PosElement("sg","Singular",'s')),
        Some(PosElement("pr","Present",'p')),
        Some(PosElement("act","Active",'a')),
        Some(PosElement("ind","Indicative",'i')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","None",'-')),
        Some(PosElement("none","SSS",'-'))
      )
    }
  }

  /*
  pos:Option[PosElement],
  person:Option[PosElement],
  number:Option[PosElement],
  tense:Option[PosElement],
  voice:Option[PosElement],
  mood:Option[PosElement],
  gender:Option[PosElement],
  grammaticalcase:Option[PosElement],
  degree:Option[PosElement]
  */

  


}

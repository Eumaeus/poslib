package edu.furman.classics
import scala.scalajs.js
import scala.scalajs.js.annotation._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe.parser.decode

package poslib {

  /** A Class for creating a GreekPartOfSpeech object
  *
  * @constructor create a new [[GreekPartOfSpeech]] object 
  */
  @JSExportAll case class GreekPartOfSpeech(
	pos:Option[PosElement],
	person:Option[PosElement],
	number:Option[PosElement],
	tense:Option[PosElement],
	voice:Option[PosElement],
	mood:Option[PosElement],
	gender:Option[PosElement],
	grammaticalcase:Option[PosElement],
	degree:Option[PosElement]
) {

    // test valid number
    // test valid tense
    // test valid voice
    // test valid mood
    // test valid gender
    // test valid grammaticalcase
    // test valid degree

	override def toString:String = {
		s"${this.toLabel}: ( ${this.toPosTag} )"
	}

    // Test validity	
    val parts:GreekPartsOfSpeech = GreekPartsOfSpeech()


    // test valid part of speech
    val testPos:Map[String,String] = {
    	this.pos match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString  )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.partsOfSpeech.contains(testPos)) ) { throw new PosException(s"Invalid part of speech: ${testPos}")}

    // test valid person
    val testPerson:Map[String,String] = {
    	this.person match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.persons.contains(testPerson)) ) { throw new PosException(s"Invalid person: ${testPerson}")}
   
    // test valid number
    val testNumber:Map[String,String] = {
    	this.number match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.numbers.contains(testNumber)) ) { throw new PosException(s"Invalid number: ${testNumber}")}

    // test valid tense
    val testTense:Map[String,String] = {
    	this.tense match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.tenses.contains(testTense)) ) { throw new PosException(s"Invalid tense: ${testTense}")}

    // test valid voice
    val testVoice:Map[String,String] = {
    	this.voice match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.voices.contains(testVoice)) ) { throw new PosException(s"Invalid voice: ${testVoice}")}

    // test valid mood
    val testMood:Map[String,String] = {
    	this.mood match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.moods.contains(testMood)) ) { throw new PosException(s"Invalid mood: ${testMood}")}

    // test valid gender
    val testGender:Map[String,String] = {
    	this.gender match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.genders.contains(testGender)) ) { throw new PosException(s"Invalid gender: ${testGender}")}

    // test valid grammaticalcase
    val testCase:Map[String,String] = {
    	this.grammaticalcase match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.cases.contains(testCase)) ) { throw new PosException(s"Invalid grammatical case: ${testCase}")}

    // test valid degree
    val testDegree:Map[String,String] = {
    	this.degree match {
    		case Some(p) => Map("short" -> p.short, "long" -> p.long, "tag" -> p.tag.toString )
    		case None => Map("short" -> "none", "long" -> "None", "tag" -> "-")
    	}
    }
    if ( !(parts.degrees.contains(testDegree)) ) { throw new PosException(s"Invalid degree: ${testDegree}")}

	def toPosTag:String = {
		val posStr:Char = {
			pos match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val personStr:Char = {
			person match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val numberStr:Char = {
			number match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val tenseStr:Char = {
			tense match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val voiceStr:Char = {
			voice match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val moodStr:Char = {
			mood match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val genderStr:Char = {
			gender match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val grammaticalcaseStr:Char = {
			grammaticalcase match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		val degreeStr:Char = {
			degree match {
				case Some(s) => s.tag
				case None => '-'
			}
		}
		s"${posStr}${personStr}${numberStr}${tenseStr}${voiceStr}${moodStr}${genderStr}${grammaticalcaseStr}${degreeStr}"
	}

	def toLabel:String = {
	val posStr:String = {
			pos match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val personStr:String = {
			person match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val numberStr:String = {
			number match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val tenseStr:String = {
			tense match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val voiceStr:String = {
			voice match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val moodStr:String = {
			mood match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val genderStr:String = {
			gender match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val grammaticalcaseStr:String = {
			grammaticalcase match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val degreeStr:String = {
			degree match {
				case Some(s) => s.long + ", "
				case None => ""
			}
		}
		val commaString:String = s"Part of Speech: ${posStr}${personStr}${numberStr}${tenseStr}${voiceStr}${moodStr}${genderStr}${grammaticalcaseStr}${degreeStr}"

		commaString.takeRight(2) match {
			case ", " => commaString.dropRight(2)
			case _ => commaString
		}
	}


}


}

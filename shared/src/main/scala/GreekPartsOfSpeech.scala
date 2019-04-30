package edu.furman.classics
import scala.scalajs.js
import scala.scalajs.js.annotation._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe.parser.decode

package poslib {

  /** A Class for creating a GreekPartsOfSpeech class
  *
  * @constructor create a new [[GreekPartsOfSpeech]] class 
  */
  @JSExportAll case class GreekPartsOfSpeech() {

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

  		def posFromTag(postag:String):GreekPartOfSpeech = {
  			val tags:Vector[Char] = postag.toVector

  			if (tags.size < 9){
  				throw new PosException(s"""'${postag}' has only ${tags.size} elements, instead of the 9 it should have.""")
  			}
  			if (tags.size > 9){
  				throw new PosException(s"""'${postag}' has ${tags.size} elements, instead of the 9 it should have.""")
  			}


			val posChar:String = tags(0).toString	
			val personChar:String = tags(1).toString
			val numberChar:String = tags(2).toString
			val tenseChar:String = tags(3).toString
			val moodChar:String = tags(4).toString
			val voiceChar:String = tags(5).toString
			val genderChar:String = tags(6).toString
			val caseChar:String = tags(7).toString
			val degreeChar:String = tags(8).toString

			val posEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = partsOfSpeech.filter(_("tag") == posChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", posChar(0).toChar))
						}
					}
				}
				el
			}

			val personEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = persons.filter(_("tag") == personChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", personChar(0).toChar))
						}
					}
				}
				el
			}
			val numberEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = numbers.filter(_("tag") == numberChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
					}
						case _ => {
							Some(PosElement("not found", "not found", numberChar(0).toChar))
						}
					}
				}
				el
			}
			val tenseEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = tenses.filter(_("tag") == tenseChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", tenseChar(0).toChar))
						}
					}
				}
				el
			}
			val voiceEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = voices.filter(_("tag") == voiceChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", voiceChar(0).toChar))
						}
					}
				}
				el
			}
			val moodEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = moods.filter(_("tag") == moodChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", moodChar(0).toChar))
						}
					}
				}
				el
			}
			val genderEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = genders.filter(_("tag") == genderChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", genderChar(0).toChar))
						}
					}
				}
				el
			}
			val caseEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = cases.filter(_("tag") == caseChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", caseChar(0).toChar))
						}
					}
				}
				el
			}
			val degreeEl:Option[PosElement] = {
				val gotIt:Vector[Map[String,String]] = degrees.filter(_("tag") == degreeChar )
				val el:Option[PosElement] = {
					gotIt.size match {
						case 1 => {
							if (gotIt(0)("tag") != "-") {
								Some(PosElement(gotIt(0)("short"), gotIt(0)("long"), gotIt(0)("tag")(0).toChar))
							} else {
								None
							}
						}
						case _ => {
							Some(PosElement("not found", "not found", degreeChar(0).toChar))
						}
					}
				}
				el
			}

  			val pos:GreekPartOfSpeech = GreekPartOfSpeech(
  				posEl,
  				personEl,
  				numberEl,
  				tenseEl,	
  				moodEl,
  				voiceEl,
  				genderEl,		
  				caseEl,
  				degreeEl
  			)
  			pos
  		}

		val posSchema:Vector[Map[String,String]] = Vector(
			Map("short" -> "pos", "long" -> "Part of Speech"),
			Map("short" -> "pers", "long" -> "Person"),
			Map("short" -> "num", "long" -> "Number"),
			Map("short" -> "tense", "long" -> "Tense"),
			Map("short" -> "mood", "long" -> "Mood"),
			Map("short" -> "voice", "long" -> "Voice"),
			Map("short" -> "gend", "long" -> "Gender"),
			Map("short" -> "case", "long" -> "Case"),
			Map("short" -> "degree", "long" -> "Degree")
		)

		val partsOfSpeech:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "art", "long" -> "Article", "tag" -> "l"),
			Map("short" -> "noun", "long" -> "Noun", "tag" -> "n"),
			Map("short" -> "adj", "long" -> "Adjective", "tag" -> "a"),
			Map("short" -> "pron", "long" -> "Pronoun", "tag" -> "p"),
			Map("short" -> "verb", "long" -> "Verb", "tag" -> "v"),
			Map("short" -> "adv", "long" -> "Adverb", "tag" -> "d"),
			Map("short" -> "prep", "long" -> "Preposition", "tag" -> "r"),
			Map("short" -> "conj", "long" -> "Conjunction", "tag" -> "c"),
			Map("short" -> "int", "long" -> "Interjection", "tag" -> "i"),
			Map("short" -> "punct", "long" -> "Punctuation", "tag" -> "u"),
			Map("short" -> "irreg", "long" -> "Irregular", "tag" -> "x")
		)

		val persons:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "1st", "long" -> "First Person", "tag" -> "1"),
			Map("short" -> "2nd", "long" -> "Second Person", "tag" -> "2"),
			Map("short" -> "3rd", "long" -> "Third Person", "tag" -> "3")
		)

		val numbers:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "sg", "long" -> "Singular", "tag" -> "s"),
			Map("short" -> "pl", "long" -> "Plural", "tag" -> "p"),
			Map("short" -> "dl", "long" -> "Dual", "tag" -> "d")
		)

		val tenses:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "pr", "long" -> "Present", "tag" -> "p"),
			Map("short" -> "imp", "long" -> "Imperfect", "tag" -> "i"),
			Map("short" -> "perf", "long" -> "Perfect", "tag" -> "r"),
			Map("short" -> "pqpf", "long" -> "Pluperfect", "tag" -> "l"),
			Map("short" -> "fex", "long" -> "Future Perfect", "tag" -> "t"),
			Map("short" -> "fut", "long" -> "Future", "tag" -> "f"),
			Map("short" -> "aor", "long" -> "Aorist", "tag" -> "a")
		)

		val moods:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "ind", "long" -> "Indicative", "tag" -> "i"),
			Map("short" -> "sub", "long" -> "Subjunctive", "tag" -> "s"),
			Map("short" -> "inf", "long" -> "Infinitive", "tag" -> "n"),
			Map("short" -> "imp", "long" -> "Imperative", "tag" -> "m"),
			Map("short" -> "part", "long" -> "Participle", "tag" -> "p"),
			Map("short" -> "opt", "long" -> "Optative", "tag" -> "o")
		)

		val voices:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "act", "long" -> "Active", "tag" -> "a"),
			Map("short" -> "mid", "long" -> "Middle", "tag" -> "m"),
			Map("short" -> "Pass", "long" -> "Passive", "tag" -> "p"),
			Map("short" -> "mp", "long" -> "Medio-Passive", "tag" -> "e"),
			Map("short" -> "dep", "long" -> "Depondent", "tag" -> "d")
		)

		val genders:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "masc", "long" -> "Masculine", "tag" -> "m"),
			Map("short" -> "fem", "long" -> "Feminine", "tag" -> "f"),
			Map("short" -> "neut", "long" -> "Neuter", "tag" -> "n")
		)

		val cases:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "nom", "long" -> "Nominative", "tag" -> "n"),
			Map("short" -> "gen", "long" -> "Genitive", "tag" -> "g"),
			Map("short" -> "dat", "long" -> "Dative", "tag" -> "d"),
			Map("short" -> "acc", "long" -> "Accusative", "tag" -> "a"),
			Map("short" -> "voc", "long" -> "Vocative", "tag" -> "v"),
			Map("short" -> "loc", "long" -> "Locative", "tag" -> "l")
		)

		val degrees:Vector[Map[String,String]] = Vector(
			Map("short" -> "none", "long" -> "None", "tag" -> "-"),
			Map("short" -> "pos", "long" -> "Positive", "tag" -> "p"),
			Map("short" -> "comp", "long" -> "Comparative", "tag" -> "c"),
			Map("short" -> "sup", "long" -> "Superlative", "tag" -> "s")
		)
  }


}

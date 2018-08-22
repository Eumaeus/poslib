package edu.furman.classics
import scala.scalajs.js
import scala.scalajs.js.annotation._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe.parser.decode

package poslib {

   /** A Class for creating a PosElement object
  *
  * @constructor create a new [[PosElement]] object 
  */
  @JSExportAll case class PosElement(short:String = "none", long:String = "None", tag:Char = '-')


}

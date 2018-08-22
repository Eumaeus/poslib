package edu.furman.classics

package poslib {

  case class PosException(message: String = "", cause: Option[Throwable] = None) extends Exception(message) {
	    cause.foreach(initCause)
  }

}

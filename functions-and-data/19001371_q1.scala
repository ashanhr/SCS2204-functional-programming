/*
 * 19001371
 * Functions and data
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Q1 extends App {

    val r = new Rational(2,3)
    val neg_r = r.neg

    println(neg_r.toString)
}

class Rational (x:Int, y:Int){
    def numer = x
    def denom = y

    def neg = new Rational(-1 * this.numer, denom)

    override def toString = "" + numer + "/" + denom
}
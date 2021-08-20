/*
 * 19001371
 * Functions and data
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Q2 extends App {

    val x = new Rational(3,4)
    val y = new Rational(5,8)
    val z = new Rational(2,7)

    val ans = x-y-z

    println(ans)
}

class Rational (x:Int, y:Int){

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b) 
    
    private val g = gcd(x, y)

    def numer = x/g
    def denom = y/g

    def neg = new Rational(-1 * this.numer, denom)

    def -(r:Rational) = new Rational((this.numer*r.denom)-(r.numer*this.denom),this.denom*r.denom)

    override def toString = "" + numer + "/" + denom
}
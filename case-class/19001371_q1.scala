/*
 * 19001371
 * Case Class
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Q1 extends App {

    val a = Point(0,0)
    val b = Point(0,100)

    val add = a+b
    val moved_a = a.move(1,1)
    val distance = a.distance(b)
    val inverted_b = b.invert()

    println("Addition of points a and b: " + add)
    println("Moved a: " + moved_a)
    println("Distance between a and b: " + distance)
    println("Inverted b: " + inverted_b)
}

case class Point (x:Int, y:Int){

    //function to add two points
    def +(point:Point):Point=Point(point.x + this.x,point.y + this.y)

    //function to move a point by a given distance dx and dy
    def move(dx:Int, dy:Int):Point=Point(this.x+dx,this.y+dy)

    //function to return the distance between two given points
    def distance(point:Point):Double=scala.math.sqrt((scala.math.pow((point.x - this.x),2) + scala.math.pow((point.y - this.y),2) ))

    //function to switch the x and y coordinates
    def invert():Point=Point(this.y,this.x)
}
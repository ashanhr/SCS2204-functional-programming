/*
 * 19001371
 * Q3
 */

// import readInt method in StdIn object in io package of standard library 
import scala.io.StdIn.readInt

object AddNumbers extends App{

   // method for return the addition of numbers from 1 to n
   def add(n:Int):Int = n match{
      case 1 => 1
      case _ => n + add(n-1)
   } 

   printf("Input number: ")
   var n = readInt()
   println(add(n))
}
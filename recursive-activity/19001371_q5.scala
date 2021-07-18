/*
 * 19001371
 * Q5
 */

// import readInt method in StdIn object in io package of standard library 
import scala.io.StdIn.readInt

object AddEven extends App{

   // method to get the addition of all even numbers less than given n
   def addEven(n: Int):Int = n match{
      case 0 => 0
      case x if x%2==1 => addEven(n-1)
      case _ => n + addEven(n-2)
   }

   printf("Input number: ")
   var n = readInt()
   println(addEven(n))
}
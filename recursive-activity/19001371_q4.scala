/*
 * 19001371
 * Q4
 */

// import readInt method in StdIn object in io package of standard library 
import scala.io.StdIn.readInt

object CheckOddEven extends App{

   // method to find if even
   def isEven(n: Int): Boolean = n match{
      case 0 => true
      case _ => isOdd(n-1)
   }

   // method to find if odd
   def isOdd(n: Int): Boolean = !isEven(n)

   printf("Input number: ")
   var n = readInt()
   if(isEven(n)) 
      println("Even") 
   else 
      println("Odd")
}
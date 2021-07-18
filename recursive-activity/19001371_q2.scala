/*
 * 19001371
 * Q2
 */

// import readInt method in StdIn object in io package of standard library 
import scala.io.StdIn.readInt

object PrintPrime extends App{

   // method for finding the great commond deviser of two numbers
   def gcd(x: Int, y: Int):Int = y match{
      case 0 => x;
      case _ => gcd(y, x%y)
   }

   // method for finding prime numbers
   def prime(n: Int, k: Int=2): Boolean = n match{
      case x if (x < 2) => false
      case x if(x == k) => true
      case x if gcd(x, k) > 1 => false
      case _ => prime(n, k+1)
   }

   // method for printing the prime numbers sequence
   def primeSeq(n: Int):Unit = {
      if(n>1){
         primeSeq(n-1)
         if(prime(n)) println(n)
      }
   } 

   printf("Input number: ")
   var n = readInt()
   primeSeq(n)
}
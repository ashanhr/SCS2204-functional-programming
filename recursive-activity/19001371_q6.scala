/*
 * 19001371
 * Q6
 */

// import readInt method in StdIn object in io package of standard library 
import scala.io.StdIn.readInt

object FibonacciSeq extends App{

   // method to find the n th fibonacci number
   def fib(n:Int): Int = n match{
      case 1 => 0
      case 2 => 1
      case _ => fib(n-1) + fib (n-2)
   }

   // method to print the fibonacci sequence
   def fibSeq(n:Int): Unit ={
      if(n>1) fibSeq(n-1)
      println(fib(n))
   }

   printf("Input number: ")
   var n = readInt()
   fibSeq(n)
}
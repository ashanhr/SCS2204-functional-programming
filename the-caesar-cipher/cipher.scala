/*
 * 19001371
 * The Caesar Cipher
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Cipher extends App{

    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    val E = (c:Char,key:Int,a:String)=>a((a.indexOf(c.toLower)+key)%a.size)
    
    val D = (c:Char,key:Int,a:String)=>a((a.indexOf(c.toLower)-key+a.size)%a.size)

    val cipher = (algo:(Char,Int,String)=>Char,s:String,key:Int,a:String)=>s.map(algo(_,key,a))

    var stop: Boolean = false;

    while(!stop)
    {

        print("\n-----------------MENU-----------------\n")
        print("Enter 'E' to encrypt.\n")
        print("Enter 'D' to decrypt.\n")
        print("Enter 'exit' to exit.\n")
        print("--------------------------------------\n")
        print("Choose an option: ")

        var decision: String = readLine()
        

        if(decision == "exit")
        {
            stop = true
        }else if(decision=="D")
        {
            print("Enter the string: ")
            val input: String = readLine()
            print("Enter the key: ")
            var key: Int = readInt()

            print("\nDecrypted string is: ")
            print(cipher(D,input,key,alphabet) + "\n")
        }else if(decision=="E")
        {
            print("Enter the string: ")
            val input: String = readLine()
            print("Enter the key: ")
            var key: Int = readInt()

            print("\nEncrypted string is: ")
            print(cipher(E,input,key,alphabet) + "\n")
        }else{
            print("\nWrong decision input..!\n")
        }
        
    }
}
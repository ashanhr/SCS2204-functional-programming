/*
 * 19001371
 * Functions and data
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Q3 extends App {

    val acc1 = new Account("991324567V",123456,10000.00)
    val acc2 = new Account("991324789V",123478,100000.00)

    println("Balances before the transfer :")

    println(acc1.toString)
    println(acc2.toString)

    acc1.transfer(1587.47,acc2)
    
    println("\nBalances after the transfer :")

    println(acc1.toString)
    println(acc2.toString)
}

class Account(id:String,n: Int, b: Double) {

    val nic:String=id
    val acnumber: Int = n
    var  balance: Double = b

    def withdraw( amount : Double ) = this.balance -= amount

    def deposit ( amount : Double ) = this.balance += amount

    def transfer( amount : Double , receiver : Account ): Unit = {
        this.withdraw(amount)
        receiver.deposit(amount)
    }

    override def toString = "["+nic+":"+acnumber +":"+ balance+"]"
 }
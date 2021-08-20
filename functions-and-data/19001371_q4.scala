/*
 * 19001371
 * Functions and data
 */

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Q4 extends App {

    var account = List(new Account("991324567V", 123456, 250), new Account("991324789V", 123478, -125), new Account("891326789V", 123654, 8965234.25), new Account("841326123V", 123859, 1500.00))
    var neg_account = account.filter((x) => x.balance < 0)
    var sum_balance = account.map(x => x.balance).reduce((x,y) => x + y)
    account = account.map((x) => x.interest())

    //Q4.1
    println("List of accounts with negative balnce : ")
    println(neg_account)
    
    //Q4.2
    println("\nSum of all account balances : ")
    println(sum_balance)

    //Q4.3
    println("\nFinal balances of all accounts after apply the interest function : ")
    println(account)
    
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

    def interest(): Account = {
            if(this.balance >= 0 ){
                this.balance  += this.balance * 0.05
                return this
            }
            else {
                this.balance += balance * 0.1
                return this
            }
        }

    override def toString = "["+nic+":"+acnumber +":"+ balance+"]"
 }
/*
 * 19001371
 * Q3
 */

object Wholesale extends App{

  def discountedPrice(price:Double):Double=price*0.6;

  def costForBooks(price:Double,count:Int):Double=count*discountedPrice(price);
  
  def shippingCost(count:Int):Double=
    if(count>50)
      3.00+((count-50)*0.75);
    else 
      3.00;

  def totalCost(price:Double,count:Int):Double=costForBooks(price,count)+shippingCost(count);

  println(totalCost(24.95,60));

}

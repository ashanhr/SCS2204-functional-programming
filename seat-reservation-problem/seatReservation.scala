import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

// Seat reservation system for a Colombo - Kataragama intercity bus
object seatReservation extends App {

    // List of cities
    val cities = List("Colombo","Kalutara","Ambalangoda","Galle","Matara","Tangalle","Hambantota","Tissa","Kataragama")

    // Multi dimentional array represeinting seats in the bus
    var seats = Array.ofDim[Boolean](10,4,cities.size)
    
    // Printing the cities list
    def printCities(): Unit ={

        for(city <- cities)
        {
            print(city + " ")
        }
        
        println()

    }

    // Get the id of the city (id = index of the List)
    def getCityId(city:String): Int = city match {
        case "Colombo" => 0
        case "Kalutara" => 1
        case "Amblangoda" => 2
        case "Galle" => 3
        case "Matara" => 4
        case "Tangalle" => 5
        case "Hambantota" => 6
        case "Tissa" => 7
        case "Kataragama" => 8
        case _ => -1
    }

    // Check availability of the given seat between given cities
    def checkAvailability(startId:Int, destinationId:Int, row:Int, column:Int):Boolean={

        for(id <- startId to destinationId)
        {
            if(seats(row)(column)(id)==true)
            {
                return false
            }
        }

        return true
    }

    // Reserve the given seat for the given start and the destination city
    def reserveSeat(startId:Int, destinationId:Int, row:Int, column:Int):Unit={

        for(id <- startId to destinationId)
        {
            seats(row)(column)(id)=true
        }

        print("\nSuccessfully reserved the seat :)\n")
    }

    // Seat reservation method
    def book(): Unit={
        
        print("\nEnter the starting city:")
        val start:String = readLine()
        print("Enter the destination city:")
        val destination:String = readLine() 

        val startId = getCityId(start)
        val destinationId = getCityId(destination)

        if(startId == -1 || destinationId == -1)
        {
            print("\nInvalid City..!\n")
            return
        }

        // print(startId + " " + destinationId + "\n")

        if(startId>=destinationId)
        {
            print("Starting city should come first..!\n")
            return
        }

        var again:Boolean = true

        while(again)
        {
            print("\nEnter the row number of the seat:")
            val row:Int = readInt()
            print("Enter the column number of the seat:")
            val column:Int = readInt() 

            val available:Boolean = checkAvailability(startId,destinationId,row,column)

            if(!available)
            {
                print("\nSeat is already reserved..!\n")
            }else{
                reserveSeat(startId,destinationId,row,column)
            }

            print("\nIf you want to reserve another seat from " + start + " to " + destination + " enter 'again'\nenter any other input to cancel the reservation process :)")

            val input:String = readLine()

            if(input=="again")
            {
                again = true
            }else{
                again = false
            }
        }

        return
    }

    // Reserve the given seat for the given start and the destination city
    def freeSeat(startId:Int, destinationId:Int, row:Int, column:Int):Unit={

        for(id <- startId to destinationId)
        {
            seats(row)(column)(id)=false
        }

        print("\nSuccessfully cancelled the reservation :)\n")

    }

    // Cancel a reservation
    def cancel():Unit ={

        print("\nEnter the starting city:")
        val start:String = readLine()
        print("Enter the destination city:")
        val destination:String = readLine() 

        val startId = getCityId(start)
        val destinationId = getCityId(destination)

        // print(startId + " " + destinationId + "\n")

        if(startId == -1 || destinationId == -1)
        {
            print("\nInvalid City..!\n")
            return
        }

        if(startId>=destinationId)
        {
            print("Starting city should come first..!\n")
            return
        }

        var again:Boolean = true

        while(again)
        {
            print("\nEnter the row number of the seat:")
            val row:Int = readInt()
            print("Enter the column number of the seat:")
            val column:Int = readInt() 

            freeSeat(startId,destinationId,row,column)

            print("\nIf you want to cancel another reservation from " + start + " to " + destination + " enter 'again'\nenter any other input to cancel the cancel reservation process :)")

            val input:String = readLine()

            if(input=="again")
            {
                again = true
            }else{
                again = false
            }
        }

        return
    }

    // CHeck the availability of seats between given cities
    def check():Unit ={

        print("\nEnter the starting city:")
        val start:String = readLine()
        print("Enter the destination city:")
        val destination:String = readLine() 

        val startId = getCityId(start)
        val destinationId = getCityId(destination)

        // print(startId + " " + destinationId + "\n")

        if(startId == -1 || destinationId == -1)
        {
            print("\nInvalid City..!\n")
            return
        }

        if(startId>=destinationId)
        {
            print("Starting city should come first..!\n")
            return
        }

        print("\n---------\n")

        print(" FRONT\n")

        for(row <- 0 to 9)
        {
            for(column <- 0 to 3)
            {
                val available:Boolean = checkAvailability(startId,destinationId,row,column)

                if(available)
                {
                    print("_ ")
                }else{
                    print("R ")
                }
            }
            print("\n")
        }

        print("\n---------\n")


        return
    }
    
    var stop: Boolean = false;

    while(!stop)
    {

        print("\n-----------------MENU-----------------\n")
        print("Enter 'book' to make a reservation.\n")
        print("Enter 'check' to check available seats.\n")
        print("Enter 'cancel' to cancel a reservation.\n")
        print("Enter 'exit' to exit.\n")
        print("--------------------------------------\n")
        print("Choose an option: ")

        var decision: String = readLine()

        if(decision == "exit")
        {
            stop = true
        }else if(decision=="book")
        {
            book()
        }else if(decision=="cancel")
        {
            cancel()
        }else if(decision=="check")
        {
            check()
        }else{
            print("\nWrong decision input..!\n")
        }
        
    }

}

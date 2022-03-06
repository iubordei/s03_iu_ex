fun main() {
    // listas (no modificables)
    //val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("List: $numbers")
    println("Size: ${numbers.size}")
    
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    
    // acceso a elementos de la lista
    println("Last index: ${numbers.size - 1}")
	println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
	println("Last: ${numbers.last()}")
    
    // contains
    println("Contains 4? ${numbers.contains(4)}")
	println("Contains 7? ${numbers.contains(7)}")
    
    println("\n")
    val colors = listOf("green", "orange", "blue")
    //colors.add("purple")
    //colors[0] = "yellow"
    
    println("Reversed list: ${colors.reversed()}")
	println("List: $colors")
    println("Sorted list: ${colors.sorted()}")
    
    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")
    
    // listas mutables
    println("\n")
    //val entrees = mutableListOf<String>()
    val entrees: MutableList<String> = mutableListOf()
    
    println("Entrees: $entrees")
    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")
    
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")
    
    //entrees.add(10)
    
    println("\nRemove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
	println("Entrees: $entrees")
    println("Remove first element: ${entrees.removeAt(0)}")
	println("Entrees: $entrees")
    
    entrees.clear()
	println("\nEntrees: $entrees")
    println("Empty? ${entrees.isEmpty()}")
    
    // bucles a través de una lista
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("\n\nTotal Guest Count: $totalGuests\n")
    
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        //println(name)
        println("$name - Number of characters: ${name.length}") 
    }
    
    // combina toda la información
    val noodles = Noodles()
    val vegetables = Vegetables()
    println("\n\n$noodles")
    println(vegetables)
    
    val vegetables2 = Vegetables("Cabbage", "Sprouts", "Onion")
    println(vegetables2)
    
    val vegetables3 = Vegetables()
    println(vegetables3)
    
    // crear pedidos
    /*
    val order1 = Order(1)
    order1.addItem(Noodles())
    println()
    order1.print()

    println()

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    order2.print()

    println()

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    order3.print()
    */
    
    // combinar los pedidos
    val ordersList = mutableListOf<Order>()

    val order1 = Order(1)
    order1.addItem(Noodles())
    ordersList.add(order1)

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    ordersList.add(order2)

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    ordersList.add(order3)
    
    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
	ordersList.add(order4)
    
    ordersList.add(
    Order(5)
        .addItem(Noodles())
        .addItem(Noodles())
        .addItem(Vegetables("Spinach")))
    
    println()
    for (order in ordersList) {
        order.print()
        println()
    }
    
}

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name;
    }
}

/*
class Vegetables : Item("Vegetables", 5) {
    override fun toString(): String {
        return name;
    }
}
*/
/*
class Vegetables(val topping1: String,
                 val topping2: String,
                 val topping3: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return name;
    }
}
*/

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
	override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name Chef's Choice"
        } else {
            return name + ": " + toppings.joinToString()
        }
    }
}

class Order(val orderNumber: Int) {
   private val itemList = mutableListOf<Item>()

   fun addItem(newItem: Item) : Order {
       itemList.add(newItem)
       return this
   }

   fun addAll(newItems: List<Item>) : Order {
       itemList.addAll(newItems)
       return this
   }

   fun print() {
       println("Order #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
   }
}
package machine

class CoffeeMachine {
    private val water = 200
    private val milk = 50
    private val coffeeBeans = 15

    fun quantityOfIngredients(cntCups: Int){
        println("""
            For $cntCups cups of coffee you will need:
            ${cntCups * water} ml of water
            ${cntCups * milk} of milk
            ${cntCups * coffeeBeans} g of coffee beans
        """.trimIndent())
    }
}

fun main() {
    println("Write how many cups of coffee you will need:")
    val cntCups = readln().toInt()
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.quantityOfIngredients(cntCups)
}

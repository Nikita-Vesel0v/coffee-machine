package machine

import kotlin.math.min

class CoffeeMachine {
    private var totalWater = 0
    private var totalMilk = 0
    private var totalBeans = 0

    private val waterPerCup = 200
    private val milkPerCup = 50
    private val beansPerCup = 15

    fun addWater(value: Int) {
        totalWater += value
    }
    fun addMilk(value: Int) {
        totalMilk += value
    }
    fun addBeans(value: Int) {
        totalBeans += value
    }
    fun quantityOfIngredients(cntCups: Int){
        println("""
            For $cntCups cups of coffee you will need:
            ${cntCups * waterPerCup} ml of water
            ${cntCups * milkPerCup} ml of milk
            ${cntCups * beansPerCup} g of coffee beans
        """.trimIndent())
    }

    fun availableCups(): Int {
        val cupsWater = totalWater / waterPerCup
        val cupsMilk = totalMilk / milkPerCup
        val cupsBeans = totalBeans / beansPerCup
        return min(min(cupsWater, cupsMilk), cupsBeans)
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    //Task 1
//    println("Write how many cups of coffee you will need:")
//    val cntCups = readln().toInt()
//    coffeeMachine.quantityOfIngredients(cntCups)

    //Task 2
    println("Write how many ml of water the coffee machine has:")
    coffeeMachine.addWater(readln().toInt())
    println("Write how many ml of milk the coffee machine has:")
    coffeeMachine.addMilk(readln().toInt())
    println("Write how many grams of coffee beans the coffee machine has:")
    coffeeMachine.addBeans(readln().toInt())
    println("Write how many cups of coffee you will need:")
    val needCups = readln().toInt()
    val availableCups = coffeeMachine.availableCups()
    println(
        when {
            availableCups > needCups -> "Yes, I can make that amount of coffee (and even ${availableCups - needCups} more than that)"
            availableCups == needCups -> "Yes, I can make that amount of coffee"
            else -> "No, I can make only $availableCups cups of coffee"
        }
    )
}

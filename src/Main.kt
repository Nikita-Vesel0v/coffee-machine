package machine

import kotlin.math.min

open class CoffeeMachine {
    private var availableMoney = 550
    private var availableWater = 400
    private var availableMilk = 540
    private var availableBeans = 120
    private var availableCups = 9

    protected open var moneyPerCup = 0
    protected open var waterPerCup = 0
    protected open var milkPerCup = 0
    protected open var beansPerCup = 0

    private fun setEspresso() {
        moneyPerCup = 4; waterPerCup = 250; milkPerCup = 0; beansPerCup = 16
    }
    private fun setLatte() {
        moneyPerCup = 7; waterPerCup = 350; milkPerCup = 75; beansPerCup = 20
    }
    private fun setCappuccino(){
        moneyPerCup = 6; waterPerCup = 200; milkPerCup = 100; beansPerCup = 12
    }

//    fun quantityOfIngredients(type: Int, cntCups: Int){
//        when(type){
//            1 -> setEspresso()
//            2 -> setLatte()
//            3 -> setLatte()
//        }
//        println("""
//            For $cntCups cups of coffee you will need:
//            ${cntCups * waterPerCup} ml of water
//            ${cntCups * milkPerCup} ml of milk
//            ${cntCups * beansPerCup} g of coffee beans
//        """.trimIndent())
//    }

    private fun availableResources(): Boolean {
        val result = when {
            availableCups < 1 ->
                "Sorry, not enough cups!"
            availableWater - waterPerCup < 0 ->
                "Sorry, not enough water!"
            availableMilk - milkPerCup < 0 ->
                "Sorry, not enough milk!"
            availableBeans - beansPerCup < 0 ->
                "Sorry, not enough coffee beans!"
            else ->
                "I have enough resources, making you a coffee!"
        }
        println("$result\n")
        return (result == "I have enough resources, making you a coffee!")
    }

    fun buy() {
        println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> setEspresso()
            "2" -> setLatte()
            "3" -> setCappuccino()
            "back" -> return
            else -> error("Unknown coffee")
        }
        if (availableResources()) {
            availableMoney += moneyPerCup
            availableBeans -= beansPerCup
            availableWater -= waterPerCup
            availableMilk -= milkPerCup
            availableCups--
        }
    }

    fun fill() {
        println("\nWrite how many ml of water you want to add:")
        availableWater += readln().toInt()
        println("Write how many ml of milk you want to add:")
        availableMilk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        availableBeans += readln().toInt()
        println("Write how many disposable cups you want to add:\n")
        availableCups += readln().toInt()
    }

    fun take() {
        println("\nI gave you $$availableMoney\n")
        availableMoney = 0
    }

    fun status() {
        println("""
            
            The coffee machine has:
            $availableWater ml of water
            $availableMilk ml of milk
            $availableBeans g of coffee beans
            $availableCups disposable cups
            $$availableMoney of money

        """.trimIndent())
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    //Task 1
//    println("Write how many cups of coffee you will need:")
//    val cntCups = readln().toInt()
//    coffeeMachine.quantityOfIngredients(cntCups)

    //Task 2
//    println("Write how many ml of water the coffee machine has:")
//    coffeeMachine.addWater(readln().toInt())
//    println("Write how many ml of milk the coffee machine has:")
//    coffeeMachine.addMilk(readln().toInt())
//    println("Write how many grams of coffee beans the coffee machine has:")
//    coffeeMachine.addBeans(readln().toInt())
//    println("Write how many cups of coffee you will need:")
//    val needCups = readln().toInt()
//    val availableCups = coffeeMachine.availableCupDrink(1)
//    println(
//        when {
//            availableCups > needCups -> "Yes, I can make that amount of coffee (and even ${availableCups - needCups} more than that)"
//            availableCups == needCups -> "Yes, I can make that amount of coffee"
//            else -> "No, I can make only $availableCups cups of coffee"
//        }
//    )

    // Task 5
    while (true) {
        println("Write action (buy, fill, take, remaining, exit): ")
        val action = readln()
        when (action) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.status()
            "exit" -> break
        }
    }
}

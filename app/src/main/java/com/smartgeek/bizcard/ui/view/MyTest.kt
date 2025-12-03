package com.smartgeek.bizcard.ui.view

fun main() {
}



/** Data Class */
//fun main () {
//
//    val abhishek = Person(
//        name = "Abhishek",
//        lastName = "Vengurlekar",
//        age = 27
//    )
//    val kshitij = Person(
//        name = "Kshitij",
//        lastName = "Vengurlekar",
//        age = 27
//    )
//    val rishaan = Person(
//        name = "Rishaan",
//        lastName = "Vengurlekar",
//        age = 27
//    )
//
//    val listOfPeople = listOf(abhishek, kshitij,rishaan)
//
//    val (name, lastName, age) = abhishek
//    println(name)
//    println(lastName)
//    println(age)
//
//    listOfPeople.forEach {
//        println(it)
//    }
//}
//
//data class Person(val name: String, val lastName: String, val age: Int)



/** Extension Function */
//fun main () {
//    println("Hello Jenny, ".append("Friend"))
//    println(123456.append("Friend"))
//    println("My Name is".removeFirstAndLast())
//}
//
//fun String.append(toAppend: String): String = this.plus(toAppend)
//fun Int.append(toAppend: String): String = this.toString().plus(toAppend)
//fun String.removeFirstAndLast(): String = this.substring(1,this.lastIndex)



/** Interface */
//fun main () {
//    val button = MyButton("Testing Button")
//    button.onClick("This is a Button")
//}
//
//class MyButton(val label: String): ClickEvent {
//    override fun onClick(message: String) {
//        println("Clicked by $label and here's a message $message")
//    }
//
//}
//
//// Interface
//interface ClickEvent {
//    fun onClick(message: String)
//}



/** Override and inheritance */
//class Truck(color: String, model: String): Car(color, model) {
//    override fun speed(minSpeed: Int, maxSpeed: Int) {
//        val fullSpeed = minSpeed*maxSpeed
//        println("Truck full speed is $fullSpeed")
//    }
//
//    override fun drive() {
//        println("Vroommm... Like a Truck!")
//    }
//}
//
//open class Car (
//    var color: String,
//    val model: String
//) {
//    init {
//        if (color == "green"){
//            println("Yayy Green colour")
//        }
//        else {
//            println("$color is not green")
//        }
//    }
//
//    open fun speed(minSpeed: Int, maxSpeed: Int) {
//        println("Min Speed is $minSpeed and Max Speed: $maxSpeed")
//    }
//
//    open fun drive() {
//        println("Drive...Vroommmm")
//    }
//}
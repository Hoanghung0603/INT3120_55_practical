fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)
    println("$firstNumber - $secondNumber = ${firstNumber - secondNumber}")
    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
}

fun add(firstNum: Int, secondNum: Int): Int {
    return firstNum + secondNum
}

fun subtract(firstNum: Int, secondNum: Int): Int {
    return firstNum - secondNum
}
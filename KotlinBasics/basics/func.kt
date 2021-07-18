fun main() {
    println(sum(2,3))
    println(sumShort(2,3))
    printSum(2,3)
    printSum2(2,3)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumShort(a: Int, b: Int) = a + b

//no return value
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//unit return type can be ommitted
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}
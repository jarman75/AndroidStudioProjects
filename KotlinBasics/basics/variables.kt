fun main() {

    //readonly variables 'val'.  They can be assigned a value only once.

    val a: Int = 1  // immediate assignment
    
    val b = 2   // `Int` type is inferred
    
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment

    println("val => can be assigned only once.")
    println("a value = $a")
    println("b value = $b")
    println("c value = $c")

    var x = 5 // `Int` type is inferred
    x += 1 
    
    println("var => can be reassigned.")
    println("x value = $x")


}
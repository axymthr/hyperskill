import java.util.Scanner

data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        other as Client
        return (name == other.name && age == other.age)
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //implement your code here
    val name1 = input.next()
    val age1 = input.nextInt()
    val balance1 = input.nextInt()
    val client1 = Client(name1, age1, balance1)
    val name2 = input.next()
    val age2 = input.nextInt()
    val balance2 = input.nextInt()
    val client2 = Client(name2, age2, balance2)
    println(client1 == client2)
}
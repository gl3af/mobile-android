data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int,
)

fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")
}
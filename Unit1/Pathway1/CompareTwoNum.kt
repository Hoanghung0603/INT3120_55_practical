fun main() {
    println("${compareTime(300, 250)}")
    println("${compareTime(300, 300)}")
    println("${compareTime(200, 220)}")
}

fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}
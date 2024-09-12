fun main() {
    val steps = 4000
    val caloriesBurned = PedometerstepsToCalories(steps)
    println("Walking $steps steps burns $caloriesBurned calories")
}

fun PedometerstepsToCalories(NumberOFStepS: Int): Double {
    val CaloriesBurnedforEachStep = 0.04
    val TotalCaloriesburned = NumberOFStepS * CaloriesBurnedforEachStep
    return TotalCaloriesburned
}
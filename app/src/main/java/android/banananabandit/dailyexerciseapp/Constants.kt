package android.banananabandit.dailyexerciseapp

object Constants {
    fun getExercises() : ArrayList<ExerciseModel> {
        val exerciseList =  ArrayList<ExerciseModel>()

        var exerciseOne = ExerciseModel(1, "Regular Push-Ups", false, false)
        exerciseList.add(exerciseOne)

        var exerciseTwo = ExerciseModel(2, "Diamond Push-Ups", false, false)
        exerciseList.add(exerciseTwo)

        var exerciseThree = ExerciseModel(3, "Plank Push-Ups", false, false)
        exerciseList.add(exerciseThree)

        var exerciseFour = ExerciseModel(4, "Wheel Crunches", false, false)
        exerciseList.add(exerciseFour)

        var exerciseFive = ExerciseModel(5, "Windmill", false, false)
        exerciseList.add(exerciseFive)

        var exerciseSix = ExerciseModel(6, "Plank", false, false)
        exerciseList.add(exerciseSix)

        var exerciseSeven = ExerciseModel(7, "Shoulder Crunches", false, false)
        exerciseList.add(exerciseSeven)

        var exerciseEight = ExerciseModel(8, "Dumbell Curls", false, false)
        exerciseList.add(exerciseEight)

        var exerciseNine = ExerciseModel(9, "Delts Raise", false, false)
        exerciseList.add(exerciseNine)

        var exerciseTen = ExerciseModel(10, "Standing Back Row", false, false)
        exerciseList.add(exerciseTen)

        return exerciseList
    }
}
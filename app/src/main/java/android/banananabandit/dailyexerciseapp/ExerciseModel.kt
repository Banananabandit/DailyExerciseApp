package android.banananabandit.dailyexerciseapp

class ExerciseModel(
    private var id : Int,
    private var name : String,
    private var isCompleted : Boolean,
    private var isSelected : Boolean
) {
    fun getId() : Int {
        return id
    }

    fun setId(id : Int) {
        this.id = id
    }

    fun getName() : String {
        return name
    }
    fun setName(name : String) {
        this.name = name
    }
    fun getIsExerciseCompleted() : Boolean {
        return isCompleted
    }
    fun setExerciseCompleted(isCompleted: Boolean) {
        this.isCompleted = isCompleted
    }

    fun getIsExerciseSelected() : Boolean {
        return isSelected
    }
    fun setExerciseSelected(isSelected : Boolean) {
        this.isSelected = isSelected
    }
}
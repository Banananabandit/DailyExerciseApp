package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ItemExerciseBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class ExerciseStatusAdapter(val mExerciseList : ArrayList<ExerciseModel>) : RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    inner class ViewHolder(val itemBinding: ItemExerciseBinding) : RecyclerView.ViewHolder(itemBinding.root){
        val item = itemBinding.listItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = mExerciseList[position]
        holder.item.text = exercise.getId().toString()
    }

    override fun getItemCount(): Int {
        return mExerciseList.size
    }
}
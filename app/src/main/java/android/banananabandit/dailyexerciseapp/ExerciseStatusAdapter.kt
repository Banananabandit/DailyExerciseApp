package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ItemExerciseBinding
import android.graphics.Color
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.content.ContextCompat
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

        when {
            exercise.getIsExerciseSelected() -> {
                // Getting context of where this item is going to be displayed
                holder.item.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_thin_color_accent)
                holder.item.setTextColor(Color.parseColor("#212121"))
            }
            exercise.getIsExerciseCompleted() -> {
                holder.item.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_accent_background)
                holder.item.setTextColor(Color.WHITE)
            }
            else -> {
                holder.item.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_gray_background)
                holder.item.setTextColor(Color.parseColor("#212121"))

            }
        }
    }

    override fun getItemCount(): Int {
        return mExerciseList.size
    }
}
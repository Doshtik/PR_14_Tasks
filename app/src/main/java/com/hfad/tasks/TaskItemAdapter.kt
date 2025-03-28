package com.hfad.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//Для данных представления с переработкой.
class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //Кол-во элементов.
    override fun getItemCount() = data.size

    //Вызывается каждый раз, когда требуется создать держатель представления.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    //Вызывается, когда данные должны отображаться в держателе проедставления.
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
    class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
        val taskName = rootView.findViewById<TextView>(R.id.task_name)
        val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        companion object {
            //Создает каждый держатель представления и заполняет его макет.
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.task_item, parent, false) as CardView
                return TaskItemViewHolder(view)
            }
        }
        //Данные добавляются в макет держателя представления.
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone
        }
    }
}
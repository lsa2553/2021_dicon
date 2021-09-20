package com.example.vac_project.activity.backgroundMain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.vac_project.R
import java.nio.file.Files.size

class TodoAdapter (val todolist: ArrayList<Todo>) : RecyclerView.Adapter<TodoAdapter.ItemViewHolder>(){
lateinit var context: Context

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.todo_list, parent, false)
    return ItemViewHolder(view)
}

override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    holder.check.isChecked = false
    holder.line.editableText
}

override fun getItemCount(): Int = todolist.size

fun addItem(data: String) {
    todolist.add(Todo(false, R.id.editText))
    notifyItemInserted(todolist.size)
}


inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val check: CheckBox = itemView.findViewById(R.id.checkbox)
    val line: EditText = itemView.findViewById(R.id.editText)
}
}
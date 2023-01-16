package com.example.quizapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.db.Question
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(var qlist: List<Question>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.question.text = "Question ${qlist[position].question}"
        holder.itemView.yourAnswer.text = "Your Answer: ${qlist[position].answer}"
        holder.itemView.correctAnswer.text = "Correct Answer is: ${qlist[position].correctAnswer}"
        if(position == 0) {
            holder.itemView.question.setBackgroundColor(Color.GRAY)
            holder.itemView.yourAnswer.setBackgroundColor(Color.GRAY)
            holder.itemView.correctAnswer.setBackgroundColor(Color.GRAY)
        }
    }
    override fun getItemCount(): Int {
        return qlist.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
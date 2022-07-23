package com.madarsoft.storeusers.ui.showUsers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madarsoft.storeusers.data.models.UserModel
import com.madarsoft.storeusers.databinding.ItemRecyclerUserBinding

class UsersAdapter(val users: List<UserModel>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRecyclerUserBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder {
        val binding = ItemRecyclerUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.Age.text = users[position].age
        holder.binding.UserName.text = users[position].name
        holder.binding.JobTitle.text = users[position].jobTitle
        holder.binding.Gender.text = users[position].gender

    }

    override fun getItemCount(): Int {
        return users.size
    }
}
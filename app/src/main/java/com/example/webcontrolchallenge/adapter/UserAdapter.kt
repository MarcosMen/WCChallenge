package com.example.webcontrolchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webcontrolchallenge.R
import com.example.webcontrolchallenge.databinding.ItemUserBinding
import com.example.webcontrolchallenge.model.UserDTO

class UserAdapter(private val dataSet: List<UserDTO>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(private val itemBinding: ItemUserBinding,val context: Context) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(user: UserDTO) {
            itemBinding.txtName.text = "Nombre: ${user.name}"
            itemBinding.txtEmail.text = "E-Mail: ${user.email}"
            itemBinding.txtRole.text = "Tipo de Usuario: ${user.role}"

            Glide.with(context)
                .load(user.avatar)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(itemBinding.imgItem)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = ItemUserBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(view, viewGroup.context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val user = dataSet[position]
        viewHolder.bind(user)
    }

    override fun getItemCount() = dataSet.size

}
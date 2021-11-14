package com.hirarki.personal.githubuserapp.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hirarki.personal.githubuserapp.R
import com.hirarki.personal.githubuserapp.databinding.ItemUserBinding
import com.hirarki.personal.githubuserapp.user.model.User
import com.hirarki.personal.githubuserapp.util.getImage

class UserAdapter(private val listener: OnUserAdapterListener) : RecyclerView.Adapter<UserViewHolder>() {
    private val list: ArrayList<User> = ArrayList()

    fun addItems(items: ArrayList<User>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val bindItem = ItemUserBinding.bind(itemView)

    fun onBind(data: User, listener: OnUserAdapterListener) {
        with(bindItem) {
            Glide.with(root.context).load(getImage(root.context, data.avatar)).apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_account_circle_24)
                    .error(R.drawable.ic_baseline_account_circle_24)
            ).into(ivAvatar)

            tvUsername.text = data.username
            tvName.text = data.name

            root.setOnClickListener { listener.onClicked(data) }
        }
    }
}

interface OnUserAdapterListener {
    fun onClicked(user: User)
}

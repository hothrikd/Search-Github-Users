package com.example.networkingwithandroid


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var data:List<User> = ArrayList()
    var onItemClick:((login:String)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int)  = holder.bind(data[position])

    override fun getItemCount(): Int  = data.size

    fun swapData(data:List<User>){
        this.data = data
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(item: User) = with(itemView) {
            tv1.text = item.name
            tv2.text = item.login
            Picasso.get().load(item.avatarUrl).into(imageView)
                setOnClickListener{
                        onItemClick?.invoke(item.login!!)
                }
        }

    }
}
package com.adl.mobileroom.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*


class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    var nama = view.tNama
    var gender = view.tGender
    val umur = view.tUmur
    val status = view.tStatus
    val image = view.imageView
    val context = view.context



    fun bindData (adapter: UserAdapter, position: Int){


        nama.setText(adapter.data.get(position).nama)
        umur.setText(adapter.data.get(position).umur)
        Glide.with(context).load(adapter.data.get(position).photo).into(image)


    }
}
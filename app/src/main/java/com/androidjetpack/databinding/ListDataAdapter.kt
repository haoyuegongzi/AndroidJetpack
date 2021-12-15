package com.androidjetpack.databinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidjetpack.R

/**
 * 作者：Nixon
 * date：2020/7/4.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class ListDataAdapter:RecyclerView.Adapter<ListDataAdapter.ViewHolder>{
    var list:MutableList<String> =  mutableListOf()
    var context:Context? = null;

    constructor(mContext:Context){
        context = mContext
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_list_data, parent, false))
    }

    override fun getItemCount(): Int {
        if (null == list || list.isEmpty()) return 0 else return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
}
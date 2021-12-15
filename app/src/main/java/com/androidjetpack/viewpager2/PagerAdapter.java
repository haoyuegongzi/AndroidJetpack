package com.androidjetpack.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidjetpack.R;

import java.util.List;

/**
 * 作者：Nixon
 * date：2020/7/1.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Integer> dataList;

    public PagerAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void updateView(List<Integer> list){
        dataList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.viewpager2_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return null == dataList ? 0 : dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImageItem);
        }
    }
}

package com.example.relativelayoutlianxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.relativelayoutlianxi.R;
import com.example.relativelayoutlianxi.entity.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<DataEntity.DataBean> dataBeans;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        dataBeans=new ArrayList<>();
    }

    public void setData(List<DataEntity.DataBean> dataBeanList) {
        this.dataBeans = dataBeanList;
        if (dataBeanList!=null){
            this.dataBeans.addAll(dataBeanList);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(this.context, R.layout.recycler_view, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_title.setText(this.dataBeans.get(i).getTitle());
        String[] image =this.dataBeans.get(i).getImages().split("\\|");
        if (image!=null&&image.length>0){
            Glide.with(context).load(image[0]).into(viewHolder.image);
        }else{
            viewHolder.image.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return this.dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            image = itemView.findViewById(R.id.image);
        }
    }
}

package com.example.day2rkao.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day2rkao.R;
import com.example.day2rkao.gsonbean.Bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

public class MAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.DataBean> list;
    private final DisplayImageOptions display;
    private ImageLoader imageLoader=ImageLoader.getInstance();

    public MAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
        display = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView==null){
            holder=new Holder();
            convertView=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            holder.image =(ImageView) convertView.findViewById(R.id.image);
            holder.title =(TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.title.setText(list.get(position).getTitle());
        imageLoader.displayImage(list.get(position).getDetailUrl(),holder.image,display);
        return convertView;
    }
    class Holder{

        TextView title;
        ImageView image;
    }
}

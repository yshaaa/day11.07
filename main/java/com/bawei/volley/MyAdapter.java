package com.bawei.volley;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<ShopBean.DataBean.GridDataBean> list;

    public MyAdapter(ArrayList<ShopBean.DataBean.GridDataBean> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(viewGroup.getContext(),R.layout.item,null);
            viewHolder.imageView=view.findViewById(R.id.imageview);
            viewHolder.title=view.findViewById(R.id.title);
            view.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(list.get(i).getTitle());
        Glide.with(viewGroup.getContext()).load(list.get(i).getImageurl()).into(viewHolder.imageView);
        return view;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView title;
    }
}

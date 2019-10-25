package com.example.infs3634assignment2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infs3634assignment2.Common.Common;
import com.example.infs3634assignment2.R;
import com.example.infs3634assignment2.Model.MenuListModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyMenuItemAdapter extends RecyclerView.Adapter<MyMenuItemAdapter.MyViewHolder> {

    Context context;
    List<MenuListModel> menuListModelList;

    public MyMenuItemAdapter(Context context, List<MenuListModel> menuListModelList) {
        this.context = context;
        this.menuListModelList = menuListModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_menu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(menuListModelList.get(position).getImage())
                .into(holder.menu_image);
        holder.menu_name.setText(new StringBuilder(menuListModelList.get(position).getName()));
    }

    @Override
    public int getItemCount() {
        return menuListModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Unbinder unbinder;
        @BindView(R.id.img_menu_item)
        ImageView menu_image;
        @BindView(R.id.txt_mean_item)
        TextView menu_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (menuListModelList.size() == 1)
            return Common.DEFAULT_COLUMN_COUNT;
        else {
            if (menuListModelList.size() % 2 == 0)
                return Common.DEFAULT_COLUMN_COUNT;
            else
                return (position > 1 && position == menuListModelList.size() - 1) ? Common.FULL_WIDTH_COLUMN : Common.DEFAULT_COLUMN_COUNT;


        }
    }
}

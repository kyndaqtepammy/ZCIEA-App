package com.pamsillah.zciea.adapters;

import static com.pamsillah.zciea.config.Config.HOME_MENU_ITEM_ID;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.pamsillah.zciea.MainActivity;
import com.pamsillah.zciea.R;
import com.pamsillah.zciea.models.ModelHomeMenu;
import com.pamsillah.zciea.ui.api.ApiCalls;
import com.pamsillah.zciea.ui.api.FragmentAddNew;

import java.util.ArrayList;

public class AdapterHomeMenu extends RecyclerView.Adapter<AdapterHomeMenu.HomeMenuViewHolder> {
    private ArrayList<ModelHomeMenu> homeMenuArrayList;
    private Context mContext;

    public AdapterHomeMenu(ArrayList<ModelHomeMenu> homeMenuArrayList, Context mContext) {
        this.homeMenuArrayList = homeMenuArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomeMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_home_grid_menu, parent, false);
        return new HomeMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMenuViewHolder holder, int position) {
// Set the data to textview and imageview.
        ModelHomeMenu modelHomeMenu = homeMenuArrayList.get(position);
        holder.menuTitle.setText(modelHomeMenu.getTitle());
        holder.menuIcon.setImageResource(modelHomeMenu.getImgid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ApiCalls.class);
                intent.putExtra(HOME_MENU_ITEM_ID, modelHomeMenu.getMenuId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeMenuArrayList.size();
    }

    public class HomeMenuViewHolder extends RecyclerView.ViewHolder {
        private TextView menuTitle;
        private ImageView menuIcon;
        public HomeMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuIcon = itemView.findViewById(R.id.img_home_gridmenu);
            menuTitle = itemView.findViewById(R.id.txt_home_gridmenu);
        }
    }
}
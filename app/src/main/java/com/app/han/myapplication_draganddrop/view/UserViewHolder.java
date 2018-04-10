package com.app.han.myapplication_draganddrop.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.han.myapplication_draganddrop.R;

/**
 * Created by AizulfaideenBinHamim on 9/4/2018.
 */

class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userAvatar;
    TextView username;
    ImageView reorderView;
    public UserViewHolder(View itemView) {
        super(itemView);

        userAvatar = itemView.findViewById(R.id.imageview_profile);
        username = itemView.findViewById(R.id.textview_name);
        reorderView = itemView.findViewById(R.id.imageview_reorder);
    }
}

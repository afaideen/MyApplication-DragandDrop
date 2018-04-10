package com.app.han.myapplication_draganddrop.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.han.myapplication_draganddrop.R;

/**
 * Created by AizulfaideenBinHamim on 9/4/2018.
 */

public class SectionHeaderViewHolder extends RecyclerView.ViewHolder{

    TextView sectionTitle;
    public SectionHeaderViewHolder(View itemView) {
        super(itemView);
        sectionTitle = itemView.findViewById(R.id.textview_section_header);
    }
}

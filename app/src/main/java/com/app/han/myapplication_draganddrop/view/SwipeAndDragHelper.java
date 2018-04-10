package com.app.han.myapplication_draganddrop.view;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by AizulfaideenBinHamim on 9/4/2018.
 */

public class SwipeAndDragHelper extends ItemTouchHelper.Callback{
    private ActionCompletionContract contract;
    private boolean longPressDetected = false;


    public SwipeAndDragHelper(ActionCompletionContract contract) {
        this.contract = contract;

    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder) {

        if (viewHolder instanceof SectionHeaderViewHolder) {
            return 0;
        }

        int dragFlags, swipeFlags;
        if(longPressDetected == false) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            swipeFlags = ItemTouchHelper.ACTION_STATE_IDLE;//don't want swipe function, use this.
        }
        else {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    longPressDetected = false;
                    handler.removeCallbacks(this);
                }
            }, 2000);

        }
        int val = makeMovementFlags(dragFlags, swipeFlags);
        return val;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        contract.onViewMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        contract.onViewSwiped(viewHolder.getAdapterPosition());
        longPressDetected = false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
//        return super.isItemViewSwipeEnabled();
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        longPressDetected = true;
        return false;
    }



    public interface ActionCompletionContract {
        void onViewMoved(int oldPosition, int newPosition);

        void onViewSwiped(int adapterPosition);
    }
}

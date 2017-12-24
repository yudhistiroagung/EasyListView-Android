package com.yudhistiroagung.easylistview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int column;

    public SpacesItemDecoration(int space, int totalColumn) {
        this.space = space;
        this.column = totalColumn;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view) + 1;
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        outRect.top = space;

        if (position % 2 == 1){
            outRect.right = space / 2;
        }else if (position % 2 == 0){
            outRect.left = space / 2;
        }

    }
}

package com.example.apublic.utils.recyclerview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace,topSpace;
    boolean allSpace, top;
    int onlyRight;
    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
    public SpaceItemDecoration(int space, int onlyRight) {
        this.mSpace = space;
        this.onlyRight = onlyRight;
    }
    public SpaceItemDecoration(int space, int topSpace, boolean top) {
        this.mSpace = space;
        this.topSpace = topSpace;
        this.top = top;
    }
    public SpaceItemDecoration(int space, boolean allSpace) {
        this.mSpace = space;
        this.allSpace = allSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        outRect.left = mSpace;
//        outRect.right = mSpace;
        if (allSpace) {
            outRect.right = mSpace;
            outRect.bottom = mSpace;

        }else if (top){
            if (parent.getChildPosition(view) == 0){
                outRect.top = topSpace;
            }else {
                outRect.top = mSpace;
            }
        }else if (onlyRight == 1){
            outRect.right = mSpace;
        }else {
            outRect.bottom = mSpace;
        }
//        if (parent.getChildAdapterPosition(view) == 0){
//            outRect.top = mSpace;
//        }
    }
}

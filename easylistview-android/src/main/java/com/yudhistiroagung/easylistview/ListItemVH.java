package com.yudhistiroagung.easylistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class ListItemVH extends RecyclerView.ViewHolder {

    public Context mContext;

    public View mContainer;
    public ImageView mImage;
    public TextView mTitle;
    public TextView mDescription;

    public ListItemVH(View itemView) {
        super(itemView);
        this.mContext = itemView.getContext();

        mContainer = itemView.findViewById(R.id.container_item);
        mImage = itemView.findViewById(R.id.image);
        mTitle = itemView.findViewById(R.id.title);
        mDescription = itemView.findViewById(R.id.description);

    }

    public void setListData(ListItem item) {
        Glide.with(mContext)
                .load(item.getImageUrl())
                .into(mImage);

        mTitle.setText(item.getTitle());
        mDescription.setText(item.getDescription());
    }
}
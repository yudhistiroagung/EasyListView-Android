package com.yudhistiroagung.easylistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yudhistiroagung on 12/24/17.
 */

public class EasyListAdapter extends RecyclerView.Adapter<ListItemVH>{

    private ViewType mType;
    private List<ListItem> mDataSet = new ArrayList<>();
    private OnItemClickListener mListener;
    private RecyclerView mRecyclerView;
    private OrderType mOrderType = OrderType.NONE;

    public EasyListAdapter() {}

    /**
     * constructor
     * @param type list view type {@link ViewType}
     */
    public EasyListAdapter(ViewType type) {
        this.mType = type;
    }

    /**
     *
     * @param type
     * @param mRecyclerView
     */
    public EasyListAdapter(ViewType type, RecyclerView mRecyclerView) {
        this.mType = type;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    public ListItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        int resTemplateVh = R.layout.template_list_item_vh;
        switch (viewType){
            case 1:
                resTemplateVh = R.layout.template_grid_item_vh;
                break;
            case 2 :
                resTemplateVh = R.layout.template_staggered_grid_item_vh;
                break;
        }
        return new ListItemVH(LayoutInflater.from(parent.getContext()).inflate(
                resTemplateVh, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return this.mType.ordinal();
    }

    @Override
    public void onBindViewHolder(ListItemVH holder, final int position) {
        holder.setListData(mDataSet.get(position));
        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    mListener.onItemClicked(position, mDataSet.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * set on click listener
     * @param listener {@link OnItemClickListener}
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    /**
     * replace list with new dataset
     * @param items
     */
    public void setListItems(List<? extends ListItem> items){
        mDataSet.clear();
        mDataSet.addAll(items);
        orderDataSet(true);
        notifyDataSetChanged();
    }

    /**
     * append list with new dataset
     * @param items
     */
    public void addListItems(List<? extends ListItem> items){
        mDataSet.addAll(items);
        orderDataSet(true);
        notifyDataSetChanged();
        if (mRecyclerView != null){
            mRecyclerView.smoothScrollToPosition(mDataSet.size() - items.size());
        }
    }

    /**
     * add 1 new item to dataset on last position
     * @param item
     */
    public void addListItem(ListItem item){
        mDataSet.add(item);
        notifyDataSetChanged();
    }

    /**
     * add 1 new item to dataset on specific position
     * @param position
     * @param item
     */
    public void addListItem(int position, ListItem item){
        if (position < 0) position = 0;
        mDataSet.add(position, item);
        notifyDataSetChanged();
    }

    /**
     * order the items ascending or descending order
     * @param orderType
     */
    public void setOrder(OrderType orderType){
        this.mOrderType = orderType;
        if(mDataSet.size() > 0){
            //immediately order the list
            orderDataSet(false);
        }
    }

    /**
     * order current dataset with selected order type
     * @param isDataChanged is data has been changed before reorder the items
     */
    private void orderDataSet(boolean isDataChanged){
        if (mOrderType == OrderType.NONE)
            return;
        Collections.sort(this.mDataSet, new Comparator<ListItem>() {
            @Override
            public int compare(ListItem listItem, ListItem t1) {
                switch (mOrderType){
                    case ASC:
                        return listItem.getTitle().compareTo(t1.getTitle());
                    case DESC:
                        return t1.getTitle().compareTo(listItem.getTitle());
                }
                return 0;
            }
        });
        if (!isDataChanged)
            notifyDataSetChanged();
    }

}

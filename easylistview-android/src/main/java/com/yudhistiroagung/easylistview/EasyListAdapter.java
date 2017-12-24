package com.yudhistiroagung.easylistview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yudhistiroagung on 12/24/17.
 */

public class EasyListAdapter extends RecyclerView.Adapter<ListItemVH>{

    private ViewType mType;
    private List<ListItem> mDataSet = new ArrayList<>();

    public EasyListAdapter(ViewType type) {
        this.mType = type;
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
    public void onBindViewHolder(ListItemVH holder, int position) {
        holder.setListData(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setListItems(List<? extends ListItem> items){
        mDataSet.clear();
        mDataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void addListItems(List<? extends ListItem> items){
        mDataSet.addAll(items);
        notifyDataSetChanged();
    }

    public void addListItem(ListItem item){
        mDataSet.add(item);
        notifyDataSetChanged();
    }

    public void addListItem(int position, ListItem item){
        mDataSet.add(position, item);
        notifyDataSetChanged();
    }

}

package com.yudhistiroagung.easylistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import static android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL;

/**
 * Created by yudhistiroagung on 12/24/17.
 */

public class EasyListView extends FrameLayout {

    private ViewType mType;
    private RecyclerView mListView;
    private EasyListAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    public EasyListView(@NonNull Context context) {
        super(context);
        init();
    }

    public EasyListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initType(context, attrs);
        init();
    }

    public EasyListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initType(context, attrs);
        init();
    }

    private void initType(Context mContext, AttributeSet attrs){
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.EasyListView, 0, 0);
        try {
            int type = ta.getInt(R.styleable.EasyListView_easyListViewType, 0);
            this.mType = ViewType.values()[type];
        } finally {
            ta.recycle();
        }
    }

    private void init(){
        View v = LayoutInflater.from(getContext()).inflate(R.layout.template_easy_list_view, this);

        mListView = v.findViewById(R.id.main_recycler_view);
        initRecyclerView();
    }

    private void initRecyclerView(){
        switch (this.mType){
            case GRID:
                mLayoutManager = new GridLayoutManager(getContext(), 2);
                mListView.addItemDecoration( new SpacesItemDecoration(16, 2) );
                break;
            case STAGGERED_GRID:
                mLayoutManager = new StaggeredGridLayoutManager(2, VERTICAL);
                mListView.addItemDecoration( new SpacesItemDecoration(16, 2) );
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getContext());
        }
        mAdapter = new EasyListAdapter(this.mType);
        mLayoutManager.setAutoMeasureEnabled(true);
        mListView.setLayoutManager(mLayoutManager);
        mListView.setAdapter(mAdapter);
    }

    public void setListItems(List<? extends ListItem> items){
        mAdapter.setListItems(items);
    }

    public void addListItems(List<? extends ListItem> items){
        mAdapter.addListItems(items);
    }

    public void addListItem(ListItem item){
        mAdapter.addListItem(item);
    }

    public void addListItem(int position, ListItem item){
        mAdapter.addListItem(position, item);
    }

}

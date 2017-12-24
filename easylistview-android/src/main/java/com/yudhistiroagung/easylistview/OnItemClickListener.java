package com.yudhistiroagung.easylistview;

/**
 * * Created by yudhistiroagung on 12/24/17.
 *
 * interface to handle click event
 */
public interface OnItemClickListener {
    /**
     * Method that fired when user tap the item
     *
     * @param position position if the item
     * @param data     ListItem data object
     */
    void onItemClicked(int position, ListItem data);
}
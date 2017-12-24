package com.yudhistiroagung.easylistview;

/**
 * Created by yudhistiroagung on 12/24/17.
 */

public interface ListItem {

    /**
     * Title of the item
     * @return string
     */
    String getTitle();

    /**
     * Description of the item
     * @return string
     */
    String getDescription();

    /**
     * get image url to be shown on the list
     * @return string image url
     */
    String getImageUrl();

}

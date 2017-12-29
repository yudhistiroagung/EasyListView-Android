package com.yudhistiroagung.easylistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EasyListView mEasyListView;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEasyListView = findViewById(R.id.easyListView);
        mEasyListView.setListItems(getMockProducts());
        mEasyListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(int position, ListItem data) {
                Toast.makeText(MainActivity.this, "Clicked "+position, Toast.LENGTH_SHORT).show();
            }
        });
        mEasyListView.setOnScrollEndListener(new OnScrollEndListener() {
            @Override
            public void onScrollEnd() {
                if (!isLoading) {
                    Toast.makeText(MainActivity.this, "Loading ...", Toast.LENGTH_SHORT).show();
                    Log.d("EasyListView", "onScrollEnd: ");
                    isLoading = !isLoading;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //fake network call
                            isLoading = !isLoading;
                            mEasyListView.addListItems(getMockProducts());
                        }
                    }, 3000);
                }
            }
        });
    }

    private List<ListItem> getMockProducts(){
        String img1 = "http://dreamstop.com/wp-content/uploads/2013/11/Fruit-Dreams.jpg";
        String img2 = "https://s-media-cache-ak0.pinimg.com/originals/1f/02/85/1f0285cad3365719a1c205f343324097.png";
        List<ListItem> res = new ArrayList<>();
        res.add( new Product("Title 1", "sdfasdfsadf sadf sadf sadf sdaf", img1) );
        res.add( new Product("Title 2", "sdfasdfsadf sadf sadf sadf sdaf sadfjbasd fasd kjfhsad jfhasdjhfb", img1) );
        res.add( new Product("Title 3", "sdfasdfsadf sadf sadf sadf sdaf", img1) );
        res.add( new Product("Title 4", "sdfasdfsadf sadf sadf sadf sdaf", img2) );
        res.add( new Product("Title 5", "sdfasdfsadf sadf sadf sadf sdaf sadfjbasd fasd kjfhsad jfhasdjhfb", img1) );
        res.add( new Product("Title 6", "sdfasdfsadf sadf sadf", img1) );
        res.add( new Product("Title 7", "sdfasdfsadf sadf sadf sadf sdaf sadfjbasd fasd kjfhsad jfhasdjhfb", img2) );
        return res;
    }
}

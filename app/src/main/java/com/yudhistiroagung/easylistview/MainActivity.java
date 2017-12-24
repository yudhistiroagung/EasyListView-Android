package com.yudhistiroagung.easylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EasyListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.easyListView);
        mListView.setListItems(getMockProducts());
    }

    private List<ListItem> getMockProducts(){
        String img1 = "http://dreamstop.com/wp-content/uploads/2013/11/Fruit-Dreams.jpg";
        String img2 = "https://s-media-cache-ak0.pinimg.com/originals/1f/02/85/1f0285cad3365719a1c205f343324097.png";
        List<ListItem> res = new ArrayList<>();
        res.add( new Product("ini satu", "sdfasdfsadf sadf sadf sadf sdaf", img1) );
        res.add( new Product("ini dua", "sdfasdfsadf sadf sadf sadf sdaf sadfjbasd fasd kjfhsad jfhasdjhfb", img1) );
        res.add( new Product("ini tiga", "sdfasdfsadf sadf sadf sadf sdaf", img1) );
        res.add( new Product("ini empat", "sdfasdfsadf sadf sadf sadf sdaf", img2) );
        res.add( new Product("ini lima", "sdfasdfsadf sadf sadf sadf sdaf sadfjbasd fasd kjfhsad jfhasdjhfb", img1) );
//        for (int i = 0; i < 10; i++) {
//            res.add( new Product("Product "+i, "Desscription ajajaj ak ak ak ak a asdjhgas dfjkahsd fjkasdg fjkhasgdf jhaksdgf ask ak ak ak ak akak kdhfaksd fjahsdbf  "+i) );
//        }
        return res;
    }
}

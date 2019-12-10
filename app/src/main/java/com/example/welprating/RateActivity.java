package com.example.welprating;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class RateActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    List<Fragment> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePageAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

    }

    public void jumptopage(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "Daniel");
        startActivity(intent);
    }

    public void jumptopage2(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "Ajay");
        startActivity(intent);
    }

    public void jumptopage3(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "Nikhil");
        startActivity(intent);
    }
}

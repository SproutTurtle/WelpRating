package com.example.welprating;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RateActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePageAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

    }

    public void jumptopage(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "daniel gleason");
        startActivity(intent);
    }

    public void jumptopage2(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "some shtty ta");
        startActivity(intent);
    }

    public void jumptopage3(View view) {
        Intent intent = new Intent(RateActivity.this, FeedbackActivity.class);
        intent.putExtra("name", "ben n");
        startActivity(intent);
    }
}

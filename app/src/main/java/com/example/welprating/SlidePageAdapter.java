package com.example.welprating;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SlidePageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragementList;
    public SlidePageAdapter(FragmentManager e, List<Fragment> fragmentList) {
        super(e);
        this.fragementList = fragmentList;

    }
    @Override
    public Fragment getItem(int i) {
        return fragementList.get(i);
    }
    @Override
    public int getCount() {
        return fragementList.size() ;
    }
}

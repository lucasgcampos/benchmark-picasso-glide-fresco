package com.lgcampos.benchmark.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.fragment.ObserverFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObserverActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private int totalCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(new ObserverViewPageAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.button_add)
    void onClickAddButton() {
        totalCount++;
        int current = viewPager.getCurrentItem();
        int offScreen = viewPager.getOffscreenPageLimit();

        int begin = current - offScreen >= 0 ? current - offScreen : 0;
        int end =  current + offScreen <= viewPager.getAdapter().getCount() ? current + offScreen : viewPager.getAdapter().getCount();

        for (int i = begin; i <= end; i++) {
            // TODO: Recupera fragment e usa o método de update

        }

        Toast.makeText(ObserverActivity.this, "totalCount is now " + viewPager.getChildCount(), Toast.LENGTH_SHORT).show();
    }

    public int getTotalCount() {
        return totalCount;
    }

    private class ObserverViewPageAdapter extends FragmentPagerAdapter {

        public ObserverViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ObserverFragment();
        }

        @Override
        public int getCount() {
            return 500;
        }
    }
}

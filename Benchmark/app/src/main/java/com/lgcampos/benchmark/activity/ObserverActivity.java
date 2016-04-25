package com.lgcampos.benchmark.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.fragment.ObserverFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObserverActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        viewPager.setAdapter(new ObserverViewPageAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.add_button)
    void onClickAddButton() {
        //TODO: do something
        Toast.makeText(ObserverActivity.this, "Clicou", Toast.LENGTH_SHORT).show();
    }

    private class ObserverViewPageAdapter extends FragmentStatePagerAdapter {

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

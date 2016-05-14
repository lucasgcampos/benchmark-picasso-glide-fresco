package com.lgcampos.benchmark.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.lgcampos.benchmark.Observable;
import com.lgcampos.benchmark.Observer;
import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.fragment.ObserverFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObserverActivity extends AppCompatActivity implements Observable {

    private static final String TAG = ObserverActivity.class.getSimpleName();

    private int totalCount = 0;
    private List<Observer> observers = new ArrayList<>();

    @Bind(R.id.view_pager)
    ViewPager viewPager;

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
        notifyObserver();
        Toast.makeText(ObserverActivity.this, "totalCount is now " + totalCount, Toast.LENGTH_SHORT).show();
    }

    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.i(TAG, "Registrando um fragment na lista de observers");
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        Log.i(TAG, "Removendo um fragment da lista de observers");
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(totalCount);
        }
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

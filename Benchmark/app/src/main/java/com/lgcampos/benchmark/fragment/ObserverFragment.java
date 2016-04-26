package com.lgcampos.benchmark.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lgcampos.benchmark.R;
import com.lgcampos.benchmark.activity.ObserverActivity;

public class ObserverFragment extends Fragment {

    private TextView tvCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_observer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvCount = (TextView) view.findViewById(R.id.tv_count);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            int count = ((ObserverActivity) getActivity()).getTotalCount();
            updateCountLabel(count);
        }
    }


    /**
     * This method will be called whenever the button +1 receive a click.
     *
     * Tip: this method is public. There's a reason for that?
     *
     * Rules:
     * 1 - Activity must NOT have a list of this fragments. The viewpager has
     * the responsibility for fragment memory disposals. If you put it in a list,
     * the reference made will retain the fragment in the memory. Imagine how big
     * is this problem knowing that we have 500 items in our adapter...
     *
     * 2 - All fragments in memory must be updated, not only the current one.
     */
    public void updateCountLabel(int count) {
        tvCount.setText(String.valueOf(count));
    }
}

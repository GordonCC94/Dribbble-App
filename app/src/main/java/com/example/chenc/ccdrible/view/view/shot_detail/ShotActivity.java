package com.example.chenc.ccdrible.view.view.shot_detail;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;

import com.example.chenc.ccdrible.view.base.SingleFragmentActivity;

/**
 * Created by chenc on 2017/8/27.
 */
public class ShotActivity extends SingleFragmentActivity {

    public static final String KEY_SHOT_TITLE = "shot_title";

    @NonNull
    @Override
    protected Fragment newFragment() {
        return ShotFragment.newInstance(getIntent().getExtras());
    }

    @NonNull
    @Override
    protected String getActivityTitle() {
        return getIntent().getStringExtra(KEY_SHOT_TITLE);
    }
}

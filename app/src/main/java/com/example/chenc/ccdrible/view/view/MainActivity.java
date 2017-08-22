package com.example.chenc.ccdrible.view.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chenc.ccdrible.R;
import com.example.chenc.ccdrible.view.view.shot_list.ShotListFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, ShotListFragment.newInstance())
                    .commit();
        }
    }
}

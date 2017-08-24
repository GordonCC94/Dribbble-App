package com.example.chenc.ccdrible.view.bucket_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenc.ccdrible.R;
import com.example.chenc.ccdrible.view.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by chenc on 2017/8/24.
 */

public class BucketViewHolder extends BaseViewHolder {

    @BindView(R.id.bucket_layout)
    View bucketLayout;
    @BindView(R.id.bucket_name)
    TextView bucketName;
    @BindView(R.id.bucket_shot_count) TextView bucketShotCount;
    @BindView(R.id.bucket_shot_chosen)
    ImageView bucketChosen;

    public BucketViewHolder(View itemView) {
        super(itemView);
    }
}

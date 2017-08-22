package com.example.chenc.ccdrible.view.view.shot_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenc.ccdrible.R;
import com.example.chenc.ccdrible.view.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by chenc on 2017/8/22.
 */

public class ShotViewHolder extends BaseViewHolder {

    @BindView(R.id.shot_clickable_cover) public View cover;
    @BindView(R.id.shot_like_count) public TextView likeCount;
    @BindView(R.id.shot_bucket_count) public TextView bucketCount;
    @BindView(R.id.shot_view_count) public TextView viewCount;
    @BindView(R.id.shot_image) public ImageView image;

    public ShotViewHolder(View itemView) {
        super(itemView);
    }
}

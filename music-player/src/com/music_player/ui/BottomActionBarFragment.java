package com.music_player.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.music_player.R;

/**
 * Created by fenghb on 3/18/14.
 */
public class BottomActionBarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_bottom_actionbar, null);
        return mView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

package com.music_player.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.music_player.R;

/**
 * Created by fenghb on 3/18/14.
 */
public class BottomActionBar extends LinearLayout implements View.OnLongClickListener {

    public BottomActionBar(Context context) {
        super(context);
    }

    public BottomActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnLongClickListener(this);
    }

    public BottomActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Updates the bottom ActionBar's info
     *
     * @throws android.os.RemoteException
     */
//    public void updateBottomActionBar(Activity activity) {
//        View bottomActionBar = activity.findViewById(R.id.bottom_action_bar);
//        if (bottomActionBar == null) {
//            return;
//        }
//
//        if (MusicUtils.mService != null && MusicUtils.getCurrentAudioId() != -1) {
//
//            // Track name
//            TextView mTrackName = (TextView)bottomActionBar
//                    .findViewById(R.id.bottom_action_bar_track_name);
//            mTrackName.setText(MusicUtils.getTrackName());
//
//            // Artist name
//            TextView mArtistName = (TextView)bottomActionBar
//                    .findViewById(R.id.bottom_action_bar_artist_name);
//            mArtistName.setText(MusicUtils.getArtistName());
//
//            // Album art
//            ImageView mAlbumArt = (ImageView)bottomActionBar
//                    .findViewById(R.id.bottom_action_bar_album_art);
//
//
//            ImageInfo mInfo = new ImageInfo();
//            mInfo.type = TYPE_ALBUM;
//            mInfo.size = SIZE_THUMB;
//            mInfo.source = SRC_FIRST_AVAILABLE;
//            mInfo.data = new String[]{ String.valueOf(MusicUtils.getCurrentAlbumId()) , MusicUtils.getArtistName(), MusicUtils.getAlbumName() };
//
//            ImageProvider.getInstance( activity ).loadImage( mAlbumArt , mInfo );
//
//        }
//    }

    @Override
    public boolean onLongClick(View v) {
//        Context context = v.getContext();
//        context.startActivity(new Intent(context, QuickQueue.class));
        return true;
    }

}

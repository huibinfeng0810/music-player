package com.music_player.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.music_player.R;
import com.music_player.ui.artist.ArtistFragment;
import com.music_player.ui.genres.GenresFragment;
import com.music_player.ui.music_list.MusicListFragment;
import com.music_player.ui.play_list.PlayListFragment;
import com.music_player.ui.recently.RecentlyFragment;
import com.music_player.ui.special.SpecialFragment;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenghb on 3/7/14.
 */
public class HomeActivity extends SlidingFragmentActivity implements ViewPager.OnPageChangeListener {
    /**
     * constant
     */
    private static final String TAG = "HomeActivity";
    private static final boolean DUG = true;
    /**
     * ----------------------------------------------
     */

    private ViewPager viewPager;
    private List<Fragment> fragmentsList;
    private HomeSlidingMenuFragment mHomeSlidingMenuFragment;

    /**
     * BottomActionBar View
     */
    private ImageButton mPrev, mPlay, mNext, mQueue;
    private BottomActionBar mBottomActionBar;
    private RelativeLayout albumArt, listQueue;
    /**
     * --------------------------------------------------------------------------
     */


    private SlidingUpPanelLayout mPanel;

    BottomActionBarFragment mBActionbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        // Landscape mode on phone isn't ready
//        if (!ApolloUtils.isTablet(this))
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Scan for music
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);


        setContentView(R.layout.activity_home);
        /**
         * sliding menu
         */
        setBehindContentView(R.layout.menu_frame);
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mHomeSlidingMenuFragment = new HomeSlidingMenuFragment();
            t.replace(R.id.menu_frame, mHomeSlidingMenuFragment);
            t.commit();
        } else {
            mHomeSlidingMenuFragment = (HomeSlidingMenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        /**
         * --------------------------------------------
         */
        initViewPager();

    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentsList = new ArrayList<Fragment>();
        fragmentsList.add(new RecentlyFragment());
        fragmentsList.add(new ArtistFragment());
        fragmentsList.add(new SpecialFragment());
        fragmentsList.add(new MusicListFragment());
        fragmentsList.add(new PlayListFragment());
        fragmentsList.add(new GenresFragment());
        viewPager.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (DUG) {
            Log.d(TAG, "---onPageScrolled ---position: " + position + "---positionOffset: " + positionOffset
                    + "---positionOffsetPixels: " + positionOffsetPixels
            );
        }


    }

    @Override
    public void onPageSelected(int position) {
        if (DUG) {
            Log.d(TAG, "---onPageSelected ---position: " + position);
        }


    }

    @Override
    public void onPageScrollStateChanged(int position) {
        if (DUG) {
            Log.d(TAG, "---onPageScrollStateChanged ---position: " + position);
        }

    }
}

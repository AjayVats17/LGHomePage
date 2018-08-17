package com.example.polestaruser.lghomepage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private int[] layouts;
    private ProgressDialog pDialog;
    private String VideoURL="https://youtu.be/t67iXC8vtNA";
    String[] URLs={"http://www.couponcandy.in/wp-content/uploads/2015/07/Men-Sports-Shoes-600x247.jpg",
            "http://www.dealsupdate.in/wp-content/uploads/2013/08/Buy-Footwear.jpg"};

    private TextView[] dots;
    private ImageView play_button;
    private ImageView youtubeVideo;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);
        viewPager =  v.findViewById(R.id.view_pager);
        dotsLayout =  v.findViewById(R.id.layoutDots);
        youtubeVideo=v.findViewById(R.id.imgYoutube);
        play_button=v.findViewById(R.id.btnPlayVideo);
        layouts = new int[]{R.layout.ad_image, R.layout.ad_image};
        addBottomDots(0);



        myViewPagerAdapter = new MyViewPagerAdapter(getActivity(),layouts,URLs);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


       play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(VideoURL)));
                Log.i("Video", "Video Playing....");

            }
        });


        return v;
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];



        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.GRAY);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.BLACK);
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                // btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                //btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


}

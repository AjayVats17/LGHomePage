package com.example.polestaruser.lghomepage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MyViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private int[] layouts;
    private String[] URLs;


    public MyViewPagerAdapter(Context mcontext, int[] mlayouts, String[] mURLs) {
        this.context=mcontext;
        this.layouts=mlayouts;
        this.URLs=mURLs;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts[position], container, false);
        ImageView ad=view.findViewById(R.id.ad1);
        //Bitmap bitmap= BitmapFactory.decodeResource(R.drawable.banner);

        ad.setImageResource(R.drawable.banner);
        //new DownloadImageTask(ad).execute(URLs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}

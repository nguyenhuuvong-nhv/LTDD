package com.example.listview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProfileAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Profile> ProfileList;

    public ProfileAdapter(Context context, int layout, List<Profile> profileList) {
        this.context = context;
        this.layout = layout;
        ProfileList = profileList;
    }

    @Override
    public int getCount() {

        return ProfileList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(layout, null);
        TextView txtTen= (TextView) view.findViewById(R.id.textView);
        TextView txtMota= (TextView) view.findViewById(R.id.tv1);
        ImageView imgHinh= (ImageView) view.findViewById(R.id.imageView);

        Profile profile= ProfileList.get(i);
        txtTen.setText(profile.getTen());
        txtMota.setText(profile.getMota());
        imgHinh.setImageResource(profile.getImg());

        return view;
    }
}

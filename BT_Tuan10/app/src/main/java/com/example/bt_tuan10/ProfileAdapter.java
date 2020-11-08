package com.example.bt_tuan10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bt_tuan10.R;
import com.example.bt_tuan10.model.Profile;

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
        TextView txtTen= (TextView) view.findViewById(R.id.txt_name);
        TextView txtAddress= (TextView) view.findViewById(R.id.txt_address);
        TextView txtPhone= (TextView) view.findViewById(R.id.txt_phone);
        ImageView imgHinh= (ImageView) view.findViewById(R.id.imgAnh);

        Profile profile= ProfileList.get(i);
        txtTen.setText(profile.getTen());
        txtAddress.setText(profile.getAddress());
        txtPhone.setText(profile.getPhone());
        imgHinh.setImageResource(profile.getImage());

        return view;
    }
}

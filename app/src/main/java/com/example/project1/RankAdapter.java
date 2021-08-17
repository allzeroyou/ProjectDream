package com.example.project1;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RankAdapter extends BaseAdapter {

    Context rContext = null;
    LayoutInflater rLayoutInflater = null;
    ArrayList<Mentor> mentorList;

    public RankAdapter(Context context, ArrayList<Mentor> data) {
        rContext = context;
        mentorList = data;
        rLayoutInflater = LayoutInflater.from(rContext);
    }

    @Override
    public int getCount() {
        return mentorList.size();
    }

    @Override
    public Object getItem(int position) {
        return mentorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = rLayoutInflater.inflate(R.layout.mentor_item, null);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        image.setBackground(new ShapeDrawable(new OvalShape()));
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView spec = (TextView)view.findViewById(R.id.spec);
        TextView intro = (TextView)view.findViewById(R.id.intro);

        // image.setImageResource(mentorList.get(position).getImage());
        name.setText(mentorList.get(position).getName());
        spec.setText(mentorList.get(position).getSpec());
        spec.setText(mentorList.get(position).getIntro());

        return view;
    }
}

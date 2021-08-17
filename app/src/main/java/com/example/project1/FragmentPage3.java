package com.example.project1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentPage3 extends Fragment {

    FrameLayout frame;
    TabLayout tabs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_3, container, false);

        frame = view.findViewById(R.id.frame);
        tabs = view.findViewById(R.id.tab);
        tabs.addTab(tabs.newTab().setText("전체"));
        tabs.addTab(tabs.newTab().setText("멘티"));
        tabs.addTab(tabs.newTab().setText("별점"));
        tabs.addTab(tabs.newTab().setText("중등"));
        tabs.addTab(tabs.newTab().setText("고등"));

        Ranking0 rank0 = new Ranking0();
        Ranking1 rank1 = new Ranking1();
        Ranking2 rank2 = new Ranking2();
        Ranking3 rank3 = new Ranking3();
        Ranking4 rank4 = new Ranking4();

        getChildFragmentManager().beginTransaction().add(R.id.frame, rank0).commit();
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = rank0;
                else if(position == 1)
                    selected = rank1;
                else if(position == 2)
                    selected = rank2;
                else if(position == 3)
                    selected = rank3;
                else if(position == 4)
                    selected = rank4;
                getChildFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitleBar();

    }

    private void setTitleBar() {
        String title = "멘토랭킹";
        SimpleDateFormat nFormat = new SimpleDateFormat("MM월 dd일 hh시 기준");
        Date nDate = new Date(System.currentTimeMillis());
        String subTitle = nFormat.format(nDate);

        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setSubtitle(subTitle);
    }

}


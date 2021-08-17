package com.example.project1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Ranking0 extends Fragment {

    ArrayList<Mentor> mentorDataList;

    // for import db
    DBMentor dbMentor;
    SQLiteDatabase db = null;
    Cursor cursor;
    ArrayAdapter adapter, adapter2;

    public static Ranking0 newInstance() {
        return new Ranking0();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.ranking_0, container, false);

        this.InitializeRanking();

        ListView listView = (ListView)view.findViewById(R.id.list0);
        final RankAdapter rAdapter = new RankAdapter(getContext(), mentorDataList);
        listView.setAdapter(rAdapter);

        dbMentor = new DBMentor(getContext(), 3);
        db = dbMentor.getWritableDatabase();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Mentor m = (Mentor)parent.getItemAtPosition(position);

                String str = m.getName();
                Toast.makeText(getContext().getApplicationContext(), "클릭: " + position + " " + str, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void InitializeRanking() {
        mentorDataList = new ArrayList<Mentor>();

        mentorDataList.add(new Mentor("김덕우"));
        mentorDataList.add(new Mentor("최덕우"));
        mentorDataList.add(new Mentor("박덕우"));
        mentorDataList.add(new Mentor("이덕우"));
    }
}

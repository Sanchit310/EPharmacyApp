package example.android.epharmacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Precautions extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<PrecautionItem> mPrecautionList;
    PrecautionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);

        recyclerView  = findViewById(R.id.rview);

        mPrecautionList = new ArrayList<>();
        mPrecautionList.add(new PrecautionItem("iOS One","1"));
        mPrecautionList.add(new PrecautionItem("iOS Two","2"));
        mPrecautionList.add(new PrecautionItem("iOS Three","3"));
        mPrecautionList.add(new PrecautionItem("iOS Four","4"));
        mPrecautionList.add(new PrecautionItem("iOS Five","5"));
        mPrecautionList.add(new PrecautionItem("iOS Six","6"));
        mPrecautionList.add(new PrecautionItem("iOS Seven","7"));
        mPrecautionList.add(new PrecautionItem("iOS Eight","8"));
        mPrecautionList.add(new PrecautionItem("iOS Nine","9"));
        mPrecautionList.add(new PrecautionItem("iOS Ten","10"));
        mPrecautionList.add(new PrecautionItem("iOS Eleven","11"));
        mPrecautionList.add(new PrecautionItem("iOS Twelve","12"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PrecautionAdapter(mPrecautionList);
        recyclerView.setAdapter(mAdapter);
    }
}

package com.app.ivansuhendra.warehousegla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.app.ivansuhendra.warehousegla.adapter.RollInfoAdapter;
import com.app.ivansuhendra.warehousegla.databinding.ActivityFabricRollLoadBinding;
import com.app.ivansuhendra.warehousegla.model.Model;

import java.util.ArrayList;
import java.util.List;

public class FabricRollLoadActivity extends AppCompatActivity implements RollInfoAdapter.OnCheckedChangeListener {
    private static final String TAG = "FabricRollLoadActivity";
    private ActivityFabricRollLoadBinding binding;
    private RollInfoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFabricRollLoadBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        setupRollList();
        populatePackingList();
    }

    private void setupRollList() {
        binding.rvRoll.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        mAdapter = new RollInfoAdapter(this, new ArrayList<>(), true, new RollInfoAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position, Model carton) {
                // Handle item click if needed
            }
        });
        mAdapter.setCheckedChangeListener(this);
        binding.rvRoll.setAdapter(mAdapter);
    }


    private void populatePackingList() {
        List<Model> newData = new ArrayList<>();
        newData.add(new Model("One"));
        newData.add(new Model("Two"));
        newData.add(new Model("Three"));
        newData.add(new Model("Four"));
        newData.add(new Model("Five"));
        newData.add(new Model("Six"));
        newData.add(new Model("Seven"));
        mAdapter.setData(newData);
    }

    @Override
    public void onCheckedChanged(boolean isChecked) {
        Log.i(TAG, "onCheckedChanged: isChecked " + isChecked);
    }
}
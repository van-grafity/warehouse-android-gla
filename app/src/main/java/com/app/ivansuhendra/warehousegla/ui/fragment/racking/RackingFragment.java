package com.app.ivansuhendra.warehousegla.ui.fragment.racking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.ivansuhendra.warehousegla.PackinglistLoadActivity;
import com.app.ivansuhendra.warehousegla.PackinglistRackActivity;
import com.app.ivansuhendra.warehousegla.adapter.ContainerAdapter;
import com.app.ivansuhendra.warehousegla.databinding.FragmentRackingBinding;
import com.app.ivansuhendra.warehousegla.model.Model;
import com.budiyev.android.codescanner.CodeScanner;

import java.util.ArrayList;
import java.util.List;

public class RackingFragment extends Fragment {

    private static final String TAG = "ScanQrFragment";
    private FragmentRackingBinding binding;  // Update binding type
    private ContainerAdapter mAdapter;

    public static RackingFragment newInstance() {
        return new RackingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRackingBinding.inflate(inflater, container, false);

        binding.rvContainer.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false));
        mAdapter = new ContainerAdapter(getActivity(), new ArrayList<>(), new ContainerAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position, Model carton) {
                startActivity(new Intent(getActivity(), PackinglistRackActivity.class));
            }
        });
        binding.rvContainer.setAdapter(mAdapter);
        List<Model> newData = new ArrayList<>();
        newData.add(new Model("CAIU 9181520"));
        newData.add(new Model("CAIU 9181521"));
        newData.add(new Model("CAIU 9181522"));
        newData.add(new Model("CAIU 9181523"));
        newData.add(new Model("CAIU 9181524"));
        newData.add(new Model("CAIU 9181525"));
        newData.add(new Model("CAIU 9181526"));
        mAdapter.setData(newData);

        return binding.getRoot();
    }
}
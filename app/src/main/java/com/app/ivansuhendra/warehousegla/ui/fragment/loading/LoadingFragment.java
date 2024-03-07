package com.app.ivansuhendra.warehousegla.ui.fragment.loading;

import android.app.ProgressDialog;
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

import com.app.ivansuhendra.warehousegla.ContainerDetailActivity;
import com.app.ivansuhendra.warehousegla.PackinglistLoadActivity;
import com.app.ivansuhendra.warehousegla.adapter.ContainerAdapter;
import com.app.ivansuhendra.warehousegla.databinding.FragmentLoadingBinding;
import com.app.ivansuhendra.warehousegla.model.Model;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class LoadingFragment extends Fragment {

    private FragmentLoadingBinding binding;
    private ContainerAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoadingBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        binding.rvContainer.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false));
        mAdapter = new ContainerAdapter(getActivity(), new ArrayList<>(), new ContainerAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position, Model carton) {
                startActivity(new Intent(getActivity(), PackinglistLoadActivity.class));
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

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
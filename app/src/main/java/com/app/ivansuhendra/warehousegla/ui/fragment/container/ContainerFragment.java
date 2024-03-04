package com.app.ivansuhendra.warehousegla.ui.fragment.container;

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
import com.app.ivansuhendra.warehousegla.adapter.ContainerAdapter;
import com.app.ivansuhendra.warehousegla.adapter.PackingListAdapter;
import com.app.ivansuhendra.warehousegla.databinding.FragmentContainerBinding;
import com.app.ivansuhendra.warehousegla.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ContainerFragment extends Fragment {
    private static final String TAG = "TransferFragment";
    private ContainerAdapter mAdapter;

    private FragmentContainerBinding binding;
    private ProgressDialog progressDialog;
    private boolean isLoading = false;
    private int currentPage = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContainerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rvContainer.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false));
        mAdapter = new ContainerAdapter(getActivity(), new ArrayList<>(), new ContainerAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position, Model carton) {
                startActivity(new Intent(getActivity(), ContainerDetailActivity.class));
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
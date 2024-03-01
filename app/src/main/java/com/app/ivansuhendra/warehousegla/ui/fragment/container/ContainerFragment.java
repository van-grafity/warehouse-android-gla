package com.app.ivansuhendra.warehousegla.ui.fragment.container;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.ivansuhendra.warehousegla.databinding.FragmentContainerBinding;

public class ContainerFragment extends Fragment {
    private static final String TAG = "TransferFragment";

    private FragmentContainerBinding binding;
    private ProgressDialog progressDialog;
    private boolean isLoading = false;
    private int currentPage = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContainerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
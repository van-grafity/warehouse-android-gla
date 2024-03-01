package com.app.ivansuhendra.warehousegla.ui.fragment.loading;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.ivansuhendra.warehousegla.databinding.FragmentLoadingBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoadingFragment extends Fragment {

    private FragmentLoadingBinding binding;
    private ProgressDialog progressDialog;
    private Snackbar snackbar;
    private boolean isLoading = false;
    private int currentPage = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoadingBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
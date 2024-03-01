package com.app.ivansuhendra.warehousegla.ui.fragment.racking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.ivansuhendra.warehousegla.databinding.FragmentRackingBinding;
import com.budiyev.android.codescanner.CodeScanner;

public class RackingFragment extends Fragment {

    private static final String TAG = "ScanQrFragment";
    private final int CAMERA_REQUEST_CODE = 101;
    private FragmentRackingBinding binding;  // Update binding type
    private CodeScanner mCodeScanner;
    private String serialCode;

    public static RackingFragment newInstance() {
        return new RackingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRackingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
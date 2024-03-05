package com.app.ivansuhendra.warehousegla;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.ivansuhendra.warehousegla.adapter.PackingListAdapter;
import com.app.ivansuhendra.warehousegla.databinding.ActivityContainerDetailBinding;
import com.app.ivansuhendra.warehousegla.model.Model;
import com.app.ivansuhendra.warehousegla.ui.activity.SealActionListener;

import java.util.ArrayList;
import java.util.List;

public class ContainerDetailActivity extends AppCompatActivity implements SealActionListener {
    private ActivityContainerDetailBinding binding;
    private PackingListAdapter mAdapter;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerDetailBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        initializeViews();
        setupPackingList();
        populatePackingList();

        List<String> items = new ArrayList<>();
        items.add("Mountain Spring");
        items.add("63777-00");
        items.add("LIGHT HTR GREY");

        // Adapter for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.completeColor.setAdapter(adapter);
        binding.completeBatch.setAdapter(adapter);
    }

    private void initializeViews() {
        binding.bgStatusSeal.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        binding.ivUnlock.setImageResource(R.drawable.ic_lock);
        binding.btnOpenSeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOpenSealConfirmationDialog();
            }
        });
    }

    private void setupPackingList() {
        binding.rvPackinglist.setLayoutManager(new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false));
        mAdapter = new PackingListAdapter(this, new ArrayList<>(), new PackingListAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position, Model carton) {
                // Handle item click if needed
            }
        });
        binding.rvPackinglist.setAdapter(mAdapter);
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

    private void showOpenSealConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_open_seal, null);

        builder.setView(dialogView);

        TextView textMessage = dialogView.findViewById(R.id.text_message);
        Button btnYes = dialogView.findViewById(R.id.btn_yes);
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);
        textMessage.setText(getString(R.string.want_to_open_seal));

        alertDialog = builder.create(); // Create AlertDialog instance

        btnCancel.setOnClickListener(v -> {
            dismissDialog();
        });

        btnYes.setOnClickListener(v -> {
            onOpenSeal(true);
           dismissDialog();
        });

        alertDialog.show(); // Show the dialog
    }

    private void dismissDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    private void handleOpenSealAction(boolean isUnlocking) {
        // Load the shine animation

        // Start the animation on the ImageView

        // Update the lock/unlock icon and background color
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onOpenSeal(boolean isUnlocking) {
        // Load the shine animation
        Animation shineAnimation = AnimationUtils.loadAnimation(this, R.anim.shine_animation);

        // Start the animation on the ImageView
        binding.ivUnlock.startAnimation(shineAnimation);

        // Update the lock/unlock icon and background color
        if (isUnlocking) {
            binding.bgStatusSeal.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            binding.ivUnlock.setImageResource(R.drawable.ic_unlock);
        } else {
            binding.bgStatusSeal.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            binding.ivUnlock.setImageResource(R.drawable.ic_lock);
        }
    }
}
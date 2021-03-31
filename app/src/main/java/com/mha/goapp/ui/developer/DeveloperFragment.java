package com.mha.goapp.ui.developer;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mha.goapp.databinding.FragmentDeveloperBinding;

public class DeveloperFragment extends Fragment {

    private FragmentDeveloperBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DeveloperViewModel developerViewModel = new ViewModelProvider(this).get(DeveloperViewModel.class);

        binding = FragmentDeveloperBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDeveloper;
        developerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.testmath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testmath.databinding.MainFragmentBinding;
import com.example.testmath.databinding.SecondFragmentBinding;
import com.example.testmath.ui.main.MainViewModel;

import java.awt.font.TextAttribute;

public class SecondFragment extends Fragment {
    private MainViewModel mViewModel;
    private SecondFragmentBinding binding;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new MainViewModel();
        binding = SecondFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
//        return inflater.inflate(R.layout.second_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textView.setText("Your score is " + Integer.toString(mViewModel.getScore()));
    }
}

package com.example.testmath.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testmath.R;
import com.example.testmath.SecondFragment;
import com.example.testmath.databinding.MainFragmentBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;
//    private Button btn1, btn2, btn3, btn4;
//    private TextView textView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.main_fragment, container, false);
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.setExpression();
        fillButtons(binding);
        ;
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextRound(binding.button.getText().toString());
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextRound(binding.button2.getText().toString());
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextRound(binding.button3.getText().toString());
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextRound(binding.button4.getText().toString());
            }
        });

        mViewModel.expression.observe(getViewLifecycleOwner(), value -> {
            binding.message.setText(String.format(Locale.getDefault(), "%s", value));
        });

    }

    private void fillButtons(MainFragmentBinding bd) {
//        bd.button.setText(Integer.toString(mViewModel.getTrueAnswer()));
//        bd.button2.setText(Integer.toString(mViewModel.getTrueAnswer()));
//        bd.button3.setText(Integer.toString(mViewModel.getTrueAnswer()));
//        bd.button4.setText(Integer.toString(mViewModel.getTrueAnswer()));
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(bd.button);
        buttons.add(bd.button2);
        buttons.add(bd.button3);
        buttons.add(bd.button4);
        for (int i = 0; i < 20; i++) {
            Collections.shuffle(buttons);
        }
        for (Button e :
                buttons) {
            System.out.println(e.getId());
        }
        for (int i = 0; i < 3; i++) {
            buttons.get(i).setText(Integer.toString(mViewModel.getRandomAnswer()));
        }
        buttons.get(3).setText(Integer.toString(mViewModel.getTrueAnswer()));
    }

    private void goToNextRound(String buttonsText) {
        if (mViewModel.getRound() < 6) {
            mViewModel.addScore(buttonsText);
            mViewModel.setExpression();
            fillButtons(binding);
        } else {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SecondFragment.newInstance())
                    .commitNow();
        }
    }
}
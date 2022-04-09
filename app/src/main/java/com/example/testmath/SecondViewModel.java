package com.example.testmath;

import androidx.lifecycle.MutableLiveData;

public class SecondViewModel {
    private Test test = new Test();
    public final MutableLiveData<String> expression = new MutableLiveData<>();
    private int score = 0;

    public int getScore() {
        return test.get_result();
    }
}

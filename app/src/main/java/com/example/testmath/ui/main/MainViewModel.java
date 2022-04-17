package com.example.testmath.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testmath.R;
import com.example.testmath.Test;

import java.util.Random;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private Test test = new Test();
    public final MutableLiveData<String> expression = new MutableLiveData<>();
    private static int score = 0;
    private static int result = 0;

    public void setExpression() {
        test.generate_expression();
        expression.postValue(test.get_expression());
        result = test.get_result();
    }

    public int getRandomAnswer() {
        return test.get_random_answer();
    }

    public int getTrueAnswer() {
        return result;
    }

    public String getHelp()
    {
        Random r = new Random();
        String res = Integer.toString(result);
        score -= 10;
        return res.replace(res.charAt(r.nextInt(res.length())), '*');
    }

    public void addScore(String result) {
        if (test.get_result() == Integer.parseInt(result))
            score += 20;
    }

    public int getRound() {
        return test.getRound();
    }

    public int getScore()
    {
        return score;
    }
}
package com.animation.codelock;

import androidx.annotation.NonNull;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class CodeLockViewModel extends ViewModel {
    // Initialization: String for output window, logic model of CodeLock..
    private MutableLiveData<String> result = new MutableLiveData<String>("");
    private CodeLockModel codeLockModel;
    private ExecutorService threadPool;

    public CodeLockViewModel() {
        super();
        codeLockModel = new CodeLockModel();
        threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public LiveData<String> getLiveDataResult() {
        return result;
    }

    /** ----------------  Functions which intercept clicks ------------------- **/
    // Function: describes what to do when any digit (i. e. button) is pressed
    public void onClickListenerDigitButton(@NonNull final View view) {
        AnimatorSet seriesOfAnimation= new AnimatorSet();
        ObjectAnimator scaleAnimator1 = ObjectAnimator.ofFloat(view, "ScaleX", 1f, 0.9f);
        scaleAnimator1.setDuration(100);
        scaleAnimator1.setAutoCancel(true);
        ObjectAnimator scaleAnimator2 = ObjectAnimator.ofFloat(view, "ScaleX", 0.9f, 1f);
        scaleAnimator2.setDuration(100);
        scaleAnimator2.setAutoCancel(true);
        seriesOfAnimation.play(scaleAnimator1).before(scaleAnimator2);
        seriesOfAnimation.start();

        // Process value of pressed button by CodeLockModel mechanism and update UI
        codeLockModel.putInputSymbol((String) view.getTag());
        result.setValue(codeLockModel.getResult());
    }

    // Function: describes what to do when the enter button is pressed
    public void onClickListenerEnterButton(@NonNull final View view) {
        AnimatorSet seriesOfAnimation= new AnimatorSet();
        ObjectAnimator scaleAnimator1 = ObjectAnimator.ofFloat(view, "ScaleX", 1f, 0.9f);
        scaleAnimator1.setDuration(100);
        scaleAnimator1.setAutoCancel(true);
        ObjectAnimator scaleAnimator2 = ObjectAnimator.ofFloat(view, "ScaleX", 0.9f, 1f);
        scaleAnimator2.setDuration(100);
        scaleAnimator2.setAutoCancel(true);
        seriesOfAnimation.play(scaleAnimator1).before(scaleAnimator2);
        seriesOfAnimation.start();

        // Implement: "hard" calculations for checking if the passed
        //           password is right and pause main UI thread
        try {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (codeLockModel.checkCode(codeLockModel.getResult())) {
                    result.postValue("Access allowed");
                    codeLockModel.reset(); }
                else {
                    result.postValue("Access denied");
                    codeLockModel.reset(); }
            }
        });
        threadPool.awaitTermination(1, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            // Do nothing..
        }
    }

    // Function: describes what to do when the clear button is pressed
    public void onClickListenerClearButton(@NonNull final View view) {
        AnimatorSet seriesOfAnimation= new AnimatorSet();
        ObjectAnimator scaleAnimator1 = ObjectAnimator.ofFloat(view, "ScaleX", 1f, 0.9f);
        scaleAnimator1.setDuration(100);
        scaleAnimator1.setAutoCancel(true);
        ObjectAnimator scaleAnimator2 = ObjectAnimator.ofFloat(view, "ScaleX", 0.9f, 1f);
        scaleAnimator2.setDuration(100);
        scaleAnimator2.setAutoCancel(true);
        seriesOfAnimation.play(scaleAnimator1).before(scaleAnimator2);
        seriesOfAnimation.start();

        // Process value of pressed button by CodeLockModel mechanism and update UI
        codeLockModel.reset();
        result.setValue(codeLockModel.getResult());
    }
}

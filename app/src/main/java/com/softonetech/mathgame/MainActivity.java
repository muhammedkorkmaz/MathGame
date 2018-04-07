package com.softonetech.mathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable {

    Thread Thread;
    boolean IsPlaying;
    boolean IsPaused;

    Button btn_ActionA;
    Button btn_ActionB;
    Button btn_ActionC;

    TextView tv_OperationTop;
    TextView tv_OperationMiddle;
    TextView tv_OperationBottom;

    TextView tv_BestScore;
    TextView tv_CurrentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setActionControls();
        setOperationsControls();
        setScoreControls();
    }

    private void setActionControls() {
        btn_ActionA = findViewById(R.id.btn_ActionA);
        btn_ActionB = findViewById(R.id.btn_ActionB);
        btn_ActionC = findViewById(R.id.btn_ActionC);
    }

    private void setOperationsControls() {
        tv_OperationTop = findViewById(R.id.tv_OperationTop);
        tv_OperationMiddle = findViewById(R.id.tv_OperationMiddle);
        tv_OperationBottom = findViewById(R.id.tv_OperationBottom);
    }

    private void setScoreControls() {
        tv_BestScore = findViewById(R.id.tv_BestScore);
        tv_CurrentScore = findViewById(R.id.tv_CurrentScore);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Pause();
    }

    private void SaveGameState() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        Resume();
    }

    @Override
    public void run() {

        while (IsPlaying) {

        }
    }

    private void Pause() {
        IsPaused = true;
        IsPlaying = false;

        SaveGameState();
    }

    private void Resume() {
        IsPaused = false;
        IsPlaying = true;

        Thread = new Thread(this);
        Thread.start();
    }
}

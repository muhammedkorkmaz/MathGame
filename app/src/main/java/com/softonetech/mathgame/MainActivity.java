package com.softonetech.mathgame;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnDismissListener {

    ChoiceLevelFragment choiceLevelFragment = new ChoiceLevelFragment();
    CustomRandom customRandom = new CustomRandom();
    Choices choices = new Choices();

    int m_Answer = 0;
    int m_OperationTop;
    int m_OperationBottom;

    static boolean IsPlaying;

    Button btn_Menu;

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

        setHeadControls();
        setActionControls();
        setOperationsControls();
        setScoreControls();

        IsPlaying = false;
        FragmentManager fragment = getFragmentManager();
        choiceLevelFragment.show(fragment, "Main Menu");

        btn_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsPlaying = false;
                FragmentManager fragment = getFragmentManager();
                choiceLevelFragment.show(fragment, "Main Menu");
            }
        });

    }

    private void setHeadControls() {
        btn_Menu = findViewById(R.id.btn_menu);
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
    }

    private void SaveGameState() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    void Draw() {
        tv_OperationMiddle.setText(Levels.Operator);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        GenerateRandomAndSet();
        Draw();
    }

    private void GenerateRandomAndSet() {
        customRandom.setMaxValue(Levels.Level + 9);
        customRandom.setMinValue(Levels.Level);

        m_OperationTop = customRandom.generate();
        m_OperationBottom = customRandom.generate();

        if (Levels.Operator.equals(Operators.Plus.getCode())) {

            m_Answer = m_OperationTop + m_OperationBottom;

        } else if (Levels.Operator.equals(Operators.Minus.getCode())) {

            m_Answer = m_OperationTop - m_OperationBottom;

        } else if (Levels.Operator.equals(Operators.Multiplication.getCode())) {

            m_Answer = m_OperationTop * m_OperationBottom;

        } else if (Levels.Operator.equals(Operators.Division.getCode())) {

            do {
                m_OperationTop = customRandom.generate();
                m_OperationBottom = customRandom.generate();

                m_Answer = m_OperationTop / m_OperationBottom;
            } while (m_OperationTop < m_OperationBottom || m_OperationTop % m_OperationBottom != 0);
        }

        tv_OperationTop.setText(Integer.toString(m_OperationTop));
        tv_OperationBottom.setText(Integer.toString(m_OperationBottom));

        SetChoices();
    }

    private void SetChoices() {
        customRandom.setMaxValue(3);
        customRandom.setMinValue(1);
        int num = customRandom.generate();
        int numA;
        int numB;
        int numC;

        switch (num) {
            case 1:
                choices.setATrue();
                choices.setA(m_Answer);
                btn_ActionA.setText(Integer.toString(choices.getA()));

                customRandom.setMaxValue(m_Answer + 5);
                customRandom.setMinValue(m_Answer - 5);

                do {
                    numB = customRandom.generate();
                    choices.setB(numB);
                    btn_ActionB.setText(Integer.toString(choices.getB()));

                } while (numB == m_Answer);

                do {
                    numC = customRandom.generate();
                    choices.setC(numC);
                    btn_ActionC.setText(Integer.toString(choices.getC()));
                } while (numC == m_Answer || numC == numB);

                break;
            case 2:
                choices.setBTrue();
                choices.setB(m_Answer);
                btn_ActionB.setText(Integer.toString(choices.getB()));

                customRandom.setMaxValue(m_Answer + 5);
                customRandom.setMinValue(m_Answer - 5);

                do {
                    numA = customRandom.generate();
                    choices.setA(numA);
                    btn_ActionA.setText(Integer.toString(choices.getA()));

                } while (numA == m_Answer);

                do {
                    numC = customRandom.generate();
                    choices.setC(numC);
                    btn_ActionC.setText(Integer.toString(choices.getC()));
                } while (numC == m_Answer || numC == numA);

                break;
            case 3:
                choices.setCTrue();
                choices.setC(m_Answer);
                btn_ActionC.setText(Integer.toString(choices.getC()));

                customRandom.setMaxValue(m_Answer + 5);
                customRandom.setMinValue(m_Answer - 5);

                do {
                    numA = customRandom.generate();
                    choices.setA(numA);
                    btn_ActionA.setText(Integer.toString(choices.getA()));

                } while (numA == m_Answer);

                do {
                    numB = customRandom.generate();
                    choices.setB(numB);
                    btn_ActionB.setText(Integer.toString(choices.getB()));
                } while (numB == m_Answer || numB == numA);

                break;
        }

    }

}

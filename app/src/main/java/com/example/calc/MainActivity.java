package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private static final int OPERATOR_PLUS = 0;

    private TextView tvResult;
    private TextView tvStackedResult;

    // 숫자키
    private TextView btn0;
    private TextView btn1;
    private TextView btn2;
    private TextView btn3;
    private TextView btn4;
    private TextView btn5;
    private TextView btn6;
    private TextView btn7;
    private TextView btn8;
    private TextView btn9;

    // 사칙연산
    private TextView btnPlus;
    private TextView btnMinus;
    private TextView btnMultiply;
    private TextView btnDivision;

    // etc
    private TextView btnInit;
    private TextView btnDot;
    private TextView btnPercent;
    private TextView btnNegative;
    private TextView btnResult;

    private double result = 0;
    private String currentResult = "";
    private String stackedResult = "";
    private String operator = "";
    private String stackedOperator = "";
    private boolean isNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.result);
        tvStackedResult = findViewById(R.id.stack);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnMinus = findViewById(R.id.btn_minus);
        btnPlus = findViewById(R.id.btn_plus);
        btnMultiply = findViewById(R.id.btn_mul);
        btnDivision = findViewById(R.id.btn_division);

        btnInit = findViewById(R.id.btn_c);
        btnDot = findViewById(R.id.btn_dot);
        btnPercent = findViewById(R.id.btn_percent);
        btnNegative = findViewById(R.id.btn_negative);
        btnResult = findViewById(R.id.btn_result);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnInit.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnNegative.setOnClickListener(this);
        btnPercent.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_c:
                currentResult = "";
                stackedResult = "";
                operator = "";
                stackedOperator = "";
                isNew = false;
                tvResult.setText(currentResult);
                tvStackedResult.setText(stackedResult);
                break;
            case R.id.btn_result:
                Log.e(TAG, stackedResult + " " + stackedOperator + " " + currentResult);
                operator = "=";
                calc();
                break;
            case R.id.btn_negative:
                if (!currentResult.equals("") && !currentResult.equals("0")) {
                    currentResult = String.valueOf(Integer.valueOf(currentResult) * -1);
                    tvResult.setText(currentResult);
                }
                break;
            case R.id.btn_percent:

                if( !stackedResult.equals("") ) {
                    Double stackedNum = Double.valueOf(stackedResult);
                    Double currentNum = Double.valueOf(currentResult);

                    switch (stackedOperator) {
                        case "+":
                            tvStackedResult.setText(stackedResult+stackedOperator+currentResult+"%=");
                            stackedResult = String.valueOf(stackedNum + stackedNum * currentNum / 100);
                            break;
                        case "-":
                            tvStackedResult.setText(stackedResult+stackedOperator+currentResult+"%=");
                            stackedResult = String.valueOf(stackedNum - stackedNum * currentNum / 100);
                            break;
                        case "*":
                            tvStackedResult.setText(stackedResult+stackedOperator+currentResult+"%=");
                            stackedResult = String.valueOf(stackedNum * stackedNum * currentNum / 100);
                            break;
                        case "/":
                            tvStackedResult.setText(stackedResult+stackedOperator+currentResult+"%=");
                            stackedResult = String.valueOf(stackedNum / stackedNum * currentNum / 100);
                            break;
                    }

                    tvResult.setText(stackedResult);
                }

                break;
            case R.id.btn_plus:
                operator = "+";
                calc();
                break;
            case R.id.btn_minus:
                operator = "-";
                calc();
                break;
            case R.id.btn_mul:
                operator = "*";
                calc();
                break;
            case R.id.btn_division:
                operator = "/";
                calc();
                break;
            case R.id.btn_0:
                if (currentResult.equals("") || currentResult.equals("0")) {
                    currentResult = "";
                } else if (operator.equals("")) {
                    currentResult += "0";
                } else {
                    currentResult = "0";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_1:
                if (operator.equals("")) {
                    currentResult += "1";
                } else {
                    currentResult = "1";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_2:
                if (operator.equals("")) {
                    currentResult += "2";
                } else {
                    currentResult = "2";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_3:
                if (operator.equals("")) {
                    currentResult += "3";
                } else {
                    currentResult = "3";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_4:
                if (operator.equals("")) {
                    currentResult += "4";
                } else {
                    currentResult = "4";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_5:
                if (operator.equals("")) {
                    currentResult += "5";
                } else {
                    currentResult = "5";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_6:
                if (operator.equals("")) {
                    currentResult += "6";
                } else {
                    currentResult = "6";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_7:
                if (operator.equals("")) {
                    currentResult += "7";
                } else {
                    currentResult = "7";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_8:
                if (operator.equals("")) {
                    currentResult += "8";
                } else {
                    currentResult = "8";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;
            case R.id.btn_9:
                if (operator.equals("")) {
                    currentResult += "9";
                } else {
                    currentResult = "9";
                    operator = "";
                    isNew = true;
                }
                tvResult.setText(currentResult);
                break;

            case R.id.btn_dot:

                if (currentResult.equals("")) {
                    currentResult += "0.";
                } else if (!currentResult.contains(".")) {
                    currentResult += ".";
                }

                tvResult.setText(currentResult);
                break;
        }
    }

    private void calc() {
        if (operator.equals("=")) {
            if( !stackedResult.equals("") ){
                tvStackedResult.setText(stackedResult + stackedOperator + currentResult + "=");
                cal4();
                tvResult.setText(stackedResult);
            }
        } else if (stackedResult.equals("")) {
            stackedOperator = operator;
            stackedResult = currentResult;
            tvStackedResult.setText(currentResult + stackedOperator);
        } else {
            if (!isNew) {
                stackedOperator = operator;
                tvStackedResult.setText(currentResult + stackedOperator);
            } else { // 없으면
                cal4();
                stackedOperator = operator;
                isNew = false;
                tvStackedResult.setText(stackedResult + operator);
            }
        }
    }

    private void cal4() {
        switch (stackedOperator) {
            case "+":
                Log.e(TAG, stackedResult + " " + stackedOperator + " " + currentResult);
                stackedResult = String.valueOf(Double.valueOf(stackedResult) + Double.valueOf(currentResult));
                Log.e(TAG, stackedResult);
                break;
            case "-":
                Log.e(TAG, stackedResult + " " + stackedOperator + " " + currentResult);
                stackedResult = String.valueOf(Double.valueOf(stackedResult) - Double.valueOf(currentResult));
                Log.e(TAG, stackedResult);
                break;
            case "*":
                Log.e(TAG, stackedResult + " " + stackedOperator + " " + currentResult);
                stackedResult = String.valueOf(Double.valueOf(stackedResult) * Double.valueOf(currentResult));
                Log.e(TAG, stackedResult);
                break;
            case "/":
                Log.e(TAG, stackedResult + " " + stackedOperator + " " + currentResult);
                stackedResult = String.valueOf(Double.valueOf(stackedResult) / Double.valueOf(currentResult));
                Log.e(TAG, stackedResult);
                break;
        }
    }

}
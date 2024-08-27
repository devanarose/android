package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentNumber = "";
    private String operator;
    private Double operand1;
    private Double operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

                    display = findViewById(R.id.display);
                    int[] buttons = {
                            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                            R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
                            R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonClear, R.id.buttonEquals
                    };

                    for (int id : buttons) {
                        findViewById(id).setOnClickListener(this::onButtonClick);
                    }
                }

                private void onButtonClick(View view) {
                    Button button = (Button) view;
                    String buttonText = button.getText().toString();

                    switch (buttonText) {
                        case "C":
                            currentNumber = "";
                            operator = null;
                            operand1 = null;
                            operand2 = null;
                            display.setText("0");
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            operator = buttonText;
                            operand1 = Double.valueOf(currentNumber);
                            currentNumber = "";
                            break;
                        case "=":
                            operand2 = Double.valueOf(currentNumber);
                            double result = performOperation(operand1, operand2, operator);
                            display.setText(String.valueOf(result));
                            currentNumber = String.valueOf(result);
                            break;
                        default:
                            currentNumber += buttonText;
                            display.setText(currentNumber);
                            break;
                    }
                }

                private double performOperation(Double operand1, Double operand2, String operator) {
                    switch (operator) {
                        case "+":
                            return operand1 + operand2;
                        case "-":
                            return operand1 - operand2;
                        case "*":
                            return operand1 * operand2;
                        case "/":
                            return operand1 / operand2;
                        default:
                            return 0;
                    }
                }
            }

        });
    }
}



package com.example.myfirstproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calchandler extends AppCompatActivity {
    TextView txtResult;
    private Stack<Character> operatorStack;
    private Stack<Double> valueStack;
    private boolean error;
    TextView txtname, txtpass;
    Button btnDonate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        txtResult =findViewById(R.id.txtResult);
        operatorStack = new Stack<Character>();
        valueStack = new Stack<Double>();
        error = false;

        txtname = findViewById(R.id.txtname);
        txtpass = findViewById(R.id.txtpass);
        btnDonate = findViewById(R.id.btndonate);

        Intent intent = getIntent();
        String name = intent.getStringExtra(LoginHandler.USERNAME);
        String pass = intent.getStringExtra(LoginHandler.PASSWORD);
        txtname.setText(name);
        txtpass.setText(pass);
    }

    public void btnDonate_Click(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/ToanNPT"));
        startActivity(intent);

    }

    public void Enternumber(View view){
        Button button = (Button) view;
        String text = txtResult.getText().toString();
        if(text.equals("0")){

            txtResult.setText(button.getText().toString());
        }
        else{
            txtResult.append(button.getText().toString());
        }
    }

    public void EnterOperation(View view){
        Button button = (Button) view;
        String text = txtResult.getText().toString();
        if(text.equals("0")){

            txtResult.setText(" " + button.getText().toString() + " ");
        }
        else{
            txtResult.append(" " + button.getText().toString() + " ");
        }
    }

    public void clearAll(View view){
        txtResult.setText("0");
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    private void processOperator(char t){
        double a, b;
        if(valueStack.empty()){
            error = true;
            return;
        }
        else{
            b = valueStack.peek();
            valueStack.pop();
        }

        if (valueStack.empty()) {
            System.out.println("Expression error.");
            error = true;
            return;
        } else {
            a = valueStack.peek();
            valueStack.pop();
        }

        double r = 0;
        if (t == '+') {
            r = a + b;
        } else if (t == '-') {
            r = a - b;
        } else if (t == '*') {
            r = a * b;
        } else if(t == '/') {
            r = a / b;
        } else {
            System.out.println("Operator error.");
            error = true;
        }
        valueStack.push(r);
    }

    public void processInput(View view){
        String input = txtResult.getText().toString();
        String[] tokens = input.split(" ");

        for(int n = 0; n < tokens.length; n++){
            String nextToken = tokens[n];
            char ch = nextToken.charAt(0);
            if(ch >= '0' && ch <= '9'){
                double value = Double.parseDouble(nextToken);
                valueStack.push(value);
            }
            else{
                if(isOperator(ch)){
                    if(operatorStack.empty() || getPrecedence(ch) > getPrecedence(operatorStack.peek())){
                        operatorStack.push(ch);
                    }
                    else{
                        while(!operatorStack.empty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())){
                            char toProcess = operatorStack.peek();
                            operatorStack.pop();
                            processOperator(toProcess);
                        }
                        operatorStack.push(ch);
                    }
                }
                else{
                    if(ch =='('){
                        operatorStack.push(ch);
                    }
                    else{
                        if(ch == ')'){
                            while(!operatorStack.empty() && isOperator(operatorStack.peek())){
                                char toProcess = operatorStack.peek();
                                operatorStack.pop();
                                processOperator(toProcess);
                            }

                            // Loai bo dau mo ngoac
                            if (!operatorStack.empty() && operatorStack.peek() == '(') {
                                operatorStack.pop();
                            } else {
                                System.out.println("Error: unbalanced parenthesis.");
                                error = true;
                            }
                        }
                    }
                }
            }
        }

        //xu li toan hang cuoi cung trong stack
        while (!operatorStack.empty() && isOperator(operatorStack.peek())) {
            char toProcess = operatorStack.peek();
            operatorStack.pop();
            processOperator(toProcess);
        }

        if (error == false) {
            double result = valueStack.peek();
            valueStack.pop();
            if (!operatorStack.empty() || !valueStack.empty()) {
                System.out.println("Expression error.");
            } else {
                txtResult.setText(Double.toString(result));
            }
        }
        else{
            txtResult.setText("Can not caculated");
        }

        valueStack.clear();
        operatorStack.clear();
    }

}

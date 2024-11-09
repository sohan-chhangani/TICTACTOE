package com.thelaymantech.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1 = "", b2 = "", b3 = "", b4 = "", b5 = "", b6 = "", b7 = "", b8 = "", b9 = "";
    int flag,count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void checkClick(View view){
        Button btnCurr =  (Button) view;
        count ++;
        if (btnCurr.getText().toString().isEmpty()){
        if(flag == 0){
            btnCurr.setText("X");
            flag = 1;
        } else {
            btnCurr.setText("O");
            flag = 0;
        }

        if (count > 4){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();
        }

        try {

            if (Objects.equals(b1, b2) && Objects.equals(b2, b3) && !b1.isEmpty()) {
                win(b1);
                restartGame();
            } else if (Objects.equals(b4, b5) && Objects.equals(b5, b6) && !b4.isEmpty()) {
                win(b4);
                restartGame();
            } else if (Objects.equals(b7, b8) && Objects.equals(b8, b9) && !b7.isEmpty()) {
                win(b7);
                restartGame();
            } else if (Objects.equals(b1, b5) && Objects.equals(b5, b9) && !b1.isEmpty()) {
                win(b1);
                restartGame();
            } else if (Objects.equals(b3, b5) && Objects.equals(b5, b7) && !b3.isEmpty()) {
                win(b3);
                restartGame();
            } else if (Objects.equals(b1, b4) && Objects.equals(b4, b7) && !b1.isEmpty()) {
                win(b1);
                restartGame();
            } else if (Objects.equals(b2, b5) && Objects.equals(b5, b8) && !b2.isEmpty()) {
                win(b2);
                restartGame();
            } else if (Objects.equals(b3, b6) && Objects.equals(b6, b9) && !b3.isEmpty()) {
                win(b3);
                restartGame();
            } else if (!b1.isEmpty() && !b2.isEmpty() && !b3.isEmpty()
                    && !b4.isEmpty() && !b5.isEmpty() && !b6.isEmpty()
                    && !b7.isEmpty() && !b8.isEmpty() && !b9.isEmpty())
             {
                restartGame();
            }

        }catch (Exception e)
        {
            Log.e("TAG", "checkClick: ", e);
        }
        }
    }
    private void win(String winner){
        Toast.makeText(this, "Player " + winner + " won", Toast.LENGTH_SHORT).show();
    }
    private void restartGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;
        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = "";
    }

}
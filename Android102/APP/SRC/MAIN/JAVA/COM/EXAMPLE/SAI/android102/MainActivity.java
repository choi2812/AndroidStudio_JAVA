package com.example.sai.android102;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private long time=0;
    private  int nowQuestionNo=0;
    private String qustion;
    private int ans;
    private int right=0;

    public void onClickAction(View view){
        Chronometer chronometer=(Chronometer)findViewById(R.id.chronometer);
        Button btnStart=(Button)findViewById(R.id.btnStart);
        Button btnStop=(Button)findViewById(R.id.btnStop);
        Button btnReset=(Button)findViewById(R.id.btnReset);
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);
        Button btn5=(Button)findViewById(R.id.btn5);
        Button btn6=(Button)findViewById(R.id.btn6);
        Button btn7=(Button)findViewById(R.id.btn7);
        Button btn8=(Button)findViewById(R.id.btn8);
        Button btn9=(Button)findViewById(R.id.btn9);
        TextView messege=(TextView)findViewById(R.id.txtMessege);
        TextView Question=(TextView)findViewById(R.id.txtQuestion);

        if(view.getId()==R.id.btnStart){
            chronometer.setBase(SystemClock.elapsedRealtime() - time);
            chronometer.start();
            nextQuestion();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            btnReset.setEnabled(false);
            messege.setText("それでは問題です。");
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            btn5.setVisibility(View.VISIBLE);
            btn6.setVisibility(View.VISIBLE);
            btn7.setVisibility(View.VISIBLE);
            btn8.setVisibility(View.VISIBLE);
            btn9.setVisibility(View.VISIBLE);
            messege.setVisibility(View.VISIBLE);
            Question.setVisibility(View.VISIBLE);
        }else if(view.getId()==R.id.btnStop){
            chronometer.stop();
            btnStart.setEnabled(false);
            btnStop.setEnabled(false);
            btnReset.setEnabled(true);
            time=SystemClock.elapsedRealtime()-chronometer.getBase();
            messege.setVisibility(View.INVISIBLE);
            Question.setVisibility(View.INVISIBLE);
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);
            btn6.setVisibility(View.INVISIBLE);
            btn7.setVisibility(View.INVISIBLE);
            btn8.setVisibility(View.INVISIBLE);
            btn9.setVisibility(View.INVISIBLE);
            nowQuestionNo=0;
            right=0;
        }else if(view.getId() == R.id.btnReset) {
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            time=0;
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            btnReset.setEnabled(false);
            messege.setVisibility(View.INVISIBLE);
            Question.setVisibility(View.INVISIBLE);
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);
            btn6.setVisibility(View.INVISIBLE);
            btn7.setVisibility(View.INVISIBLE);
            btn8.setVisibility(View.INVISIBLE);
            btn9.setVisibility(View.INVISIBLE);
            nowQuestionNo=0;
            right=0;
        }
    }
    public void ansClick(View view){
        Chronometer chronometer=(Chronometer)findViewById(R.id.chronometer);
        Button btnStart=(Button)findViewById(R.id.btnStart);
        Button btnStop=(Button)findViewById(R.id.btnStop);
        Button btnReset=(Button)findViewById(R.id.btnReset);
        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);
        Button btn5=(Button)findViewById(R.id.btn5);
        Button btn6=(Button)findViewById(R.id.btn6);
        Button btn7=(Button)findViewById(R.id.btn7);
        Button btn8=(Button)findViewById(R.id.btn8);
        Button btn9=(Button)findViewById(R.id.btn9);
        Button btn=(Button)view;
        TextView messege=(TextView)findViewById(R.id.txtMessege);
        TextView Question=(TextView)findViewById(R.id.txtQuestion);
        String enterNumStr=btn.getText().toString();
        nowQuestionNo++;
        int enterNum=Integer.parseInt(enterNumStr);
        if(right<9) {
            if (ans == enterNum) {
                right++;
                messege.setText("正解です！ \n10問の中　\n問題数:" + nowQuestionNo + "\n正解数:" + right);
            } else {
                messege.setText("不正解です！\n10問の中　\n問題数:" + nowQuestionNo + "\n正解数:" + right);
            }
            nextQuestion();
        }else{
            messege.setText("10問正解しました。");
            chronometer.stop();
            btnStart.setEnabled(false);
            btnStop.setEnabled(false);
            btnReset.setEnabled(true);
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);
            btn6.setVisibility(View.INVISIBLE);
            btn7.setVisibility(View.INVISIBLE);
            btn8.setVisibility(View.INVISIBLE);
            btn9.setVisibility(View.INVISIBLE);
            messege.setVisibility(View.INVISIBLE);
            Question.setVisibility(View.INVISIBLE);
            nowQuestionNo=0;
            right=0;
        }
    }
    public void nextQuestion(){
        int a=(int)(Math.random()*9)+1;
        ans=10-a;
        qustion="10 - "+a+" = ";
        TextView txt=(TextView)findViewById(R.id.txtQuestion);
        txt.setText(qustion);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView messege=(TextView)findViewById(R.id.txtMessege);
        TextView Question=(TextView)findViewById(R.id.txtQuestion);

        Button btn1=(Button)findViewById(R.id.btn1);
        Button btn2=(Button)findViewById(R.id.btn2);
        Button btn3=(Button)findViewById(R.id.btn3);
        Button btn4=(Button)findViewById(R.id.btn4);
        Button btn5=(Button)findViewById(R.id.btn5);
        Button btn6=(Button)findViewById(R.id.btn6);
        Button btn7=(Button)findViewById(R.id.btn7);
        Button btn8=(Button)findViewById(R.id.btn8);
        Button btn9=(Button)findViewById(R.id.btn9);

        messege.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        btn7.setVisibility(View.INVISIBLE);
        btn8.setVisibility(View.INVISIBLE);
        btn9.setVisibility(View.INVISIBLE);

    }
}

package com.example.sai.android103;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int Selecteditem=-1;
    private int Contest=0;
    private int win=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.btnRestart);
        btn.setEnabled(false);
        ImageView cpu=(ImageView)findViewById(R.id.imgCpu);
        cpu.setVisibility(View.INVISIBLE);
        Button btnResetContest=(Button)findViewById(R.id.btncontestReset);
        btnResetContest.setVisibility(View.INVISIBLE);

    }

    public void itemSelectAction(View view){
        Button btnRestart=(Button)findViewById(R.id.btnRestart);
        ImageView[] items=new ImageView[3];
        items[0]=(ImageView)findViewById(R.id.imgGu);
        items[1]=(ImageView)findViewById(R.id.imgCh);
        items[2]=(ImageView)findViewById(R.id.imgPa);
        if(btnRestart.isEnabled()==false) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == view) {
                    items[i].setBackgroundColor(Color.RED);
                    Selecteditem = i;
                } else {
                    items[i].setBackgroundColor(Color.WHITE);
                }
            }
        }
    }
    public void startClickAction(View view){

        Button btnRestart=(Button)findViewById(R.id.btnRestart);
        Button btncontestReset=(Button)findViewById(R.id.btncontestReset);
        btncontestReset.setEnabled(true);
        btnRestart.setEnabled(false);
        Button btnStart=(Button)findViewById(R.id.btnStart);
        ImageView Cpu=(ImageView)findViewById(R.id.imgCpu);
        int[] item={R.drawable.j_gu02,R.drawable.j_ch02,R.drawable.j_pa02};

        Random rd=new Random();
        int cpu=rd.nextInt(3);

        ImageView src=(ImageView)findViewById(R.id.imgCpu);
        src.setImageResource(item[cpu]);


        TextView txt=(TextView)findViewById(R.id.txtInfo);
        TextView txt1=(TextView)findViewById(R.id.txtContest);
        if(Selecteditem==cpu){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("引き分け");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
        }else if(Selecteditem==0&&cpu==2){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの負け");
            btnRestart.setEnabled(true);
            txt1.setText("今までの対戦" + Contest + "回・勝った回数" + win + "回");
            btnStart.setEnabled(false);
        }else if(Selecteditem==0&&cpu==1){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの勝ち");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
            win++;
        }else if(Selecteditem==1&&cpu==0){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの負け");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
        }else if(Selecteditem==1&&cpu==2){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの勝ち");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
            win++;
        }else if(Selecteditem==2&&cpu==0){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの勝ち");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
            win++;
        }else if(Selecteditem==2&&cpu==1){
            Contest++;
            Cpu.setVisibility(View.VISIBLE);
            txt.setText("あなたの負け");
            txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
            btnRestart.setEnabled(true);
            btnStart.setEnabled(false);
        }else{
            Cpu.setVisibility(View.INVISIBLE);
            txt.setText("お願い！手を選択してね！");
            btnRestart.setEnabled(false);
            btnStart.setEnabled(true);
        }
        Selecteditem=-1;
    }
    public void restartClickAction(View view){
        if (Contest!=0){
            Button btnResetContest=(Button)findViewById(R.id.btncontestReset);
            btnResetContest.setVisibility(View.VISIBLE);
        }
        Button btnRestart=(Button)findViewById(R.id.btnRestart);
        btnRestart.setEnabled(false);
        Button btnStart=(Button)findViewById(R.id.btnStart);
        btnStart.setEnabled(true);
        ImageView cpu=(ImageView)findViewById(R.id.imgCpu);
        cpu.setVisibility(View.INVISIBLE);
        ImageView[] items=new ImageView[3];
        items[0]=(ImageView)findViewById(R.id.imgGu);
        items[1]=(ImageView)findViewById(R.id.imgCh);
        items[2]=(ImageView)findViewById(R.id.imgPa);
        items[0].setBackgroundColor(Color.WHITE);
        items[1].setBackgroundColor(Color.WHITE);
        items[2].setBackgroundColor(Color.WHITE);
        TextView txt=(TextView)findViewById(R.id.txtInfo);
        txt.setText("次の手を選択して！！！");
    }
    public void contestReset(View view){
        Contest=0;
        win=0;
        TextView txt2=(TextView)findViewById(R.id.txtInfo);
        txt2.setText("何連勝できるかな？");
        TextView txt1=(TextView)findViewById(R.id.txtContest);
        txt1.setText("今までの対戦"+Contest+"回・勝った回数"+win+"回");
        Button btnResetContest=(Button)findViewById(R.id.btncontestReset);
        btnResetContest.setVisibility(View.INVISIBLE);
    }

}

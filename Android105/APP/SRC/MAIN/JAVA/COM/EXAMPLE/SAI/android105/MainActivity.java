package com.example.sai.android105;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt1=(TextView)findViewById(R.id.txtZankin);
        txt1.setVisibility(View.INVISIBLE);
        CheckBox chk = (CheckBox) findViewById(R.id.chx2jikai);//2차 체크 박스
        chk.setEnabled(false);
        RadioButton rbt=(RadioButton)findViewById(R.id.rbt100);
        rbt.setChecked(true);
    }
    public void startClickAction(View view) {
        Log.i("Android105--1", String.valueOf(view));//금액 화면 표시
        EditText edt = (EditText) findViewById(R.id.edtTotalPay);//금액입력란
        Spinner sp1 = (Spinner) findViewById(R.id.sprPeople);//인원입력란
        RadioButton rbt100=(RadioButton)findViewById(R.id.rbt100);//100엔 선택란
        RadioButton rbt500=(RadioButton)findViewById(R.id.rbt500);//500엔 선택란
        RadioButton rbt1000=(RadioButton)findViewById(R.id.rbt1000);//1000엔 선택란
        ToggleButton tbtn=(ToggleButton)findViewById(R.id.tbtnToku);//토글버튼on총무이익
        TextView txt=(TextView)findViewById(R.id.txtCollectMoney);//1인당지불 금액
        TextView txt1=(TextView)findViewById(R.id.txtMyPay);//총무지불 금액
        String msg = edt.getText().toString();//금액입력을 문자열로 바꿈
        String num = (String) sp1.getSelectedItem();//인원선택
        CheckBox chk = (CheckBox) findViewById(R.id.chx2jikai);//2차 체크 박스
        TextView txt4=(TextView)findViewById(R.id.txtZankin);//
        Log.i("Android105", msg);//금액 화면 표시
        Log.i("android105", num);//인원 화면 표시
        //금액계산 변수들
        int people1=0;//1인당지불가격
        int coin=0;// 백원단위 동전갯수
        int people=0;//개인지불 금액
        int combin=0;//총무제외한 사람이 모은 총 금액
        int kanji=0;//총무가 내야하는 금액
        int total=0;
        int zannkin=0;


        int number=0;//인원인수를 int로 변환

        if(msg.isEmpty()){
            AlertDialog alert = new AlertDialog.Builder( this )
                    .setTitle("Android105")
                    .setMessage("金額を入力してください")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            chk.setEnabled(false);
        }else {

            if (num.equals("２人")) {
                number = 2;
            } else if (num.equals("３人")) {
                number = 3;
            } else if (num.equals("４人")) {
                number = 4;
            } else if (num.equals("５人")) {
                number = 5;
            } else if (num.equals("６人")) {
                number = 6;
            } else if (num.equals("７人")) {
                number = 7;
            } else if (num.equals("８人")) {
                number = 8;
            } else {
                number = 9;
            }
            chk.setEnabled(true);
            if (rbt100.isChecked() == true) {//100엔단위 선택
                if (tbtn.isChecked() == true) {//총무 이득모드 선택
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                } else if(tbtn.isChecked() == false) {//총무 이득모드 해제
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = coin * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                }
            } else if (rbt500.isChecked() == true) {
                if (tbtn.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액

                } else if(tbtn.isChecked() == false) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = coin * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    //txt.setText(people+"円"); //1총무제외 1인당 지불금액.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                    //txt1.setText(kanji+"円");
                }

            } else if (rbt1000.isChecked() == true) {
                if (tbtn.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액

                } else if(tbtn.isChecked() == false) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = coin * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                }
            }
            if (!msg.isEmpty()) {
                txt.setText(people + "円"); //1총무제외 1인당 지불금액.
                txt1.setText(kanji + "円");
            }
            //2차 있을 경우
            if (chk.isChecked() == true) {
                if (rbt100.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                } else if (rbt500.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                } else if (rbt1000.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                }
                txt.setText(people + "円");
                txt1.setText(people + "円");
                total = people * number;
                zannkin = total - Integer.parseInt(msg);
                txt4.setText(zannkin + "円");

                txt4.setVisibility(View.VISIBLE);
                tbtn.setEnabled(false);
            } else if(chk.isChecked() == false) {
                tbtn.setEnabled(true);
                txt4.setVisibility(View.INVISIBLE);
            }
        }

    }
    public void tbtnChangeAction(View view) {
        ToggleButton tbtn=(ToggleButton)findViewById(R.id.tbtnToku);
        if(tbtn.isChecked()==true){
            Toast.makeText(this,"幹事得モードON!",Toast.LENGTH_SHORT).show();
            startClickAction();
        }else{
            Toast.makeText(this,"幹事得モードOFF",Toast.LENGTH_SHORT).show();
            startClickAction();
        }
    }
    public void chkChangeAction(View view) {
        TextView txt1=(TextView)findViewById(R.id.txtZankin);
        CheckBox chk=(CheckBox)findViewById(R.id.chx2jikai);
        ToggleButton tbtn=(ToggleButton)findViewById(R.id.tbtnToku);
        if(chk.isChecked()==true){
            txt1.setVisibility(View.VISIBLE);
            tbtn.setChecked(false);
            startClickAction();
        }else{
            txt1.setVisibility(View.INVISIBLE);
            startClickAction();
        }
    }
    public void startClickAction() {
        EditText edt = (EditText) findViewById(R.id.edtTotalPay);//금액입력란
        Spinner sp1 = (Spinner) findViewById(R.id.sprPeople);//인원입력란
        RadioButton rbt100=(RadioButton)findViewById(R.id.rbt100);//100엔 선택란
        RadioButton rbt500=(RadioButton)findViewById(R.id.rbt500);//500엔 선택란
        RadioButton rbt1000=(RadioButton)findViewById(R.id.rbt1000);//1000엔 선택란
        ToggleButton tbtn=(ToggleButton)findViewById(R.id.tbtnToku);//토글버튼on총무이익
        TextView txt=(TextView)findViewById(R.id.txtCollectMoney);//1인당지불 금액
        TextView txt1=(TextView)findViewById(R.id.txtMyPay);//총무지불 금액
        String msg = edt.getText().toString();//금액입력을 문자열로 바꿈
        String num = (String) sp1.getSelectedItem();//인원선택
        CheckBox chk = (CheckBox) findViewById(R.id.chx2jikai);//2차 체크 박스
        TextView txt4=(TextView)findViewById(R.id.txtZankin);//
        Log.i("Android105", msg);//금액 화면 표시
        Log.i("android105", num);//인원 화면 표시
        //금액계산 변수들
        int people1=0;//1인당지불가격
        int coin=0;// 백원단위 동전갯수
        int people=0;//개인지불 금액
        int combin=0;//총무제외한 사람이 모은 총 금액
        int kanji=0;//총무가 내야하는 금액
        int total=0;
        int zannkin=0;


        int number=0;//인원인수를 int로 변환

        if(msg.isEmpty()){
            AlertDialog alert = new AlertDialog.Builder( this )
                    .setTitle("Android105")
                    .setMessage("金額を入力してください")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            chk.setEnabled(false);
        }else {

            if (num.equals("２人")) {
                number = 2;
            } else if (num.equals("３人")) {
                number = 3;
            } else if (num.equals("４人")) {
                number = 4;
            } else if (num.equals("５人")) {
                number = 5;
            } else if (num.equals("６人")) {
                number = 6;
            } else if (num.equals("７人")) {
                number = 7;
            } else if (num.equals("８人")) {
                number = 8;
            } else {
                number = 9;
            }
            chk.setEnabled(true);
            if (rbt100.isChecked() == true) {//100엔단위 선택
                if (tbtn.isChecked() == true) {//총무 이득모드 선택
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                } else if(tbtn.isChecked() == false) {//총무 이득모드 해제
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = coin * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                }
            } else if (rbt500.isChecked() == true) {
                if (tbtn.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액

                } else if(tbtn.isChecked() == false) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = coin * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    //txt.setText(people+"円"); //1총무제외 1인당 지불금액.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                    //txt1.setText(kanji+"円");
                }

            } else if (rbt1000.isChecked() == true) {
                if (tbtn.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액

                } else if(tbtn.isChecked() == false) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = coin * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    combin = people * (number - 1);//총무제외한 사람이 모은 총 금액.
                    kanji = Integer.parseInt(msg) - combin;//총무가 내야하는 금액
                }
            }
            if (!msg.isEmpty()) {
                txt.setText(people + "円"); //1총무제외 1인당 지불금액.
                txt1.setText(kanji + "円");
            }
            //2차 있을 경우
            if (chk.isChecked() == true) {
                if (rbt100.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 100;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 100;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                } else if (rbt500.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 500;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 500;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                } else if (rbt1000.isChecked() == true) {
                    people1 = Integer.parseInt(msg) / number;//1인당지불가격 구함.
                    coin = people1 / 1000;// 백원단위 동전갯수를 구함.
                    people = (coin + 1) * 1000;// 총무이득일 경우의 개인지불 금액을 구함.
                    if(Integer.parseInt(msg)==0){
                        people=0;
                    }
                }
                txt.setText(people + "円");
                txt1.setText(people + "円");
                total = people * number;
                zannkin = total - Integer.parseInt(msg);
                txt4.setText(zannkin + "円");

                txt4.setVisibility(View.VISIBLE);
                tbtn.setEnabled(false);
            } else if(chk.isChecked() == false) {
                tbtn.setEnabled(true);
                txt4.setVisibility(View.INVISIBLE);
            }
        }

    }
}

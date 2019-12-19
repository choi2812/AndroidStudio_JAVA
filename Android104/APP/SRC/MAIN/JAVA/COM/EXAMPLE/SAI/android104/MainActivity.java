package com.example.sai.android104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt=(TextView)findViewById(R.id.txtError);
        txt.setVisibility(View.INVISIBLE);
    }
    public void startClickAction(View view){
        EditText edt=(EditText)findViewById(R.id.edtTotalPay);
        String msg=edt.getText().toString();
        Spinner sp1=(Spinner)findViewById(R.id.sprPeople);
        String num=(String)sp1.getSelectedItem();
        TextView txt1=(TextView)findViewById(R.id.txtError);
        Log.i("Android104", msg);
        Log.i("android104", num);
        int number = 0;

        if(msg.length()==0){
            TextView txt=(TextView)findViewById(R.id.txtError);
            txt.setVisibility(View.VISIBLE);
            txt1.setText("支払額を入力してください");
        }
        if(num.equals("２人")){
            number=2;
        }else if(num.equals("３人")){
            number=3;
        }else if(num.equals("４人")){
            number=4;
        }else if(num.equals("５人")){
            number=5;
        }else if(num.equals("６人")){
            number=6;
        }else if(num.equals("７人")){
            number=7;
        }else if(num.equals("８人")){
            number=8;
        }else if(num.equals("９人")){
            number=9;
        }else{
            TextView txt=(TextView)findViewById(R.id.txtError);
            txt.setVisibility(View.VISIBLE);
            txt1.setText("人数エラー");
        }
        if(msg != null&& number !=0){
            TextView txt=(TextView)findViewById(R.id.txtCollectionMoney);
            TextView txtleft=(TextView)findViewById(R.id.txtMyPay);
            int total= Integer.parseInt(msg)/number;
            int left=Integer.parseInt(msg)%number;
            //txt.setText(num);
            txtleft.setText(String.valueOf(total+left));
            txt.setText(String.valueOf(total));
        }else{
            TextView txt=(TextView)findViewById(R.id.txtError);
            txt.setVisibility(View.VISIBLE);
            txt1.setText("エラー");
        }


        // if(Integer.parseInt(msg)){}
    }

}

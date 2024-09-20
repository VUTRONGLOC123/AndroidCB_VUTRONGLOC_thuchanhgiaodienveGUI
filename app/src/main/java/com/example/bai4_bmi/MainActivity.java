package com.example.bai4_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText edtTen =findViewById(R.id.edtTen);
        EditText edtCao = findViewById(R.id.edtCao);
        EditText edtCan = findViewById(R.id.edtCan);
        EditText edtBMI = findViewById(R.id.edtBMI);
        EditText edtChuanDoan = findViewById(R.id.edtChanDoan);
        Button btnTinh = findViewById(R.id.btnTinh);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float cao =0;
                float can = 0;
                float ketQua=0;
                if(!edtCao.getText().toString().trim().equals("")){
                    cao = Float.parseFloat(edtCao.getText().toString());

                }if(!edtCan.getText().toString().trim().equals("")){
                    can = Float.parseFloat(edtCan.getText().toString());
                }
                if(cao!=0&can!=0) {
                    ketQua = (float) (can/Math.pow(cao,2));
                }
                edtBMI.setText(ketQua+"");
                if(ketQua<18){
                    edtChuanDoan.setText("Bạn gầy");
                }else if(ketQua<=24.9){
                    edtChuanDoan.setText("Bạn bình thường");

                }else if(ketQua<=29.9){
                    edtChuanDoan.setText("Bạn béo phì độ 1");

                }
                else if(ketQua<=34.9){
                    edtChuanDoan.setText("Bạn béo phì độ 2");

                }else{
                    edtChuanDoan.setText("Bạn béo phì độ 3");

                }
            }
        });
    }
}
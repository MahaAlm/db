package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_viewAll;
    EditText et_name,et_age;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add=findViewById(R.id.btn_add);
        btn_viewAll=findViewById(R.id.btn_view);
        et_age=findViewById(R.id.et_age);
        et_name=findViewById(R.id.et_name);
        lv_customerList=findViewById(R.id.lv_StudentList);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerModel customerodel;
                try {
                    customerodel=new customerModel(-1,et_name.getText().toString(),Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, customerodel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                    customerodel=new customerModel(-1,"error",0);
                }

                DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
                boolean b= dataBaseHelper.addOne(customerodel);

                Toast.makeText(MainActivity.this, "Success "+b, Toast.LENGTH_SHORT).show();
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "View button", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
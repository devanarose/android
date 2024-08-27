package com.example.listener;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import android.view.MotionEvent;



public class MainActivity extends AppCompatActivity {

    String[] mobilearray = {"android","iphone","windowsmobile","blackberry","webOS","ubuntu","windows"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button b= (Button) findViewById(R.id.button1);
        TextView tv = (TextView) findViewById(R.id.tv);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Button clicked");
            }
        });

        ListView listView = findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mobilearray);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View arg1, int pos, long id) {
                Toast.makeText(MainActivity.this,"long clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ConstraintLayout myView = (ConstraintLayout) findViewById(R.id.main);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this,"TOUCH EVENT",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}
package com.example.progressbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import statements
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.AsyncTask;


public class MainActivity extends AppCompatActivity {
    //declare reference variables for widgets
    private TextView progressText;
    private Button button;
    private ProgressBar progressBar;

    //counter variable
    private int progress = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //initialize the widgets
        progressBar = findViewById(R.id.progressBar);
        progressText = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }
    public void submit(View v){
        //disable the button once the task is running
        button.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);

        //start the worker thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                //write the code to be executed inside the thread
                for(progress=0;progress<=100;progress+=1){
                    try{
                        //500 ms break between each increment
                        Thread.sleep(500);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    //update textview and progress bar : ui thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //progressBar.setProgress(progress);
                            //progressText.setText("PROGRESS : "+progress+ "%");
                            button.setEnabled(true);
                            progressText.setText("COMPLETED");
                            progressBar.setVisibility(View.GONE);
                        }
                    });// end ui thread
                } // end for loop
            }
        }).start();
    }
}
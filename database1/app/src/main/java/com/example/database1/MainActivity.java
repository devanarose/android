package com.example.database1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edit1,edit2,edit3;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //initialize edittext
        edit1 = findViewById(R.id.editTextName);
        edit2 = findViewById(R.id.editTextCourse);
        edit3 = findViewById(R.id.editTextSemester);
        dbHandler = new DBHandler(MainActivity.this);

    }
    //onclick method
    public void addStudent(View v){
    String studentName = edit1.getText().toString();
    String studentCourse = edit2.getText().toString();
    int studentSemester = Integer.parseInt(edit3.getText().toString());
    dbHandler.addNewStudent(studentName,studentCourse,studentSemester);
        Toast.makeText(MainActivity.this,"student is added",Toast.LENGTH_LONG).show();
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
    }
    public void findStudent(View v){
        String studentName=edit1.getText().toString();
        Student student = dbHandler.searchStudent(studentName);
        if(student!=null){
            edit2.setText(String.valueOf(student.getCourse()));
            edit3.setText((String.valueOf(student.getSemester())));
        }
        else {
            Toast.makeText(MainActivity.this,"no match found!",Toast.LENGTH_LONG).show();
        }
    }

    public void deleteStudent(View v){
        String studentName=edit1.getText().toString();
        boolean result = dbHandler.delete(studentName);
        if(result){
            Toast.makeText(MainActivity.this,"Deletion has occurred!",Toast.LENGTH_LONG).show();
            edit3.setText("");
            edit2.setText("");
            edit1.setText("");
        }
        else{
            Toast.makeText(MainActivity.this,"No match found!",Toast.LENGTH_LONG).show();
        }
    }

    public void updateStudent(View v){

    }
}


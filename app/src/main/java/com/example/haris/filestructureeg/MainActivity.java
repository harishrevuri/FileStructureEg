package com.example.haris.filestructureeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textmsg = (EditText)findViewById(R.id.editText);
    }

    public void WriteBtn(View v) {
        try{
            FileOutputStream fileOutputStream = openFileOutput("Login.xml", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(textmsg.getText().toString());
            outputStreamWriter.close();

            Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ReadBtn(View v) {
        try {
            FileInputStream fileInputStream = openFileInput("Login.xml");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            char[] input = new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead = inputStreamReader.read(input)) > 0) {

                String readString = String.copyValueOf(input, 0, charRead);
                s += readString;
            }
            inputStreamReader.close();
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

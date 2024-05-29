package com.fabexp.textrepitertr;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edNumber;
    private Button btnRepeat;
    private Button btnCopy;
    private TextView view;
    private TextView marqueeText;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edname);
        edNumber = findViewById(R.id.ednumber);
        btnRepeat = findViewById(R.id.repeat01);
        btnCopy = findViewById(R.id.btcopy);
        view = findViewById(R.id.view);
        marqueeText = findViewById(R.id.marqueeText);
        checkBox=findViewById(R.id.check01);

        marqueeText.setSelected(true);


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edName.getText().toString();
                String numberStr = edNumber.getText().toString();
                
                if(TextUtils.isEmpty(text)){
                    edName.setError("Please Enter text");
                    edName.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(numberStr)){
                    edNumber.setError("Please Enter Number");
                    return;
                }

                if(checkBox.isChecked()) {
                    //check box when true
                    if (!numberStr.isEmpty() && !text.isEmpty() ) {
                        int repeatCount = Integer.parseInt(numberStr);
                        StringBuilder repeatedText = new StringBuilder();

                        if (repeatCount <= 1000) {
                            for (int i = 0; i < repeatCount; i++) {
                                repeatedText.append(text).append("\n");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, " Enter a repetition number under 1000", Toast.LENGTH_SHORT).show();
                        }

                        view.setText(repeatedText.toString().trim());
                    } else {
                        Toast.makeText(MainActivity.this, "Empty input please fillup", Toast.LENGTH_SHORT).show();
                    }
                }

                //check box when false
                else{
                    if (!numberStr.isEmpty() && !text.isEmpty()) {
                        int repeatCount = Integer.parseInt(numberStr);
                        StringBuilder repeatedText = new StringBuilder();

                        if (repeatCount <= 1000) {
                            for (int i = 0; i < repeatCount; i++) {
                                repeatedText.append(text).append(" ");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a repetition number under 1000", Toast.LENGTH_SHORT).show();
                        }

                        view.setText(repeatedText.toString().trim());
                    } else {
                        Toast.makeText(MainActivity.this, "Empty input please fillup", Toast.LENGTH_SHORT).show();
                    }


                }



            }
        });






        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edName.getText().toString();
                String numberStr = edNumber.getText().toString();

                if(TextUtils.isEmpty(text)){
                    edName.setError("Please Enter text");
                    edName.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(numberStr)){
                    edNumber.setError("Please Enter Number");
                    return;
                }

                if(checkBox.isChecked()) {
                    //check box when true
                    if (!numberStr.isEmpty() && !text.isEmpty()) {
                        int repeatCount = Integer.parseInt(numberStr);
                        StringBuilder repeatedText = new StringBuilder();

                        if (repeatCount <= 1000) {
                            for (int i = 0; i < repeatCount; i++) {
                                repeatedText.append(text).append("\n");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a repetition number under 1000", Toast.LENGTH_SHORT).show();
                        }

                        view.setText(repeatedText.toString().trim());
                    } else {
                        Toast.makeText(MainActivity.this, "Empty input please fillup", Toast.LENGTH_SHORT).show();
                    }
                }

                //check box when false
                else{
                    if (!numberStr.isEmpty()) {
                        int repeatCount = Integer.parseInt(numberStr);
                        StringBuilder repeatedText = new StringBuilder();

                        if (repeatCount <= 1000) {
                            for (int i = 0; i < repeatCount; i++) {
                                repeatedText.append(text).append(" ");
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a repetition number under 1000", Toast.LENGTH_SHORT).show();
                        }

                        view.setText(repeatedText.toString().trim());
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a repetition number", Toast.LENGTH_SHORT).show();
                    }


                }



            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToCopy = view.getText().toString();
                if (!textToCopy.isEmpty()) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    if (clipboard != null) {
                        ClipData clip = ClipData.newPlainText("Copied Text", textToCopy);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(MainActivity.this, "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to get clipboard service", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No text to copy", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

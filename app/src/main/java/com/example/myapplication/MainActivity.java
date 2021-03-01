package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcw.togglebutton.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private Button exit;
    private TextView textView;
    private com.zcw.togglebutton.ToggleButton toggleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result);
        toggleBtn = findViewById(R.id.toggleButton);
        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle(getResources().getString(R.string.chiqish));

                builder.setMessage(getResources().getString(R.string.message));

                builder.setCancelable(false); // ikkitasidan bittasini tanlash

                builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        toggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on){
                    textView.setText("Status: Yoqildi");
                }else {
                    textView.setText("Status: O'chirildi");
                }
            }
        });
    }
}
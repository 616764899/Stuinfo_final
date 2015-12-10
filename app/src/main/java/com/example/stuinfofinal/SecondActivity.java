package com.example.stuinfofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView stuname;
    private TextView stuprofessional;
    private TextView stuclass;
    private TextView stugrade;
    private Button stubutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stuinfoitem);

        stuname = (TextView) findViewById(R.id.stuname);
        stuprofessional = (TextView) findViewById(R.id.stuprofessional);
        stuclass = (TextView) findViewById(R.id.stuclass);
        stugrade = (TextView) findViewById(R.id.stugrade);
        stubutton = (Button) findViewById(R.id.stubutton);

        Item item = (Item) getIntent().getSerializableExtra("item");
        StuinfoItem stuinfoitem = (StuinfoItem) getIntent().getSerializableExtra("stuinfoitem");

        stuname.setText(stuinfoitem.getStuname());
        stuprofessional.setText(stuinfoitem.getStuprofessional());
        stuclass.setText(stuinfoitem.getStuclass());
        stugrade.setText(stuinfoitem.getStugrade());

        stubutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
       // Toast.makeText(this, item.getText()/*+item.getImageview()*/, Toast.LENGTH_SHORT).show();

    }
}

package com.example.esicc.helloworld;

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    View.OnClickListener onClickListener;

    EditText h;
    EditText w;
    EditText pass;
    TextView bmi;
    TextView aid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        h = (EditText)findViewById(R.id.editText);
        w = (EditText)findViewById(R.id.editText2);
        pass = (EditText)findViewById(R.id.editText4);


        bmi = (TextView)findViewById(R.id.textView4);
        aid=(TextView)findViewById(R.id.textView6);;
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        };
        /*button.setOnClickListener(onClickListener);
        button.setOnClickListener(null);*/
        button.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                float fh = Float.parseFloat(h.getEditableText().toString());
                float fw = Float.parseFloat(w.getEditableText().toString());
                float fs = fw/((fh/100)*(fh/100));

                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits( 2 );

                bmi.setText(nf.format(fs));
                if(fs>23) aid.setText("中度肥胖");
                if(fs<23) aid.setText("肥胖");

                aid.setText(pass.getEditableText());
                //Toast.makeText(this,"Onclick",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

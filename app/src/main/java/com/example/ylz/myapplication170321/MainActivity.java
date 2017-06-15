package com.example.ylz.myapplication170321;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caitou;

    private EditText huoniao1;
    private EditText huoniao2;
    private EditText huoniao3;
    private EditText huoniao4;

    private EditText tuoniao1;
    private EditText tuoniao2;
    private EditText tuoniao3;
    private EditText tuoniao4;

    private EditText huxi1;
    private EditText huxi2;
    private EditText huxi3;
    private EditText huxi4;

    private TextView jieguo1;
    private TextView jieguo2;
    private TextView jieguo3;
    private TextView jieguo4;

    private Button jisuan;
    private Button qingchu;
    private Button tuichu;

    int [] tuoniao={0,0,0,0};
    int [] huxi={0,0,0,0};
    int[] huoniao={0,0,0,0};
    int[] jieguo={0,0,0,0};
    double caiTou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caitou=(EditText)findViewById(R.id.caitou);

        huoniao1=(EditText)findViewById(R.id.huoniao1);
        huoniao2=(EditText)findViewById(R.id.huoniao2);
        huoniao3=(EditText)findViewById(R.id.huoniao3);
        huoniao4=(EditText)findViewById(R.id.huoniao4);


        tuoniao1=(EditText)findViewById(R.id.tuoniao1);
        tuoniao2=(EditText)findViewById(R.id.tuoniao2);
        tuoniao3=(EditText)findViewById(R.id.tuoniao3);
        tuoniao4=(EditText)findViewById(R.id.tuoniao4);


        huxi1=(EditText)findViewById(R.id.huxi1);
        huxi2=(EditText)findViewById(R.id.huxi2);
        huxi3=(EditText)findViewById(R.id.huxi3);
        huxi4=(EditText)findViewById(R.id.huxi4);


        jieguo1=(TextView) findViewById(R.id.jieguo1);
        jieguo2=(TextView) findViewById(R.id.jieguo2);
        jieguo3=(TextView) findViewById(R.id.jieguo3);
        jieguo4=(TextView) findViewById(R.id.jieguo4);


        jisuan= (Button)findViewById(R.id.jisuan);

        jisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                huoniao[0]=Integer.parseInt(huoniao1.getText().toString().trim());
                huoniao[1]=Integer.parseInt(huoniao2.getText().toString().trim());
                huoniao[2]=Integer.parseInt(huoniao3.getText().toString().trim());
                huoniao[3]=Integer.parseInt(huoniao4.getText().toString().trim());

                tuoniao[0]=Integer.parseInt(tuoniao1.getText().toString().trim());
                tuoniao[1]=Integer.parseInt(tuoniao2.getText().toString().trim());
                tuoniao[2]=Integer.parseInt(tuoniao3.getText().toString().trim());
                tuoniao[3]=Integer.parseInt(tuoniao4.getText().toString().trim());

                huxi[0]=Integer.parseInt(huxi1.getText().toString().trim());
                huxi[1]=Integer.parseInt(huxi2.getText().toString().trim());
                huxi[2]=Integer.parseInt(huxi3.getText().toString().trim());
                huxi[3]=Integer.parseInt(huxi4.getText().toString().trim());





                caiTou=Double.parseDouble(caitou.getText().toString().trim());

                jisuan();

            }
        });

    }


    public void jisuan() {
        int i, j, a=0,b=0;
        int tuoniaoZhi[]={0,0,0,0};
        int huoniaoZhi[]={0,0,0,0};
        int zongZhi[]={0,0,0,0};

        //计算拖鸟
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                if (huxi[i] > huxi[j]) {
                    a += tuoniao[i] + tuoniao[j];
                } else if (huxi[i] == huxi[j]) {
                    a += 0;
                } else {
                    a += -tuoniao[i] - tuoniao[j];
                }
            }
            tuoniaoZhi[i]=a;
            a=0;
        }

        //四舍五入
        for (i = 0; i < 4; i++) {
            if(huxi[i]<0)
            {
                if (huxi[i] % 10 <= -5)
                {
                    huxi[i] = (huxi[i] / 10 - 1) * 10;
                }
                else
                    huxi[i] = huxi[i] / 10 * 10;
            }
            else{
                if (huxi[i] % 10 >= 5) {
                    huxi[i] = (huxi[i] / 10 + 1) * 10;
                } else
                    huxi[i] = huxi[i] / 10 * 10;
            }
        }



        //计算活鸟
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
              if (huxi[i] == huxi[j]) {
                    b += 0;
                } else {
                      b+=(huxi[i]-huxi[j])*caiTou*(huoniao[i]+1)*(huoniao[j]+1);
                  }
              }
            huoniaoZhi[i]=b;
            b=0;
            }

        for(i=0;i<4;i++) {
            zongZhi[i]=huoniaoZhi[i]+tuoniaoZhi[i];
        }
        jieguo1.setText(zongZhi[0]+"");
        jieguo2.setText(zongZhi[1]+"");
        jieguo3.setText(zongZhi[2]+"");
        jieguo4.setText(zongZhi[3]+"");
        }




    }




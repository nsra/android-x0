package com.example.xogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    boolean ga=true;
    int[] GS={2,2,2,2,2,2,2,2,2};
    int x=0;
    int[][] WG={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};

    int p1=0,p2=0,pd=0;

    public void XO(View view) {

        ImageView image = (ImageView) view;
        int t = Integer.parseInt(image.getTag().toString());
        if (GS[t] == 2 &&ga==true) {
            GS[t]=x;

            if (x == 0) {
                image.setImageResource(R.drawable.ic_clear);
                x = 1;
            } else {
                image.setImageResource(R.drawable.ic_tac);
                x = 0;
            }

            for (int W[]:WG){
                if (GS[W[0]]==GS[W[1]]&&GS[W[1]]==GS[W[2]]&&GS[W[0]]!=2){
                    ga=false;
                    String message="O";
                    if (GS[W[0]]==0){
                        message="X";
                    }
                    LinearLayout layout=(LinearLayout)findViewById(R.id.w_layout);
                    layout.setVisibility(View.VISIBLE);
                    TextView text=(TextView) findViewById(R.id.txtW);
                    text.setText(message +":is won");

                    TextView txtp1=(TextView) findViewById(R.id.txtp1);
                    TextView txtp2=(TextView) findViewById(R.id.txtp2);
                    TextView txtD=(TextView) findViewById(R.id.txtD);
                    if (message=="O"){
                        p2++;
                        txtp2.setText(p2);
                    }else if (message=="X"){
                        p1++;
                        txtp2.setText(p1);
                    }else {
                        pd++;
                        txtD.setText(pd);
                    }

                }else {
                    boolean draw=true;
                    for (int c :GS){
                        if (c==2)draw=false;
                    }if (draw==true){
                        LinearLayout layout=(LinearLayout)findViewById(R.id.w_layout);
                        layout.setVisibility(View.VISIBLE);
                        TextView text=(TextView) findViewById(R.id.txtW);
                        text.setText("The is a Draw");
                    }
                }

            }

        }
    }
    public void butplay(View v){

        for(int i=0;i<GS.length;i++){
            GS[i]=2;
        }

        ImageView im0 =(ImageView)findViewById(R.id.im0);
        im0.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im1 =(ImageView)findViewById(R.id.im1);
        im1.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im2 =(ImageView)findViewById(R.id.im2);
        im2.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im3 =(ImageView)findViewById(R.id.im3);
        im3.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im4 =(ImageView)findViewById(R.id.im4);
        im4.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im5 =(ImageView)findViewById(R.id.im5);
        im5.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im6 =(ImageView)findViewById(R.id.im6);
        im6.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im7 =(ImageView)findViewById(R.id.im7);
        im7.setImageResource(R.drawable.ic_tic_tac_toe);
        ImageView im8 =(ImageView)findViewById(R.id.im8);
        im8.setImageResource(R.drawable.ic_tic_tac_toe);

        LinearLayout layout2 = (LinearLayout) findViewById(R.id.w_layout);
        layout2.setVisibility(View.INVISIBLE);
        ga=true;
    }


    public void but_exit(View view) {
        System.exit(0);
    }
}

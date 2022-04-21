package com.example.tic_tac_toe_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    boolean gameactive=true;
    //player representation
    // 0 - O
    //1 - X
    //2-null
    int activeplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};  //initially 2 means null neighther O nor X
    int [][] winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedimg=Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gamereset(view);
        }
        if(gamestate[tappedimg]==2 && gameactive)
        {
            t1=(TextView)findViewById(R.id.status);
            gamestate[tappedimg]=activeplayer;
            img.setTranslationY(-100f);
            if(activeplayer==0)
            {
                img.setImageResource(R.drawable.o);
                activeplayer=1;
                t1.setText("X's turn tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.x);
                activeplayer=0;
                t1.setText("O's turn tap to play");
            }
        }
        //to check winning position
        for(int[] winpos :winposition)
        {
            //condition for winning position
            if(gamestate[winpos[0]]==gamestate[winpos[1]] && gamestate[winpos[1]]==gamestate[winpos[2]] && gamestate[winpos[0]]!=2)
            {String winner;
                gameactive=false;
                if(gamestate[winpos[0]]==0)
                {
                    winner="O is winner";
                }
                else
                {
                    winner="X is winner";
                }
                t1.setText(winner);
            }
            ;
        }


    }
    public void gamereset(View view)
    {
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
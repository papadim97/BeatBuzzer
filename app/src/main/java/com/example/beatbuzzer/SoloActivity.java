package com.example.beatbuzzer;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SoloActivity extends AppCompatActivity {
    MediaPlayer player;
    String apantisi;
    int number;
    int score = 0;
    int count = 0;
    String apantisi1,apantisi2,apantisi3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);

       apantisi = start(apantisi);



        Button  btn =(Button)findViewById(R.id.nextbtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                elenxos();

            }
        });


        //Toast.makeText(this, "telos 1 loup", Toast.LENGTH_SHORT).show();
        // start();

        /*
        Button  btn =(Button)findViewById(R.id.nextbtn);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            elenxos();
                           // score();
                            score = score+1;

                        }
                    });
         */




    }
   // public String EditText()


    public void elenxos(){

        final EditText et= (EditText)findViewById(R.id.editText);
        if (apantisi=="pantelidis") {
            apantisi1="Παντελής Παντελίδης";
            apantisi2="Παντελής";
            apantisi3="pantelis pantelidis";
            }
        if (apantisi=="amarilis") {
            apantisi1="αμαρυλλις";
            apantisi2="Αμαρυλλίς";
            apantisi3="Amarullis";
            }
        if (apantisi=="giorgosgiannias") {
            apantisi1="Γιώργος Γιαννιάς";
            apantisi2="Γιαννιάς";
            apantisi3="giorgos giannias";
        }
        if (apantisi=="giorgosmazonakis") {
            apantisi1="Γιώργος Μαζωνάκης";
            apantisi2="Μαζωνάκης";
            apantisi3="giorgos mazonakis";
        }
        if (apantisi=="makisdimakis") {
            apantisi1="Μάκης Δημάκης";
            apantisi2="Δημάκης";
            apantisi3="makis dimakis";
        }



                if((et.getText().toString().equals(apantisi)==true)||(et.getText().toString().equals(apantisi1)==true)||(et.getText().toString().equals(apantisi2)==true)||(et.getText().toString().equals(apantisi3)==true)){
                    stopPlayer();

                    TextView textView = (TextView) findViewById(R.id.apantisi);
                    textView.setText("sosto");

                    apantisi= start(apantisi);

                    score = score+1;
                    if (score >= 5){
                        Intent intent = new Intent(SoloActivity.this, WinActivity.class);
                        startActivity(intent);
                    }



                }else{
                     if(count >=5){
                        Intent intent = new Intent(SoloActivity.this, LostActivity.class);
                        startActivity(intent);
                    }

                    else{
                        count = count+1;
                    }
                    TextView textView = (TextView) findViewById(R.id.apantisi);
                    textView.setText("la9os");
                    stopPlayer();
                    apantisi= start(apantisi);

                }



    }
    public void score(){
        TextView textView = (TextView) findViewById(R.id.score);
        textView.setText(score);
    }


    public int getnumber (int a) {
        Random rand = new Random();
        number = rand.nextInt(5) + 1;
        return (a);
    }
    public String start(String apantisi) {
        getnumber(number);
        if (number == 1) {
            player = MediaPlayer.create(this, R.raw.pantelispantelidis);
            player.start();
            apantisi = "pantelidis";

        } else if (number == 2) {
            player = MediaPlayer.create(this, R.raw.amarilis);
            player.start();
            apantisi = "amarilis";
        } else if (number == 3) {
            player = MediaPlayer.create(this, R.raw.giorgosgiannias);
            player.start();
            apantisi = "giorgosgiannias";
        } else if (number == 4) {
            player = MediaPlayer.create(this, R.raw.giorgosmazonakis);
            player.start();
            apantisi = "giorgosmazonakis";
        } else {
            player = MediaPlayer.create(this, R.raw.makisdimakis);
            player.start();
            apantisi = "makisdimakis";
        }

       // TextView textView = (TextView) findViewById(R.id.textView);
      //  textView.setText(apantisi);

        return(apantisi);
    }



    public void play(View v) {

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.pantelispantelidis);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;

            Toast.makeText(this, "Επόμενο Τραγούδι", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}

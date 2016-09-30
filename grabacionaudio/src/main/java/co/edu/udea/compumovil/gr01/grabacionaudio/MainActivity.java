package co.edu.udea.compumovil.gr01.grabacionaudio;

import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Bundle;
import android.os.Environment;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    Button play,stop,record;
    private MediaRecorder myAudioRecorder;
    private String outputFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button)findViewById(R.id.btnPlay);
        stop=(Button)findViewById(R.id.btnStop);
        record=(Button)findViewById(R.id.btnRecord);

        stop.setEnabled(false);
        play.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/prueba.3gp";;

        myAudioRecorder=new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnRecord:
                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                }
                catch (IllegalStateException e) {
                    e.printStackTrace();
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
                record.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnStop:
                myAudioRecorder.stop();
                myAudioRecorder.release();
                myAudioRecorder  = null;

                stop.setEnabled(false);
                play.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Audio recorded successfully",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnPlay:
                MediaPlayer m = new MediaPlayer();

                try {
                    m.setDataSource(outputFile);
                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    m.prepare();
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
                m.start();
                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
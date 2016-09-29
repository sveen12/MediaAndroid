package co.edu.udea.compumovil.gr01.mediaandroid;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class StreamingActivity extends AppCompatActivity {
    MediaPlayer md; //Varialbe de clase de tipo Media Player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
    }


    public void streamingOnClick(View view) {
        switch(view.getId()){
            case R.id.btn_play:

                String url = "http://www.lawebmallorca.com/musica/lethergo.mp3"; //Definimos en que url esta el recurso o musica que vamos a escuchar
                md = new MediaPlayer(); //Creamos el objeto mediaplayer
                md.setAudioStreamType(AudioManager.STREAM_MUSIC); //Le decimos a ese objeto que va a obtener musica via Stream atraves de un canal externo.
                try {
                    md.setDataSource(url); // Le decimos de donde la va a obtener la url previamente creada
                    md.prepare(); // preparamos el Objeto para ser lanzado
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "La Cancion no esta en el servidor", Toast.LENGTH_LONG);
                }

                md.start(); // Lanzamos el MediaPlayer metodo Play

                break;
            case R.id.stop:
                md.stop();
                break;
        }
    }
}


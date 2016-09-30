package co.edu.udea.compumovil.gr01.mediaandroid;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;


public class StreamingActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer; //Varialbe de clase de tipo Media Player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
    }


    public void streamingOnClick(View view) {
        switch(view.getId()){
            case R.id.internet_music:

                String url = "https://ia802508.us.archive.org/5/items/testmp3testfile/mpthreetest.mp3"; //Definimos en que url esta el recurso o musica que vamos a escuchar
                mediaPlayer = new MediaPlayer(); //Creamos el objeto mediaplayer
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); //Le decimos a ese objeto que va a obtener musica via Stream atraves de un canal externo.
                try {
                    mediaPlayer.setDataSource(url); // Le decimos de donde la va a obtener la url previamente creada
                    mediaPlayer.prepare(); // preparamos el Objeto para ser lanzado
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "La Cancion no esta en el servidor", Toast.LENGTH_LONG);
                }

                mediaPlayer.start(); // Lanzamos el MediaPlayer metodo Play
                break;

            case R.id.stop:
                mediaPlayer.stop();
                break;
        }
    }
}


package co.edu.udea.compumovil.gr01.mediaandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.compumovil.gr01.mediaandroid.Canciones.Cancion;

public class MainActivity extends AppCompatActivity {
    private ListView listamusicos; //Iniciamos la lista
    private MediaPlayer mediaPlayer; //Iniciamos el objeto MediaPlayer en contexto de clase para que se vea en cualquier metodo.
    private List<Cancion> canciones; //Variable para lanzar el Toast previo a la cancion
    private Button play, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canciones = new ArrayList<>();
        play = (Button) findViewById(R.id.btn_play);
        stop = (Button) findViewById(R.id.btn_stop);
        listamusicos = (ListView) findViewById(R.id.lista_musica);

        Field[] fields=R.raw.class.getFields();
        for(int i= 1; i < fields.length; i++){
            canciones.add(  new Cancion(fields[i].getName(),
                                            getResources().getIdentifier(fields[i].getName(),
                                            "raw",
                                            getPackageName())));
        }

        play.setEnabled(false);
        stop.setEnabled(false);


        listamusicos.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, canciones)); //Aplicamos el Adaptador

        listamusicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText( getApplicationContext(),
                                "La cancion es " + canciones.get(i).getTitulo(),
                                Toast.LENGTH_LONG).show();

                mediaPlayer = MediaPlayer.create(   getApplicationContext(),
                                canciones.get(i).getId()); //Creamos el Objeto MediaPlay con los parametros (Donde se va a escuchar, Que cancion se va a escuchar)
                play.setEnabled(true);
            }
        });
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_play:
                if(mediaPlayer !=null){
                    mediaPlayer.start();
                    stop.setEnabled(true);
                }else{
                    Toast.makeText(this,"No ha seleccionado ningún audio.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_stop:
                if(stop.isEnabled()){
                    mediaPlayer.stop();
                    mediaPlayer = null;
                    play.setEnabled(false);
                    stop.setEnabled(false);
                }
                break;

            case R.id.btn_streaming:
                Intent intent = new Intent(this, StreamingActivity.class);
                startActivity(intent);
                break;
        }
    }
}

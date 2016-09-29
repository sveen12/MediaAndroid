package co.edu.udea.compumovil.gr01.mediaandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.udea.compumovil.gr01.mediaandroid.Canciones.Cancion;

public class VentanaDosActivity extends AppCompatActivity {

    Cancion cancion; //Creamos el objeto cancion de nuestro Bean para almacenar la cancion pulsada
    MediaPlayer md; //Creamos el objeto MediaPlayer en contexto de clase para usarlo en cualquier parte del metodo
    ListView listacanciones; //Iniciamos la lista de nuestra aplicacion
    ArrayList<Cancion> listado = new ArrayList<Cancion>(); //Creamos un ArrayList de objetos cancion para almacenar diferentes canciones dentro de ella.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_dos);

        md = new MediaPlayer(); //Iniciamos el objeto MediaPlayer
        listacanciones = (ListView) findViewById(R.id.listacanciones); //Obtenemos la referencia a la lista
        listado.add(new Cancion("let her go", R.raw.let_her_go)); //Añadimos una cancion al ArrayList de Canciones

        ArrayAdapter<Cancion> l = new ArrayAdapter<Cancion>(getApplicationContext(), android.R.layout.simple_list_item_1, listado); //Iniciamos el Adaptador para la lista
        listacanciones.setAdapter(l); //Aplicamos el Adaptador para mostrar la lista


        listacanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        cancion = listado.get(i); //Obtenemos del arraylist el objeto cancion dependiendo de la pulsacion en la lista y lo guardamos en una varialbe
                        md = MediaPlayer.create(getApplicationContext(), cancion.getId());//Iniciamos el objeto Media play con donde se escuchara y que Cancion se va a escuchar.
                        md.start();//Iniciamos el objeto MediaPlayer
                        break;
                }
            }});
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.play:
                md.start();
                break;
            case R.id.stop:
                md.stop();
                break;
            case R.id.pausa:
                md.pause();
                break;
        }
    }

}

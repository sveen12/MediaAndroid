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

public class MainActivity extends AppCompatActivity {
    ListView listamusicos; //Iniciamos la lista
    MediaPlayer md; //Iniciamos el objeto MediaPlayer en contexto de clase para que se vea en cualquier metodo.
    String[] musicos = {"Let her go"}; //Array de Strings para mostrar en la lista
    String cancion; //Variable para lanzar el Toast previo a la cancion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listamusicos = (ListView) findViewById(R.id.lista_musica);
        listamusicos.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, musicos)); //Aplicamos el Adaptador

        listamusicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        cancion = musicos[i].toString(); //Recogemos el String del array para mostrar el Toast
                        Toast.makeText(getApplicationContext(),"La cancion es de - " + cancion, Toast.LENGTH_LONG).show(); //Lanzamos el Toast con el titulo
                        md = MediaPlayer.create(getApplicationContext(),R.raw.let_her_go); //Creamos el Objeto MediaPlay con los parametros (Donde se va a escuchar, Que cancion se va a escuchar)
                        break;
                }
            }
        });
    }


    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_play:
                md.start();
                break;
            case R.id.btn_stop:
                md.stop();
                break;
            case R.id.btn_ventanados:
                Intent in = new Intent(getApplicationContext(), VentanaDosActivity.class);
                startActivity(in);
                break;
            case R.id.btn_ventanatres:
                Intent in2 = new Intent(getApplicationContext(), StreamingActivity.class);
                startActivity(in2);
                break;
        }
    }
}

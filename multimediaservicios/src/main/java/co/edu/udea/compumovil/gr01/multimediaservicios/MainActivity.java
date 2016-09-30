package co.edu.udea.compumovil.gr01.multimediaservicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_PLAY = "co.edu.udea.compumovil.gr01.multimediaservicios.action.PLAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MyService.class);

        switch (view.getId()){
            case R.id.btnIniciar:
                intent.setAction(ACTION_PLAY);
                startService(intent);
                break;
            case R.id.btnParar:
                stopService(intent);
                break;
        }
    }
}

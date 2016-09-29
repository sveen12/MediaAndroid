package co.edu.udea.compumovil.gr01.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public  VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView_video);

        Uri path = Uri.parse("android.resource://co.edu.udea.compumovil.gr01.video/"+ R.raw.intromono);
        //Para agregar controles
        // MediaController mc = new MediaController(this);
        //videoView.setMediaController(mc);
        videoView.setVideoURI(path);


    }

    public void onClick(View view) {
        videoView.start();
    }
}

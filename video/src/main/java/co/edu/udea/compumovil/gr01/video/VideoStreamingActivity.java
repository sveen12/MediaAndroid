package co.edu.udea.compumovil.gr01.video;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;

public class VideoStreamingActivity extends AppCompatActivity
        implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    String url = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);

        mediaController = new MediaController(this);
        surfaceView = (SurfaceView) findViewById(R.id.surfView);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaController.setMediaPlayer((MediaController.MediaPlayerControl) mp);
        mediaController.setAnchorView(surfaceView);
        mediaController.setEnabled(true);
        mediaPlayer.start();
    }
}

package co.edu.udea.compumovil.gr01.multimediaservicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service implements MediaPlayer.OnPreparedListener {
    private static final String ACTION_PLAY = "co.edu.udea.compumovil.gr01.multimediaservicios.action.PLAY";
    MediaPlayer player;
    
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(ACTION_PLAY)) {
            player = MediaPlayer.create(this, R.raw.let_her_go);
            player.setOnPreparedListener(this);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }
}

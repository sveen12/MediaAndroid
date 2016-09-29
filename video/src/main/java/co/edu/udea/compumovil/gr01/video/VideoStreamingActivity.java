package co.edu.udea.compumovil.gr01.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoStreamingActivity extends AppCompatActivity {
    VideoView vidView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);

        vidView = (VideoView)findViewById(R.id.myVideo);
        String vidAddress =
                "https://archive.org/download/ksnn_compilation_master_the_internet/" +
                        "ksnn_compilation_master_the_internet_512kb.mp4";
        Uri vidUri = Uri.parse(vidAddress);
        MediaController vidControl = new MediaController(this);

        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);
        vidView.setVideoURI(vidUri);
    }

    public void onClickStreaming(View view) {
        switch(view.getId()){
            case R.id.btnVideoStreamingPlay:
                vidView.start();
                break;
            case R.id.btnVideoStreamingStop:
                vidView.stopPlayback();
                break;
        }

    }
}

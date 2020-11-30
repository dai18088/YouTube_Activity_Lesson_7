package gr.uom.youtube2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String YT_API_KEY="AlzaSyCtA_gKPjbLxD1F3pNLpf5XyLUFuneF7fy";

    private static final String VIDEO_1="EBev9JCkvrE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout=(ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(layout);


        YouTubePlayerView player=new YouTubePlayerView(this);
        player.setLayoutParams(new ConstraintLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));

        layout.addView(player);

        player.initialize(YT_API_KEY,this);




    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Toast.makeText(this,"YT Player init success!",Toast.LENGTH_SHORT).show();

        youTubePlayer.cueVideo(VIDEO_1);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"YT Player init error!",Toast.LENGTH_SHORT).show();
    }
}
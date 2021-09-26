package com.example.tech_dynamosstresliv.MoodMusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.technopratik.moodmusic.R;

import java.util.ArrayList;
//import androidx.fragment.app.Fragment;

public class Happy extends Fragment {


    @Override
    public View onCreateView (  LayoutInflater inflater ,  ViewGroup container ,  Bundle savedInstanceState ) {
        return inflater.inflate ( R.layout.activity_sad_mood, container , false );




    }

    @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated ( savedInstanceState );

        JcPlayerView jcplayerView = (JcPlayerView) getActivity ().findViewById(R.id.jcplayerview);
        ArrayList<JcAudio> jcAudios1 = new ArrayList<>();
        jcAudios1.add(JcAudio.createFromURL("Mediation Music","https://firebasestorage.googleapis.com/v0/b/mood-music-22e5d.appspot.com/o/Motivitional%2Fcalm-river-lofi-background-music-for-videos-7289.mp3?alt=media&token=b1ee14c0-4bb0-4a6f-b34b-6401f3914e08"));
        jcAudios1.add(JcAudio.createFromURL("Motavation Music","https://firebasestorage.googleapis.com/v0/b/mood-music-22e5d.appspot.com/o/Motivitional%2Fdeep-music-every-day-kingdom-5015.mp3?alt=media&token=f9b6d8c1-d67f-4d82-8d77-0ec9095594be"));

        jcplayerView.initPlaylist(jcAudios1, null);
        jcplayerView.createNotification();



    }
}

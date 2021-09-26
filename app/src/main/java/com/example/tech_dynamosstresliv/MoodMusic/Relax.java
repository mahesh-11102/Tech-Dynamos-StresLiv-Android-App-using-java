package com.example.tech_dynamosstresliv.MoodMusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.example.tech_dynamosstresliv.R;

import java.util.ArrayList;
//import androidx.fragment.app.Fragment;

public class Relax extends Fragment {


    @Override
    public View onCreateView (  LayoutInflater inflater ,  ViewGroup container ,  Bundle savedInstanceState ) {
        return inflater.inflate ( R.layout.activity_motivitional_mood, container , false );




    }

    @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated ( savedInstanceState );

        JcPlayerView jcplayerView = (JcPlayerView) getActivity ().findViewById(R.id.jcplayerview);
        ArrayList<JcAudio> jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Happy Music","https://firebasestorage.googleapis.com/v0/b/mood-music-22e5d.appspot.com/o/Motivitional%2Frdn056.mp3?alt=media&token=c9affa8f-79f9-4b08-83cf-f3004f310d25"));
        jcAudios.add(JcAudio.createFromURL("Happy Music","https://firebasestorage.googleapis.com/v0/b/mood-music-22e5d.appspot.com/o/Motivitional%2Fchilled-acoustic-indie-folk-instrumental-background-music-for-videos-5720.mp3?alt=media&token=2d03a71c-0d59-462a-9016-aa3b542bf5c7"));

        jcplayerView.initPlaylist(jcAudios, null);
        jcplayerView.createNotification();



    }
}

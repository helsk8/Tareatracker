package com.example.tareatracker.ui

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.tareatracker.R

class VideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout para este fragmento
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Configura el VideoView y MediaController
        val videoView: VideoView = view.findViewById(R.id.videoView)
        val mediaController = MediaController(requireContext())

        // Vincula el MediaController con el VideoView
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Reproduce video desde res/raw
        val videoUri: Uri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.videoejem1)
        videoView.setVideoURI(videoUri)

        // Inicia el video automáticamente
        videoView.start()
    }
}
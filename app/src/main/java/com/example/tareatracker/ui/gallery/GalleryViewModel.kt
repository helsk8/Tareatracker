package com.example.tareatracker.ui.gallery

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tareatracker.R

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Lista de tareas"


    }
    val text: LiveData<String> = _text


}
package com.example.pexelsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pexelsapplication.ui.screens.NetworkStubScreen
import com.example.pexelsapplication.ui.screens.PexelsPhotoApp
import com.example.pexelsapplication.ui.theme.PexelsApplicationTheme
import com.example.pexelsapplication.ui.viewmodels.PhotosViewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PexelsApplicationTheme {
                PexelsPhotoApp()
            }
        }
    }
}

@Preview
@Composable
private fun PexelsPhotoAppPreview(){
    PexelsPhotoApp()
}




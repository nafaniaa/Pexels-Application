package com.example.pexelsapplication.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pexelsapplication.PexelsApplication
import com.example.pexelsapplication.data.PexelsPhoto
import com.example.pexelsapplication.data.PexelsPhotoDatabase
import com.example.pexelsapplication.data.PhotosRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface PhotosUiState{
    data class Success(val photoSearch: List<PexelsPhoto>) : PhotosUiState
    object Error  : PhotosUiState
    object Loading  : PhotosUiState
}
class PhotosViewModels(
    private val photosRepository: PhotosRepository
) : ViewModel(){

    var photosUiState: PhotosUiState by mutableStateOf(PhotosUiState.Loading)
        private set


    init {
        getPhotos()
    }

    fun getPhotos(query: String = "photo", perPage: Int = 30, page: Int = 1){
        viewModelScope.launch {
            photosUiState = PhotosUiState.Loading
            photosUiState = try{
                PhotosUiState.Success(photosRepository.getPhotos(query, perPage, page))
            } catch (e: IOException){
                PhotosUiState.Error
            } catch (e: HttpException){
                PhotosUiState.Error
            }

        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PexelsApplication)
                val photosRepository = application.container.photosRepository
                PhotosViewModels(photosRepository = photosRepository)
            }
        }
    }

}
package com.example.mininetflix.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mininetflix.BuildConfig
import com.example.mininetflix.network.TmdbApi
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    private val _trailerKey = MutableLiveData<String?>()
    val trailerKey: LiveData<String?> get() = _trailerKey

    private var hasFetched = false
    fun fetchTrailer(movidId: Int){
        if (hasFetched) return
        hasFetched = true

        viewModelScope.launch {
            try {
                val response = TmdbApi.retrofitService.getVideos(
                    movieId = movidId,
                    apiKey = BuildConfig.TMDB_API_KEY
                )
                // Prefer an OFFICIAL YouTube Trailer; fall back to any YouTube Trailer.
                val trailer = response.results.firstOrNull {
                    it.site == "YouTube" && it.type == "Trailer" && it.official
                } ?: response.results.firstOrNull {
                    it.site == "YouTube" && it.type == "Trailer"
                }
                _trailerKey.value = trailer?.key
            } catch (e: Exception) {
                _trailerKey.value = null
            }
        }
    }
}
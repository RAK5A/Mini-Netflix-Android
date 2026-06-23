package com.example.mininetflix

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android.mininetflix.overview.OverviewViewModel
import com.example.android.mininetflix.overview.TmdbApiStatus
import com.example.mininetflix.databinding.ActivityMainBinding
import com.example.mininetflix.overview.MoviePosterAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /*private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this)[OverviewViewModel::class.java]
    }

    private val posterAdapter = MoviePosterAdapter()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate with View Binding, then show its root view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*// Connect the grid to its adapter
        binding.photosGrid.adapter = posterAdapter

        // Observe the movie list and hand it to the adapter
        viewModel.movies.observe(this) { movies ->
            posterAdapter.submitList(movies)
        }

        // Loading / error message
        viewModel.statusMessage.observe(this) { message ->
            binding.statusText.text = message
        }

        // Spinner while loading, error icon on failure, both hidden when done
        viewModel.status.observe(this) { status ->
            binding.loadingSpinner.visibility =
                if (status == TmdbApiStatus.LOADING) View.VISIBLE else View.GONE
            binding.errorImage.visibility =
                if (status == TmdbApiStatus.ERROR) View.VISIBLE else View.GONE
        }*/
    }
}
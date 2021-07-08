package com.raywenderlich.cinematic.data

import com.raywenderlich.cinematic.data.repository.MoviesRepository
import com.raywenderlich.cinematic.data.sources.MoviesCache
import com.raywenderlich.cinematic.model.Cast
import com.raywenderlich.cinematic.model.CastResponse
import com.raywenderlich.cinematic.model.Movie
import kotlinx.coroutines.flow.Flow

class MoviesDataRepository(
    private val cacheStore: MoviesCache
) : MoviesRepository {
  override suspend fun saveMovies(movies: List<Movie>) {
    cacheStore.saveMovies(movies)
  }

  override suspend fun deleteAllMovies() {
    cacheStore.deleteAllMovies()
  }

  override suspend fun getFavouriteMovies(): Flow<List<Movie>> {
    return cacheStore.getFavouriteMovies()
  }

  override suspend fun getPopularMovies(): Flow<List<Movie>> {
    return cacheStore.getPopularMovies()
  }

  override suspend fun setFavourite(id: Int) {
    cacheStore.setFavourite(id)
  }

  override suspend fun removeFavourite(id: Int) {
    cacheStore.removeFavourite(id)
  }

  override suspend fun getMovie(id: Int): Flow<Movie> {
    return cacheStore.getMovie(id)
  }

  override suspend fun getCastDetails(id: Int): List<Cast> {
    return cacheStore.getCastDetails(id)
  }

  override suspend fun saveCast(cast: List<CastResponse>) {
    cacheStore.saveCast(cast)
  }
}
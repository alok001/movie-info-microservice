package com.infinite.movieinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.movieinfoservice.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

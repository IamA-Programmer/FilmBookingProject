package com.bus.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bus.beans.MovieDetails;

@Repository
public interface MovieRepo extends CrudRepository<MovieDetails, Long> {

}

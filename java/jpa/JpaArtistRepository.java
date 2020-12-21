package com.darkside.jpa;

import com.darkside.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface JpaArtistRepository extends CrudRepository<Artist, Long> { }


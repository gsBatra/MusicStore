package com.darkside.jpa;

import com.darkside.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface JpaStoreRepository extends CrudRepository<Album, Long> {}

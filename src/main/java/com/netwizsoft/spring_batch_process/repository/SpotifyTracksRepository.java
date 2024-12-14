package com.netwizsoft.spring_batch_process.repository;

import com.netwizsoft.spring_batch_process.domain.SpotifyTracks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotifyTracksRepository extends MongoRepository<SpotifyTracks, String> {
}

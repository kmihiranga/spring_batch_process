package com.netwizsoft.spring_batch_process.configuration;

import com.netwizsoft.spring_batch_process.domain.SpotifyTracks;
import org.springframework.batch.item.ItemProcessor;

public class SpotifyTracksProcessor implements ItemProcessor<SpotifyTracks, SpotifyTracks> {

    @Override
    public SpotifyTracks process(SpotifyTracks spotifyTracks) throws Exception {
        return spotifyTracks;
    }
}

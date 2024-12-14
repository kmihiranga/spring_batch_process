package com.netwizsoft.spring_batch_process.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spotify_tracks")
@Getter
@Setter
public class SpotifyTracks {

    @Id
    private String id;

    @JsonProperty("track_id")
    private String trackId;

    @JsonProperty("track_name")
    private String trackName;

    private String year;

    private double popularity;

    @JsonProperty("artwork_url")
    private String artworkUrl;

    @JsonProperty("album_name")
    private String albumName;

    private double danceability;

    @JsonProperty("duration_ms")
    private double durationMS;

    private double energy;

    private Double instrumentalness;

    private double key;

    private double liveness;

    private double loudness;

    private double speechiness;

    private double tempo;

    @JsonProperty("time_signature")
    private double timeSignature;

    private double valence;

    @JsonProperty("track_url")
    private String trackUrl;

    private String language;
}

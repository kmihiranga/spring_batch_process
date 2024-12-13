package com.netwizsoft.spring_batch_process.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spotify_tracks")
public class SpotifyTracks {

    @JsonProperty("track_id")
    private String trackId;

    @JsonProperty("track_name")
    private String trackName;

    @JsonProperty("artist_name")
    private String artistName;

    private String year;

    private int popularity;

    @JsonProperty("artwork_url")
    private String artworkUrl;

    @JsonProperty("album_name")
    private String albumName;

    private double acousticness;

    private double danceability;

    @JsonProperty("duration_ms")
    private int durationMS;

    private double energy;

    private Double instrumentalness;

    private int key;

    private double liveness;

    private double loudness;

    private int mode;

    private double speechiness;

    private double tempo;

    @JsonProperty("time_sign")
    private int timeSign;

    private double valence;

    @JsonProperty("track_url")
    private String trackUrl;

    private String language;
}

package com.netwizsoft.spring_batch_process.configuration;

import com.netwizsoft.spring_batch_process.domain.SpotifyTracks;
import com.netwizsoft.spring_batch_process.repository.SpotifyTracksRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig {

    private final SpotifyTracksRepository spotifyTracksRepository;

    @Bean
    public FlatFileItemReader<SpotifyTracks> reader() {
        return new FlatFileItemReaderBuilder<SpotifyTracks>()
                .name("spotifyTracksItemReader")
                .resource(new ClassPathResource("spotify_tracks.csv"))
                .linesToSkip(1)
                .lineMapper(lineMapper())
                .targetType(SpotifyTracks.class)
                .build();
    }

    private LineMapper<SpotifyTracks> lineMapper() {
        DefaultLineMapper<SpotifyTracks> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("track_id", "track_name", "year", "popularity",
                "artwork_url", "album_name", "danceability", "duration_ms", "energy",
                "instrumentalness", "key", "liveness", "loudness", "speechiness", "tempo",
                "time_signature", "valence", "track_url", "language");

        BeanWrapperFieldSetMapper<SpotifyTracks> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(SpotifyTracks.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    SpotifyTracksProcessor processor() {
        return new SpotifyTracksProcessor();
    }

    @Bean
    RepositoryItemWriter<SpotifyTracks> writer() {
        RepositoryItemWriter<SpotifyTracks> writer = new RepositoryItemWriter<>();
        writer.setRepository(spotifyTracksRepository);
        writer.setMethodName("save");

        return writer;
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("importSpotifyTracks", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("csv-import-step", jobRepository)
                .<SpotifyTracks, SpotifyTracks>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}

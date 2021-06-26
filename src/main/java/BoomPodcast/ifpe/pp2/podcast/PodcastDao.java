package BoomPodcast.ifpe.pp2.podcast;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastDao extends JpaRepository<Podcast, Integer> {

}

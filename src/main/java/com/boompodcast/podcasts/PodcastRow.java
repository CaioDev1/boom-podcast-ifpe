package com.boompodcast.podcasts;

import java.util.List;

import com.boompodcast.episodios.ProjectPodcast;

//Classe "PodcastRow" que tem a função de lista de podcast por categoria.
public class PodcastRow {
	private String rowTitle;
	private List<ProjectPodcast> podcasts;
	
	public PodcastRow(String rowTitle, List<ProjectPodcast> podcasts) {
		this.rowTitle = rowTitle;
		this.podcasts = podcasts;
	}
	
	public String getRowTitle() {
		return rowTitle;
	}
	public void setRowTitle(String rowTitle) {
		this.rowTitle = rowTitle;
	}
	public List<ProjectPodcast> getPodcasts() {
		return podcasts;
	}
	public void setPodcasts(List<ProjectPodcast> podcasts) {
		this.podcasts = podcasts;
	}
}

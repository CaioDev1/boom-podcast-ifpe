package com.boompodcast.episodios;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.boompodcast.podcasts.Podcasts;

@Entity
public class Episodes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@CreationTimestamp
	private Date created_at; // OFFSETDATETIME TROCADO POR DATE E COLOCADO @CREATIONTIMESTAMP
	private Integer duration;
    @ManyToOne
    @JoinColumn(name = "podcast_id", nullable = false)
	private Podcasts podcast;
	private String audio;
	@ColumnDefault("0")
	private Integer reactions_value;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Podcasts getPodcast() {
		return podcast;
	}


	public void setPodcast(Podcasts podcast) {
		this.podcast = podcast;
	}


	public String getAudio() {
		return audio;
	}


	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	public Integer getReactions_value() {
		return reactions_value;
	}
	
	public void setReactions_value(Integer reactions_value) {
		this.reactions_value = reactions_value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episodes other = (Episodes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
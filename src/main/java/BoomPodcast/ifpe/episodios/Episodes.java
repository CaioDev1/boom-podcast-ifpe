@Entity
public class Episodes implements Serializable{
	LocalDate localDate = LocalDate.now();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private OffsetDateTime created_at;
	private Integer duration;
    @ManyToOne
	private Integer podcasts_id;
	private String file_path;
	@ManyToOne
	@JoinColumn(name = "podcasts_id")
	private Episodes episodies;


	public Episodes() {
		
	}

	public Episodes(LocalDate localDate, Integer id, String title, OffsetDateTime created_at, Integer duration,
			Integer podcasts_id, String file_path, Episodes episodies) {
		super();
		this.localDate = localDate;
		this.id = id;
		this.title = title;
		this.created_at = created_at;
		this.duration = duration;
		this.podcasts_id = podcasts_id;
		this.file_path = file_path;
		this.episodies = episodies;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}


	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}


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


	public OffsetDateTime getCreated_at() {
		return created_at;
	}


	public void setCreated_at(OffsetDateTime created_at) {
		this.created_at = created_at;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Integer getPodcasts_id() {
		return podcasts_id;
	}


	public void setPodcasts_id(Integer podcasts_id) {
		this.podcasts_id = podcasts_id;
	}


	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}


	public Episodes getEpisodies() {
		return episodies;
	}


	public void setEpisodies(Episodes episodies) {
		this.episodies = episodies;
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
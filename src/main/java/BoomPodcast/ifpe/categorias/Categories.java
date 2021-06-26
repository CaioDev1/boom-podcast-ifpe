@Entity
public class Categories implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int number_podcasts;
	private int total_views;

	public Categories() {
	}

	public Categories(Integer id, String name, int number_podcasts, int total_views, List<Podcasts> podcasts) {
		super();
		this.id = id;
		this.name = name;
		this.number_podcasts = number_podcasts;
		this.total_views = total_views;
		this.podcasts = podcasts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_podcasts() {
		return number_podcasts;
	}

	public void setNumber_podcasts(int number_podcasts) {
		this.number_podcasts = number_podcasts;
	}

	public int getTotal_views() {
		return total_views;
	}

	public void setTotal_views(int total_views) {
		this.total_views = total_views;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
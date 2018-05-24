package pharmdisplay.domain.jpa;

import java.time.Instant;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", initialValue = 100)
	@GeneratedValue(generator = "customer_generator")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private Instant lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}

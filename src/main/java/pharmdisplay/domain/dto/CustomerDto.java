package pharmdisplay.domain.dto;

import java.io.Serializable;

import pharmdisplay.domain.jpa.Customer;

public class CustomerDto implements Serializable {

	private Long id;
	private String name;
	private String status;

	public CustomerDto () {}

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.status = customer.getStatus();
	}

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
}

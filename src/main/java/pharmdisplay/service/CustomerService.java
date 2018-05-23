package pharmdisplay.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pharmdisplay.domain.dto.CustomerDto;

public interface CustomerService {
	@Transactional
	void saveCustomer(CustomerDto customerDto);

	@Transactional
	void deleteCustomer(Long id);

	List<CustomerDto> findAllCustomers();

	List<CustomerDto> findAllByStatus(String status);
}

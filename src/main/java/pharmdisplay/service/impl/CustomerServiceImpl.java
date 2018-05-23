package pharmdisplay.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pharmdisplay.domain.dto.CustomerDto;
import pharmdisplay.domain.jpa.Customer;
import pharmdisplay.repository.CustomerRepository;
import pharmdisplay.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public void saveCustomer(CustomerDto customerDto) {
		boolean createNew = false;
		if(customerDto.getId() != null) {
			Optional<Customer> customerOptional = customerRepository.findById(customerDto.getId());

			if(customerOptional.isPresent()) {
				Customer customer = customerOptional.get();

				customer.setName(customerDto.getName());
				customer.setStatus(customerDto.getStatus());

				customerRepository.save(customer);
			} else {
				createNew = true;
			}
		} else {
			createNew = true;
		}

		if(createNew) {
			Customer customer = new Customer();

			customer.setName(customerDto.getName());
			customer.setStatus(customerDto.getStatus());

			customerRepository.save(customer);
		}
	}

	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public List<CustomerDto> findAllCustomers() {
		return customerRepository.findAll().stream().map(customer -> new CustomerDto(customer)).collect(Collectors.toList());
	}

	@Override
	public List<CustomerDto> findAllByStatus(String status) {
		return customerRepository.findByStatus(status).stream().map(customer -> new CustomerDto(customer)).collect(Collectors.toList());
	}

}

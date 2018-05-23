package pharmdisplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pharmdisplay.domain.dto.CustomerDto;
import pharmdisplay.service.CustomerService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String getMainPage() {
		return "index.html";
	}

	@GetMapping("/admin")
	public String getAdminPage() {
		return "admin.html";
	}

	@GetMapping("/find/all")
	@ResponseBody
	public List<CustomerDto> getAllCustomers() {
		return customerService.findAllCustomers();
	}

	@GetMapping("/find/{status}")
	@ResponseBody
	public List<CustomerDto> getCustomersByStatus(@PathVariable("status") String status) {
		return customerService.findAllByStatus(status);
	}

	@GetMapping("/delete/{id}")
	@ResponseBody
	public boolean deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return true;
	}

	@PostMapping("/save")
	@ResponseBody
	public boolean saveCustomer(@RequestBody CustomerDto customerDto) {
		customerService.saveCustomer(customerDto);
		return true;
	}
}

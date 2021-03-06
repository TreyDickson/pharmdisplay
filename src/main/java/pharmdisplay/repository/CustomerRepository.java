package pharmdisplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pharmdisplay.domain.jpa.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findAllByOrderByLastUpdateDesc();

	List<Customer> findByStatusOrderByLastUpdateDesc(String status);
}

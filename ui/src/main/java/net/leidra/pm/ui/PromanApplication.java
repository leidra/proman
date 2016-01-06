package net.leidra.pm.ui;

import net.leidra.pm.core.CoreConfiguration;
import net.leidra.pm.core.ServicesConfiguration;
import net.leidra.pm.core.entities.Customer;
import net.leidra.pm.core.repositories.CustomerRepository;
import net.leidra.pm.core.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {CoreConfiguration.class, ServicesConfiguration.class, SecurityConfiguration.class})
@SpringBootApplication
public class PromanApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(PromanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setName("leidra");
        customerRepository.save(customer);
    }
}

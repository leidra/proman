package net.leidra.pm.ui;

import com.google.common.eventbus.EventBus;
import net.leidra.pm.core.CoreConfiguration;
import net.leidra.pm.core.ServicesConfiguration;
import net.leidra.pm.core.entities.Product;
import net.leidra.pm.core.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(value = {CoreConfiguration.class, ServicesConfiguration.class, SecurityConfiguration.class})
@SpringBootApplication
public class PromanApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(PromanApplication.class, args);
    }

    public void run(String... args) {
        Product p = new Product();
        p.setId(1l);
        p.setName("product");

        productRepository.save(p);
    }

    @Bean
    public EventBus createEventBus() {
        return new EventBus();
    }
}

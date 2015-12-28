package net.leidra.pm.core;

import net.leidra.pm.core.entities.EntitiesPackageProvider;
import net.leidra.pm.core.repositories.RepositoriesPackageProvider;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = EntitiesPackageProvider.class)
@EnableJpaRepositories(basePackageClasses = RepositoriesPackageProvider.class)
public class CoreConfiguration {
}

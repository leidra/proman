package net.leidra.pm.core;

import net.leidra.pm.core.services.ServicesPackageProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServicesPackageProvider.class)
public class ServicesConfiguration {
}

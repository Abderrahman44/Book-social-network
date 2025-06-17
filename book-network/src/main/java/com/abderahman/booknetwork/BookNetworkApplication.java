package com.abderahman.booknetwork;

import com.abderahman.booknetwork.email.EmailService;
import com.abderahman.booknetwork.role.Role;
import com.abderahman.booknetwork.role.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BookNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookNetworkApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(RoleRepo roleRepo) {
        return args -> {
            if (roleRepo.findByName("USER").isEmpty()) {
                var userRole = Role.builder().name("USER").build();
                roleRepo.save(userRole);
                System.out.println("USER role initialized successfully");
            } else {
                System.out.println("USER role already exists");
            }
        };
    }

}

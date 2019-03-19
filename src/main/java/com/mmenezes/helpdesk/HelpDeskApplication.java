package com.mmenezes.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mmenezes.helpdesk.api.entity.User;
import com.mmenezes.helpdesk.api.enums.ProfileEnum;
import com.mmenezes.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}
	
	
	//chamando o método de criar um usuario no banco (initUsers)
	@Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(userRepository, passwordEncoder);
        };

    }
	
	
	//inserindo um usuario no banco ao subir a aplicacao para testar o login
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User admin = new User();
        admin.setEmail("admin@helpdesk.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setProfile(ProfileEnum.ROLE_ADMIN);

        User find = userRepository.findByEmail("admin@helpdesk.com");
        if (find == null) {
            userRepository.save(admin);
        }
	}

}

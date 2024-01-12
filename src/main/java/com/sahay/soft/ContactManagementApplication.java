package com.sahay.soft;

import com.sahay.soft.entity.Role;
import com.sahay.soft.entity.User;
import com.sahay.soft.repository.RoleRepository;
import com.sahay.soft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ContactManagementApplication implements CommandLineRunner {
	@Autowired
    RoleRepository roleRepository;
	public static void main(String[] args) {

		SpringApplication.run(ContactManagementApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		Role role1=new Role("Normal","Normal user");
		Role role2=new Role("Admin","Administrator");
		if(! roleRepository.existsByRole(role1.getRole())){
			roleRepository.save(role1);
		}
		if(! roleRepository.existsByRole(role2.getRole())){
			roleRepository.save(role2);
		}



	}
}

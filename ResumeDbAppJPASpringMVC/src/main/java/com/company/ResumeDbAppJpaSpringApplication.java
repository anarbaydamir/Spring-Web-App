package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

	@Autowired //Bu springden gelen annotationdu, vezifesi bu interface'i istifade eden classi tapib buna inject etmek; loosely coupling
	@Qualifier("userDao1") //eger bu interfacei implement eden 2 class olarsa conflictin qarshisini almaq uchun qualifier istifade olunur.
	private UserRepositoryCustom userDaoInter;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

	@Bean //Biri var classin ustune Component annotationu yazirsan ki bunun obyektini Spring ozu yaratsin, biri de var Bean yazib classin obyektini ozun yaradirsan.
	//yeni bu o demekdi ki app yarananda bu obyekti yarat.
	public CommandLineRunner run() {
		CommandLineRunner commandLineRunner = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
//				List<User> userList = userRepository.findAll();
//
//				System.out.println(userList);
//				System.out.println("---------------");
//				userList = userRepository.findAll(Sort.by(Sort.Order.desc("id")));  //sort olunmush formasi
//
//				System.out.println(userList);

//				User u	= userRepository.findByName("Misha");
//				System.out.println(u);
//				u = userRepository.findByNameAndSurname("Misha","Atakishiyev");
//				System.out.println(u);
//
//				u = userRepository.findByEmail("misha@gmail.com");
//				System.out.println(u);

				List<User> userList = userRepository.getAll(null,null,null);
				System.out.println(userList);
			}
		};
		return commandLineRunner;
	}

}

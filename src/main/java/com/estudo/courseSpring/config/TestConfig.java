package com.estudo.courseSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.courseSpring.entities.Category;
import com.estudo.courseSpring.entities.Order;
import com.estudo.courseSpring.entities.User;
import com.estudo.courseSpring.entities.enums.OrderStatus;
import com.estudo.courseSpring.repositories.CategoryRepository;
import com.estudo.courseSpring.repositories.OrderRepository;
import com.estudo.courseSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(5L, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(6L, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(8L, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
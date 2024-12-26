package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.member.MemberQueryService;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "umc.spring.domain") // 엔티티 스캔 추가
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
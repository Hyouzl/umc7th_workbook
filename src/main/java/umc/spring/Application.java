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
	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			MemberQueryService memberQueryServiceQueryService = context.getBean(MemberQueryService.class);

			// 파라미터 값 설정
			Long memberId = 1L;


			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");



			memberQueryServiceQueryService.findMemberInMyPage(memberId);

		};
	}
}
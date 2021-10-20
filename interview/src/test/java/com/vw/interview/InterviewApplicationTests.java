package com.vw.interview;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vw.interview.model.Unicorn;
import com.vw.interview.repo.UnicornRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InterviewApplicationTests {

	@Autowired
    private UnicornRepository unicornRepository;

	@Test
	public void testCreateUnicorn() throws Exception {
		Unicorn unicorn = new Unicorn("test_name", 
				"test_hairColor", 
				1, 
				"test_hornColor", 
				"test_eyeColor", 
				1,
				"test_heightUnit", 
				1, 
				"test_weightUnit",
				new ArrayList<>());
		Unicorn savedUnicorn = unicornRepository.save(unicorn);
		assertThat(savedUnicorn.getUnicornId()).isEqualTo(1);
		assertThat(savedUnicorn.getName()).isEqualTo("test_name");
		
		List<Unicorn> retrievedUnicorn = unicornRepository.findAll();
		assertThat(retrievedUnicorn.size()).isEqualTo(1);
		assertThat(retrievedUnicorn.get(0).getName()).isEqualTo("test_name");
	}
}

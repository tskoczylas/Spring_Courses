package com.tomjava.kurs.spirng;

import com.tomjava.kurs.spirng.domain.repository.InMemoryRepository;
import com.tomjava.kurs.spirng.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KursSpirngApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
    InMemoryRepository inMemoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCastle(){
		String expect = "Znajduje się tu zamek o nazwie:BLACk watch zamieszkały przez rycerza  + Rycerz: Lancleot wiek: 22 Zadanie:uratuj księżniczke";
		assertEquals(expect, inMemoryRepository.toString());

	}

}

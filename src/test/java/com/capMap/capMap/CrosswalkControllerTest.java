package com.capMap.capMap;

import com.capMap.capMap.domain.cross;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrosswalkControllerTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void testFetchDataFromCrossTable() {
		try {
			// crossLoc 테이블에서 모든 데이터를 가져오는 쿼리 실행
			List<cross> data = jdbcTemplate.query("SELECT * FROM `cross`", (rs, rowNum) -> {
				cross cross = new cross();
				cross.setId(rs.getInt("id"));

				cross.setX(rs.getDouble("X"));
				cross.setY(rs.getDouble("Y"));
				return cross;
			});

			// 가져온 데이터 출력
			System.out.println("Data from 'cross' table:");
			for (com.capMap.capMap.domain.cross cross : data) {
				System.out.println("ID: " + cross.getId() + ", X: " + cross.getX() + ", Y: " + cross.getY());
			}

			// 데이터가 정상적으로 가져와졌다면 테스트를 성공시킵니다.
			assertTrue(true);
		} catch (Exception e) {
			// 데이터를 가져오는 도중에 예외가 발생하면 테스트를 실패시킵니다.
			assertTrue(false, "데이터 가져오기 실패: " + e.getMessage());
		}
	}
}

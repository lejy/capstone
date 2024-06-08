package com.capMap.capMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CrosswalkControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testCheckCrosswalkWithin50m() throws Exception {
		Map<String, Double> coordinates = Map.of("x", 127.1603532, "y", 36.78014649);
		String json = objectMapper.writeValueAsString(coordinates);

		mockMvc.perform(post("/api/check-crosswalk")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andExpect(content().string("1")); // Expecting 1 for within 50m
	}

	@Test
	public void testCheckCrosswalkOutside50m() throws Exception {
		Map<String, Double> coordinates = Map.of("x", 127.00000, "y", 36.00000);
		String json = objectMapper.writeValueAsString(coordinates);

		mockMvc.perform(post("/api.check-crosswalk")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isOk())
				.andExpect(content().string("0")); // Expecting 0 for outside 50m
	}
}

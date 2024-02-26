package com.jeux.schottentotten;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeux.schottentotten.adaptateur.PartieDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class SchottentottenApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	void demarrer_nouvelle_partie() throws Exception{
		mvc.perform(post("/demarrerPartie"))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").exists());
	}

	@Test
	void rejoindre_partie() throws Exception {
		String partieString = mvc.perform(post("/demarrerPartie"))
				.andReturn().getResponse().getContentAsString();
		PartieDTO partie = new ObjectMapper().readValue(partieString, PartieDTO.class);

		mvc.perform(put("/rejoindrePartie/" + partie.id())
			.queryParam("joueur", "Alban"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.main").isArray())
			.andExpect(jsonPath("$.main", hasSize(6)))
			.andDo(print());
	}

}

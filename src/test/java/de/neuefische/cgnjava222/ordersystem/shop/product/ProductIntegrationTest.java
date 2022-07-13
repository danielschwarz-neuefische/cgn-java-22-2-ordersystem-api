package de.neuefische.cgnjava222.ordersystem.shop.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getOneProduct() throws Exception {
        // given
        mockMvc

                // when
                .perform(
                        get("/api/products/3")
                )

                // then
                .andExpect(status().is(200))
                .andExpect(content().json("""
                        {
                            "id": 3,
                            "name": "Zitrone"
                        }
                        """));
    }
}

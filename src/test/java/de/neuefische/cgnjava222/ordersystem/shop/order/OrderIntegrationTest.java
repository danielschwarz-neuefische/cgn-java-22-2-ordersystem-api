package de.neuefische.cgnjava222.ordersystem.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @DirtiesContext
    @Test
    void getOneProduct() throws Exception {
        mockMvc
                .perform(
                        post("/api/orders/987")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        [1,2]
                                        """)
                )
                .andExpect(status().is(200))
                .andExpect(content().string(""));
        mockMvc
                .perform(
                        get("/api/orders/987")
                )
                .andExpect(status().is(200))
                .andExpect(content().json("""
                        {"id":987,"products":[{"id":1,"name":"Apfel"},{"id":2,"name":"Banane"}]}
                        """));
    }
}

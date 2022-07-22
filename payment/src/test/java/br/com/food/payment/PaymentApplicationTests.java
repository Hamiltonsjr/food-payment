package br.com.food.payment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PaymentApplicationTests {

    @Test
    void contextLoads() {
        final String txt = "TESTE";
        assertEquals("TESTE", txt);
    }
}

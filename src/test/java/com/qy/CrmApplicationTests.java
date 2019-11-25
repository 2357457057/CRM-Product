package com.qy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CrmApplicationTests {

    @Test
    void contextLoads() {


        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

}

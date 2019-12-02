package com.qy;

import com.qy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CrmApplicationTests {


    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {


        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }



    @Test
    void contextLoads2() {
            userService.user_show1("ab07416d-a153-11e9-b4b3-74d02bd4fd82");
    }

}

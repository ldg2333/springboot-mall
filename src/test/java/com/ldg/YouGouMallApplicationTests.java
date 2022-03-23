package com.ldg;

import com.ldg.entity.*;
import com.ldg.service.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class YouGouMallApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {

        List<Map<String, Object>> maps = productService.selectAllByType();
        System.out.println(maps);

    }
}

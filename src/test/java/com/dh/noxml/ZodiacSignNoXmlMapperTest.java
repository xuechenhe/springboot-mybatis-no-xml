package com.dh.noxml;

import com.dh.StartApplication;
import com.dh.entity.ZodiacSign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class ZodiacSignNoXmlMapperTest {
    @Autowired
    private ZodiacSignNoXmlMapper zodiacSignMapper;
    @Test
    public void test_list(){
        List<ZodiacSign> list = zodiacSignMapper.list();
        System.err.println(list);
    }

    @Test
    public void test_selectParam() {
        List<ZodiacSign> zodiacSigns = zodiacSignMapper.selectByParam("牛");
        System.err.println(zodiacSigns);
    }

    @Test
    public void test_selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("zodiacName","鼠");
        map.put("ranking","1");
        List<ZodiacSign> zodiacSigns = zodiacSignMapper.selectByMap(map);
        System.err.println(zodiacSigns);
    }
}

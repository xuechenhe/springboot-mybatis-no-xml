package com.dh.mapper;

import com.dh.StartApplication;
import com.dh.entity.ZodiacSign;
import com.dh.entity.ZodiacSignExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class ZodiacSignMapperTest {
    @Autowired
    private ZodiacSignMapper zodiacSignMapper;

    @Test

    public void countByExample() {
        long l = zodiacSignMapper.countByExample(null);
        System.err.println(l);
    }

    @Test
    public void test_selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("zodiacName","鼠");
        List<ZodiacSign> zodiacSigns = zodiacSignMapper.selectByMap(map);
        System.err.println(zodiacSigns);
    }

    @Test
    public void test_selectByExample() {
        ZodiacSignExample example = new ZodiacSignExample();
        example.createCriteria().andZodiacNameEqualTo("鼠");
        List<ZodiacSign> zodiacSigns = zodiacSignMapper.selectByExample(example);
        System.err.println(zodiacSigns);
    }
}
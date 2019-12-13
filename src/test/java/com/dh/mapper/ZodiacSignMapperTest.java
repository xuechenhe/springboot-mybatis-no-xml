package com.dh.mapper;

import com.dh.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
}
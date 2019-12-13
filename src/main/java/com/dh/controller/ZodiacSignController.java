package com.dh.controller;

import com.dh.mapper.ZodiacSignMapper;
import com.dh.noxml.ZodiacSignNoXmlMapper;
import com.dh.result.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/zodiac/sign")
public class ZodiacSignController {

    @Autowired
    private ZodiacSignNoXmlMapper zodiacSignNoXmlMapper;
    @Autowired
    private ZodiacSignMapper zodiacSignMapper;

    @RequestMapping("/json")
    public ResultJson getList(){

        return new ResultJson(true,200,"",zodiacSignNoXmlMapper.list());
    }

    @RequestMapping("/param")
    public ResultJson getListByParam(@RequestBody Map<String,Object> map) {

        return new ResultJson(true, 200, "", zodiacSignMapper.selectByMap(map));
    }
}

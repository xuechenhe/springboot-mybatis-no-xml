package com.dh.controller;

import com.dh.annotation.EnhanceAnnotation;
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

    /**
     * GET http://localhost:8080/api/zodiac/sign/json
     * @return
     */
    @RequestMapping("/json")
    public ResultJson getList(){

        return new ResultJson(true,200,"",zodiacSignNoXmlMapper.list());
    }

    /**
     * POST http://localhost:8080/api/zodiac/sign/param
     * Content-Type: application/json
     *
     * {"zodiacName":"鼠"}
     * @param map
     * @return
     */
    @RequestMapping("/param")
    public ResultJson getListByParam(@RequestBody Map<String,Object> map) {

        return new ResultJson(true, 200, "", zodiacSignMapper.selectByMap(map));
    }
    @EnhanceAnnotation
    @RequestMapping("/aop/enhance")
    public ResultJson enhance(String zodiacName){
        return new ResultJson(true, 200, "", zodiacName);
    }
}

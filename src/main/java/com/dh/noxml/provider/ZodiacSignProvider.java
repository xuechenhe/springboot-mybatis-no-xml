package com.dh.noxml.provider;

import com.alibaba.druid.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author Administrator
 */
public class ZodiacSignProvider {
    /**
     * 根据条件动态拼接语句
     *
     * @param map
     * @return SQL字符串
     */
    public String selectByMap(Map<String, Object> map) {
        String zodiacName = (String) map.get("zodiacName");
        String ranking = (String) map.get("ranking");
        return new SQL() {{
            SELECT("*");
            FROM("zodiac_sign");
            if (!StringUtils.isEmpty(zodiacName)) {
                WHERE("zodiac_name = '" + zodiacName + "'");
            }
            if (!StringUtils.isEmpty(ranking) && StringUtils.isNumber(ranking)) {
                WHERE("ranking = " + Integer.parseInt(ranking));
            }
        }}.toString();
    }
}

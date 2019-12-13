package com.dh.noxml;

import com.dh.entity.ZodiacSign;
import com.dh.noxml.provider.ZodiacSignProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface ZodiacSignNoXmlMapper {
    /**
     * map-underscore-to-camel-case: true  zodiacName属性自动 映射
     * 相当于 @Results({
     *
     * @return
     * @Result(property = "zodiacName",column = "zodiac_name")
     * })
     */
    @Results({
            @Result(property = "name", column = "name")
    })
    @Select("select * from zodiac_sign")
    List<ZodiacSign> list();

    /**
     * 根据参数查询生肖集合
     *
     * @param zodiacName
     * @return List<ZodiacSign>
     */
    @Select({"<script>",
            "select * from zodiac_sign where zodiac_name= #{zodiacName}",
            "</script>"})
    List<ZodiacSign> selectByParam(String zodiacName);

    /**
     * 根据map查询生肖集合
     *
     * @param map
     * @return List<ZodiacSign>
     */
    @SelectProvider(type = ZodiacSignProvider.class, method = "selectByMap")
    List<ZodiacSign> selectByMap(Map<String, Object> map);
}

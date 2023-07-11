package com.example.Alpha.Dao;

import com.example.Alpha.Bean.ArticalBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticalDao {

    @Select("select * from artical")
    public List<ArticalBean> getAllArtical();


    @Insert("insert into artical(artical_title,artical_htmlTag,artical_time,artical_kindOf,artical_lastChangeTime,artical_kindOfTag,artical_markdownCode) values (#{artical_title},#{artical_htmlTag},#{artical_time},#{artical_kindOf},#{artical_lastChangeTime},#{artical_kindOfTag},#{artical_markdownCode})")
    public Integer articaUpload(ArticalBean articalBean);


    @Delete("delete from artical where id=#{id}")
    public Integer delateArticalById(Integer id);


    @Select("select * from artical where id=#{id}")
    public ArticalBean getArticalById(Integer id);


    @Select("select * from artical where artical_kindOf=#{str}")
    public List<ArticalBean> getArticalByKindOf(String str);


    @Update("update artical set artical_htmlTag=#{artical_htmlTag},artical_title=#{artical_title},artical_kindOf=#{artical_kindOf},artical_lastChangeTime=#{artical_lastChangeTime},artical_kindOfTag=#{artical_kindOfTag},artical_markdownCode=#{artical_markdownCode} where id=#{id}")
    public Integer changeArtical(ArticalBean articalBean);


    @Select("SELECT categories.category_name, COUNT(artical.id) AS num_articles FROM (SELECT '前端' AS category_name UNION SELECT '后端' UNION SELECT 'SQL' UNION SELECT '操作系统' UNION SELECT '移动端应用' UNION SELECT '开发工具') AS categories LEFT JOIN artical ON categories.category_name = artical.artical_kindOf WHERE categories.category_name IN ('前端', '后端', 'SQL', '操作系统', '移动端应用', '开发工具') GROUP BY categories.category_name ORDER BY categories.category_name;")
    public List<Map<String,Object>> checkArticalQuantity();

    @Select("SELECT artical_kindOfTag, COUNT(*) FROM artical GROUP BY artical_kindOfTag")
    public List<Map<String,Object>> checkArticalTag();


    @Select("SELECT artical_kindOf, COUNT(*) AS count FROM artical GROUP BY artical_kindOf;")
    public List<Map<String,String>> getArticalKindOfInfo();


}

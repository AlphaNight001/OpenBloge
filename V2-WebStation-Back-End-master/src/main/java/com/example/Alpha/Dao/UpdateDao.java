package com.example.Alpha.Dao;

import com.example.Alpha.Bean.UpdateBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UpdateDao {

    @Insert("INSERT INTO updatego(html_Tag, update_Time,markdown_Code) VALUES(#{html_Tag}, #{update_Time},#{markdown_Code})")
    public Integer updateGo(UpdateBean updateBean);


    @Select("select * from updatego")
    public List<UpdateBean> selectAllUpdate();

    @Delete("DELETE FROM updatego WHERE id = #{id}")
    public Integer delateUpdateByID(Integer id);


    @Select("select * from updatego where id=#{id}")
    public UpdateBean queryUpdateByID(Integer id);

    @Update("update updatego set markdown_Code=#{markdown_Code},html_Tag=#{html_Tag},update_Time=#{update_Time} where id=#{id}")
    public Integer changeUpdateByID(UpdateBean updateBean);

}

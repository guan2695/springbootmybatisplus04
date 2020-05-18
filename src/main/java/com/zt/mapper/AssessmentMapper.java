package com.zt.mapper;

import com.zt.entity.Assessment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @create 2020-05-14 9:25
 */
@Mapper
public interface AssessmentMapper {
    /**
     * 查询所有申请卖车表
     * @return
     */
    @Select("SELECT * FROM assessment")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "adminid",property = "admin",one = @One(select = "com.zt.mapper.AdminMapper.getOneAdminByid")),
            @Result(column = "cid",property = "car",one = @One(select = "com.zt.mapper.CarMapper.GetOneCarAllInfo"))
    })
    public List<Assessment> getAllAssessmet();

    /**
     * 管理员审核，更改审核表状态
     * @param assstate
     * @param aid
     * @return
     */
    @Update("UPDATE assessment SET assstate=#{assstate} WHERE aid=#{aid}")
    public int updAssessState(@Param("assstate") int assstate,@Param("aid") int aid);

    /**
     * 增加审核失败原因
     * @param aid
     * @param because
     * @return
     */
    @Insert("INSERT INTO assessover VALUES(DEFAULT,#{aid},#{because})")
    public int addAssessOver(@Param("aid") int aid,@Param("because") String because);

    /**
     * 查询该用户的车辆审核情况
     */
    @Select("SELECT * FROM assessment WHERE uid=#{uid}")
    @Results({
            @Result(column = "uid",property = "user",one = @One(select = "com.zt.mapper.UsersMapper.getOneUserById")),
            @Result(column = "adminid",property = "admin",one = @One(select = "com.zt.mapper.AdminMapper.getOneAdminByid")),
            @Result(column = "cid",property = "car",one = @One(select = "com.zt.mapper.CarMapper.GetOneCarAllInfo"))
    })
    public List<Assessment> selectUserAssessment(Assessment assessment);
}

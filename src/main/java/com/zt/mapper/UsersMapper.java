package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.History;
import com.zt.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guan
 * @create 2020-04-26 11:35
 */
@Mapper
public interface UsersMapper extends BaseMapper<User> {
    /**
     * 用户登录
     * @param user
     * @return
     */
    public User selectlogin(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectall();

    @Select("SELECT * FROM USER LIMIT #{pageIndex},#{pageSize}")
    public List<User> selectUserByPage(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    /**
     * 用户注册
     */
    public int userregister(User user);

    /**
     * 根据用户id得到一个用户
     * @param uid
     * @return
     */
    @Select("SELECT * FROM USER WHERE uid=#{uid}")
    public User getOneUserById(int uid);

    /**
     * 查询用户的浏览记录
     * @param uid
     * @return
     */
    @Select("SELECT * FROM history WHERE uid=#{uid}")
    @Results({
            @Result(column = "cid",property = "car",one = @One(select = "com.zt.mapper"))
    })
    public List<History> getAllHistoryByUser(int uid);

    /**
     * 删除用户的浏览记录
     * @param uid
     * @return
     */
    @Delete("DELETE FROM history WHERE uid=#{uid}")
    public int delHistoryByUser(int uid);
    /**
     * 修改用户密码
     */
    @Update("UPDATE USER SET upwd=#{upwd} WHERE uid =#{uid}")
    public int updateUserpwd(User user);

    /**
     * 删除用户
     * @param uid
     * @return
     */
    @Delete("DELETE FROM USER WHERE uid=#{uid}")
    public int delUserByid(int uid);
    /**
     * 修改
     */
   public int updateuser(User user);
}

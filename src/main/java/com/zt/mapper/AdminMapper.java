package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @author guan
 * @create 2020-05-07 17:45
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Admin adminlogin(Admin admin);

    /**
     * 根据管理员id得到一个管理员
     * @param adminid
     * @return
     */
    @Select("SELECT * FROM admin WHERE adminid=#{adminid}")
    public Admin getOneAdminByid(int adminid);

    /**
     * 贷款车成功管理员增加用户余额
     * @param uid
     * @param money
     * @return
     */
    @Update("UPDATE USER SET money=money+#{money} WHERE uid=#{uid}")
    public int adminAddMoneyToUser(@Param("uid") int uid,@Param("money") double money);
}

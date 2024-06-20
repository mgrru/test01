package com.mgrru.test01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mgrru.test01.model.User;

@Mapper
public interface IUser {
    @Select("select user.*,skill.name as skill from user left join skill on user.id=skill.uid")
    @ResultMap(value = "User")
    List<User> getAllUser();

    @Select("select user.*,skill.name as skill from user left join skill on user.id=skill.uid where user.id=#{id}")
    @Results(id = "User", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "skill", many = @Many(resultMap = "skill"))
    })
    User getUserById(Integer id);

    @Select("select name from skill")
    @Results(id = "skill", value = {
            @Result(column = "skill")
    })
    List<String> skill(Integer id);

    @Select("select name from skill where uid=#{id}")
    List<String> getSkill(Integer id);

    @Insert("insert into user(name,sex) values(#{name},#{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUser(User user);

    @Insert("insert into skill(name,uid) values(#{skill},#{user.id})")
    int addSkill(User user, String skill);

    @Update("update user set name=#{name}, sex=#{sex} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(Integer id);

    @Delete("delete from skill where name=#{skill} and uid=#{user.id}")
    int deleteSkill(User user, String skill);
}

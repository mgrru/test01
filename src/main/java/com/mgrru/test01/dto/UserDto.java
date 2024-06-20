package com.mgrru.test01.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mgrru.test01.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {
    String name;
    String sex;
    List<String> skill;

    public UserDto(User user){
        this.name = user.getName();
        this.sex = user.getSex();
        this.skill = user.getSkill();
    }

    public void setFromUser(User user){
        this.name = user.getName();
        this.sex = user.getSex();
        this.skill = user.getSkill();
    }

    public User toUser(){
        return new User(null, name, sex, skill);
    }


}

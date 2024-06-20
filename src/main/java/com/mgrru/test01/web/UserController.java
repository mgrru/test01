package com.mgrru.test01.web;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgrru.test01.anno.logAnno;
import com.mgrru.test01.dao.IMLog;
import com.mgrru.test01.dto.UserDto;
import com.mgrru.test01.model.MLog;
import com.mgrru.test01.model.User;
import com.mgrru.test01.service.UserService;
import com.mgrru.test01.util.R;
import com.mgrru.test01.util.codeEnums;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private IMLog imLog;

    @GetMapping("log")
    public R<String> getMethodName()  throws JsonProcessingException{
        List<MLog> list = imLog.getLog();
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(list);
        return R.success(data);
    }
    

    @GetMapping
    public R<String> getAllUsers() throws JsonProcessingException {
        List<User> users = userService.getAllUsers();
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(users);
        return R.success(data);
    }

    @logAnno
    @PostMapping
    public R<String> addUser(@RequestBody String entity) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserDto dto = mapper.readValue(entity, UserDto.class);
        User user = dto.toUser();
        userService.addUser(user);
        return R.successMsg("添加成功");
    }

    @logAnno
    @PutMapping
    public R<String> updateUser(@RequestBody String entity) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(entity, User.class);
        userService.updateUser(user);
        return R.successMsg("更新成功");
    }

    @logAnno
    @DeleteMapping("/{id}")
    public R<String> deleteUser(@PathVariable("id") Integer id) {
        if (userService.deleteUser(id)) {
            return R.successMsg("删除成功");
        } else {
            return R.error(codeEnums.ERROR);
        }

    }
}

package com.mgrru.test01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgrru.test01.dao.IUser;
import com.mgrru.test01.model.User;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private IUser iUser;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return iUser.getAllUser();
    }

    public void addUser(User user) {
        iUser.addUser(user);
        if (user.getSkill() != null) {
            for (String skill : user.getSkill()) {
                iUser.addSkill(user, skill);
            }
        }
    }

    public void updateUser(User user) {
        iUser.updateUser(user);
        List<String> skillList = iUser.getSkill(user.getId());
        List<String> userSkillList = user.getSkill();
        if (skillList != null) {
            for (String skill : skillList) {
                iUser.deleteSkill(user, skill);
            }
        }

        if (userSkillList != null) {
            for (String skill : userSkillList) {
                iUser.addSkill(user, skill);
            }
        }

    }

    public boolean deleteUser(Integer id){
        User user = iUser.getUserById(id);
        if (user!=null) {
            List<String> skillList = user.getSkill();
            if (skillList!=null) {
                for (String skill : skillList) {
                    iUser.deleteSkill(user, skill);
                }
            }
            iUser.deleteUser(id);
            return true;
        }else{
            return false;
        }
    }
}

/*
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

*/
/*@Service*//*

public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    // loadUserByUsername() 方法将在用户登录时自动调用
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        // 如果用户不存在，抛出一个账户不存在的异常
        if(user==null){
            throw new UsernameNotFoundException("账户不存在！");
        }
        // 如果查找到用户，就继续查找该用户所具有的角色信息(硬核多表查询法)
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        // 将获取到的 user 对象返回，再由系统提供的 DaoAuthenticationProvider 类去对比密码是否正确
        return user;
    }

}
*/

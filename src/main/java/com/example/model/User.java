/*
package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 实现 UserDetails 接口，并重写7个方法
// 默认情况下不需要开发者自己进行密码角色等信息的比对，开发者只需提供相关信息即可
// 例如 getPassword() 方法返回的密码和用户输入的登录密码不匹配，会自动抛出 BadCredentialsException 异常
// 因此对开发者而言，只需要按照数据库中的数据在这里返回相应的配置即可
public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<Role> roles;

    // 获取当前用户对象所具有的角色信息
    // 在这里，用户所具有的角色存储在人 roles 属性中，因此该方法直接遍历 roles 属性，然后构造 SimpleGrantedAuthority 集合并返回。
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    // 获取当前用户对象的密码
    @Override
    public String getPassword() {
        return password;
    }

    // 获取当前用户对象的用户名
    @Override
    public String getUsername() {
        return username;
    }

    // 当前账户是否 未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 当前账户是否 未锁定
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    // 当前账户密码是否 未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 当前账户是否可用
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", roles=" + roles +
                '}';
    }
}
*/

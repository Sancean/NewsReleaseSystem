package com.news.controller;
import com.news.constants.ResponseCode;
import com.news.entity.User;
import com.news.service.UserService;
import com.news.utils.Response;
import com.news.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Sancean
 * @since 2023-05-19
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){this.userService=userService;}
    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Response<User> login(@RequestBody User user) {
        User loginUser = userService.selectByName(user);
        if (loginUser != null && Objects.equals(loginUser.getPassword(), user.getPassword())){
            return ResponseUtils.defineSuccess(ResponseCode.SUCCESS, "登陆成功！", loginUser);
        }else {
            return ResponseUtils.fail("账号或密码错误！");
        }
    }


    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Response<String> createUser(@RequestBody User user){
        // 获取请求体中的用户信息，并进行注册
        boolean success = userService.register(user);

        // 根据注册结果返回相应的响应码
        if (success) {
            return  ResponseUtils.success("注册成功!");
        } else {
            return  ResponseUtils.fail("注册失败!");
        }
    }

    /**
     * 注销用户
     */
    @DeleteMapping("/delete/{id}")
    public Response<String> deleteUser(@PathVariable Integer id) {
        boolean flag= userService.deleteUser(id);
        if (flag){
            return ResponseUtils.success("注销成功");
        }else {
            return ResponseUtils.fail("注销失败");
        }

    }
    @PutMapping
    public Response<User> updatePassword(@RequestBody User user){
        boolean flag=userService.updatePassword(user);
        if (flag){
            return ResponseUtils.success(user);
        }else {
            return ResponseUtils.fail("密码修改失败");
        }
    }
    @PostMapping("/setAdmin")
    public Response<User> setAdmin(@RequestBody User user){
        boolean flag=userService.setAdmin(user);
        if (flag){
            return ResponseUtils.success(user);
        }else {
            return ResponseUtils.fail("管理员设置失败");
        }
    }
    //查看所有成员信息
    @PostMapping("/lookAllUser")
    public Response<List<User>> lookAllUser(){
        List<User> list=userService.selectAllUsers();
        if (!list.isEmpty()){
            return ResponseUtils.success(list);
        }else {
            return ResponseUtils.fail("查询失败");
        }
    }
}

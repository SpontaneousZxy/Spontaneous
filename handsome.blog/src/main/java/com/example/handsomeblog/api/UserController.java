package com.example.handsomeblog.api;

import com.example.handsomeblog.biz.user.IUserService;
import com.example.handsomeblog.common.AbstractController;
import com.example.handsomeblog.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户服务")
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController extends AbstractController {

    @Autowired
    private IUserService userService;


    protected UserController(IUserService userService) {
        super(userService);
    }


    /**
     * 获取所有用户信息
     *
     * @return
     */
    @GetMapping("/getAllUserList")
    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET", notes = "获取所有用户信息")
    public ResponseResult getAllUserList(){
        return new ResponseResult().data(userService.getAllUser());
    }
}

package com.example.handsomeblog.biz.user;

import com.example.handsomeblog.common.inner.ICommonService;
import com.example.handsomeblog.dal.user.UserDo;

import java.util.List;

public interface IUserService extends ICommonService<UserDo, UserDo> {

    /**
     * 获取所有的用户信息
     * @return
     */
    List<UserDo> getAllUser();
}

package com.example.handsomeblog.dal.user;

import com.example.handsomeblog.common.inner.IAddMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends IAddMapper<UserDo> {
    /**
     * 获取所有的用户信息
     * @return
     */
    List<UserDo> getAllUser();
}

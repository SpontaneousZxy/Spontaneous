package com.example.handsomeblog.dal.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserDo {

    @ApiModelProperty(value = "用户id", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "用户名", dataType = "String")
    private String userName;
    @ApiModelProperty(value = "密码", dataType = "String")
    private String password;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间", dataType = "LocalDateTime")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间", dataType = "LocalDateTime")
    private LocalDateTime updateTime;

}

package com.luo.utils;

public interface SystemConstant {

    /**
     * 密码加密次数
     */
    Integer PASSWORD_COUNT = 5;

    /**
     * 后台登录人，保持到Session中的key
     */
    String LOGINUSER = "loginUser";

    /**
     * map中的key,判断登录是否成功，返回true或false
     */
    String SUCCESS = "success";

    /**
     * 判断登录是否成功，然后提示信息，map中的key
     */
    String MESSAGE = "message";

    /**
     * 判断员工是否存在
     */
    String EXIST = "exist";

    /**
     * 默认登录密码
     */
    String DEFAULT_LOGIN_PWD = "123456";

}




package com.sky.context;

import com.sky.constant.MessageConstant;
import com.sky.exception.UserNotLoginException;

public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        if (threadLocal.get() == null){
            throw new UserNotLoginException(MessageConstant.USER_NOT_LOGIN);
        }
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}

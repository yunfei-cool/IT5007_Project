package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    /**
     * Register
     * @param user
     * @return
     */
    boolean regist(User user);
    User login(User user);

}

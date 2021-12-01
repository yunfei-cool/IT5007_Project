package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {

    /**
     * find data by username
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * save the user
     * @param user
     */
    public void save(User user);

    User findByUsernameAndPassword(String username, String password);

}

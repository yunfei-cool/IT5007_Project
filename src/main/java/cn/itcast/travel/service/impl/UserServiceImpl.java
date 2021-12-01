package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    /**
     * Register
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.find user by username
        User u = userDao.findByUsername(user.getUsername());

        if(u != null){
            //already has the username, fail
            return false;
        }
        //2.save the information
        //2.1 Set the code
        user.setCode(UuidUtil.getUuid());
        //2.2 set the status
        user.setStatus("N");
        userDao.save(user);

        return true;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}



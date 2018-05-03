package com.zisal.springbootcxfsecuredbasic.service.impl;

import com.zisal.springbootcxfsecuredbasic.dao.IUserDAO;
import com.zisal.springbootcxfsecuredbasic.entity.User;
import com.zisal.springbootcxfsecuredbasic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired private IUserDAO userDAO;

    @Override
    public void insert(User p_User) {
        userDAO.save(p_User);
    }

    @Override
    public void update(User p_User) {
        userDAO.save(p_User);
    }

    @Override
    public void delete(Long p_Id) {
        userDAO.deleteById(p_Id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}

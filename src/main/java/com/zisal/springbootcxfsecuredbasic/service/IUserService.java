package com.zisal.springbootcxfsecuredbasic.service;

import com.zisal.springbootcxfsecuredbasic.entity.User;

import java.util.List;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserService {

    void insert(User p_User);

    void update(User p_User);

    void delete(Long p_Id);

    List<User> findAll();
}

package com.zisal.springbootcxfsecuredbasic.endpoint.impl;

import com.zisal.springbootcxfsecuredbasic.converter.UserConverter;
import com.zisal.springbootcxfsecuredbasic.dto.RequestInsertUserDTO;
import com.zisal.springbootcxfsecuredbasic.dto.ResponseAllData;
import com.zisal.springbootcxfsecuredbasic.dto.ResponseData;
import com.zisal.springbootcxfsecuredbasic.dto.UserDTO;
import com.zisal.springbootcxfsecuredbasic.endpoint.IUserEndPoint;
import com.zisal.springbootcxfsecuredbasic.entity.User;
import com.zisal.springbootcxfsecuredbasic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class UserEndPointImpl implements IUserEndPoint {

    @Autowired private IUserService userService;

    @Autowired private UserConverter userConverter;

    @Override
    public Response insert(RequestInsertUserDTO p_RequestInsertUserDTO) {
        userService.insert(userConverter.convert(p_RequestInsertUserDTO));
        return Response.ok(new ResponseData("200", "Ok")).build();
    }

    @Override
    public Response update(UserDTO p_UserDTO) {
        userService.update(userConverter.convert2(p_UserDTO));
        return Response.ok(new ResponseData("200", "Ok")).build();
    }

    @Override
    public Response delete(Long p_Id) {
        userService.delete(p_Id);
        return Response.ok(new ResponseData("200", "Ok")).build();
    }

    @Override
    public Response findAll() {
        ResponseAllData responseAllData = new ResponseAllData();
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList){
            userDTOList.add(userConverter.invert(user));
        }
        responseAllData.setResponseData(new ResponseData("200", "Ok"));
        responseAllData.setContent(userDTOList);
        return Response.ok(responseAllData).build();
    }
}

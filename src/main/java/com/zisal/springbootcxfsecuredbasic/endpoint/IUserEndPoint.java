package com.zisal.springbootcxfsecuredbasic.endpoint;

import com.zisal.springbootcxfsecuredbasic.dto.RequestInsertUserDTO;
import com.zisal.springbootcxfsecuredbasic.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface IUserEndPoint {

    @Path("/insert")
    @POST
    Response insert(RequestInsertUserDTO p_RequestInsertUserDTO);

    @Path("/update")
    @PUT
    Response update(UserDTO p_UserDTO);

    @Path("/delete")
    @DELETE
    Response delete(Long p_Id);

    @Path("/findall")
    @GET
    Response findAll();
}

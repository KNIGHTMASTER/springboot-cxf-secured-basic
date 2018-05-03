package com.zisal.springbootcxfsecuredbasic.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Path("/echo")
@Produces(MediaType.APPLICATION_JSON)
public interface IEchoEndPoint {

    @Path("/{param}")
    @GET
    Response echoParam(@PathParam("param") String p_Param);
}

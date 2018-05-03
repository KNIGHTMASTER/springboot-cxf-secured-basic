package com.zisal.springbootcxfsecuredbasic.endpoint.impl;

import com.zisal.springbootcxfsecuredbasic.endpoint.IEchoEndPoint;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class EchoEndPointImpl implements IEchoEndPoint {

    @Override
    public Response echoParam(String p_Param) {
        return Response.ok("Welcome ".concat(p_Param)).build();
    }
}

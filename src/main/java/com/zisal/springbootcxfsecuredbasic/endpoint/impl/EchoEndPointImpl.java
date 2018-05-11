package com.zisal.springbootcxfsecuredbasic.endpoint.impl;

import com.zisal.springbootcxfsecuredbasic.endpoint.IEchoEndPoint;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class EchoEndPointImpl implements IEchoEndPoint {

    @Override
    public Response echoParam(String p_Param) {
        System.out.println("PRINCIPAL " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Collection<?extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String role;
        for(int i=0;i<granted.size();i++){
            role = granted.toArray()[i] + "";
            System.out.println("role verified" + i + " is -> " + role);
        }
        return Response.ok("Welcome ".concat(p_Param)).build();
    }
}

package com.lt.rs.resource;

import com.lt.rs.bean.User;
import com.lt.rs.mapper.UserMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/users")
public class UserResource {

    @Inject
    private UserMapper userMapper;

    @GET
    @Path("/{param}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get one user successful"),
            @ApiResponse(code = 404, message = "get one user failed")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(
            @ApiParam(name = "userId", value = "int", required = true)
            @PathParam("param") int userId) {

        User user = userMapper.getUserById(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("gender", user.getGender());

        return Response.status(Response.Status.OK).entity(map).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "get all users successful"),
            @ApiResponse(code = 404, message = "get all users failed")})
    public Response getAllUsers() {

        List<User> users = userMapper.getAllUsers();

        if (null == users) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


        List<Map> result = users
                .stream()
                .map(user -> {

                    Map<String, Object> map = new HashMap<>();
                    map.put("id", user.getId());
                    map.put("name", user.getName());
                    map.put("gender", user.getGender());

                    return map;
                })
                .collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(result).build();
    }
}

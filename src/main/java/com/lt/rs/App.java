package com.lt.rs;

import com.lt.rs.mapper.UserMapper;
import com.lt.rs.util.DBUtil;
import org.apache.ibatis.session.SqlSessionManager;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {

    public App() {
        SqlSessionManager session = DBUtil.getSession();
        final UserMapper userMapper = session.getMapper(UserMapper.class);


        packages("com.lt.rs.resource")
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(userMapper).to(UserMapper.class);
                    }
                });

    }

}

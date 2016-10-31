package com.lt.rs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    private DBUtil() {
    }

    public static SqlSessionManager getSession() {
        String resource = "mybatis/mybatis-config.xml";
        SqlSessionManager session = null;

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            session = SqlSessionManager.newInstance(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }

}

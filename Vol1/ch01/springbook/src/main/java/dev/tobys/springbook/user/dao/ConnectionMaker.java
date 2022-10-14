package dev.tobys.springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *  ConnectionMaker 인터페이스
 */
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}

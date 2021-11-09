package com.minhtrung.daos.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.Types;

import com.minhtrung.daos.IGenericDAO;
import com.minhtrung.mapper.RowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {
	public static Connection connection;

	public static Connection getConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		try {
			Class.forName(bundle.getString("driverName"));
			String URL = (bundle.getString("url"));
			String USER = (bundle.getString("username"));
			String PASS = (bundle.getString("password"));
			connection = DriverManager.getConnection(URL, USER, PASS);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setParameter(PreparedStatement preparedStatement, Object[] parameters) {
		int i;
		for (i = 0; i < parameters.length; i++) {
			int index = i + 1;
			try {
				Object object = parameters[i];
				if (object instanceof String) {
					preparedStatement.setString(index, (String) object);
				} else if (object instanceof Long) {
					preparedStatement.setLong(index, (Long) object);
				} else if (object instanceof Integer) {
					preparedStatement.setInt(index, (Integer) object);
				} else if(object instanceof Float) {
					preparedStatement.setFloat(index,(float) object);
				}else if (object instanceof Timestamp) {
					preparedStatement.setTimestamp(index, (Timestamp) object);
				} else if (object instanceof Date) {
					preparedStatement.setDate(index, (Date) object);
				} else if(object == null ) {
					preparedStatement.setNull(index, Types.NULL);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<T> query(String sql, RowMapper<T> mapper, Object... objects) {
		List<T> list = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			setParameter(preparedStatement, objects);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(mapper.mapRow(resultSet));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Long insert(String sql, RowMapper<T> mapper, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			while(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}

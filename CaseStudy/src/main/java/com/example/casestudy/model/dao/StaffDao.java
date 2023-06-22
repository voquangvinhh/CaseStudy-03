package com.example.casestudy.model.dao;

import com.example.casestudy.connection.JDBCConnection;
import com.example.casestudy.model.dto.StaffDto;
//import com.example.casestudy.model.entity.Staff;
import com.example.casestudy.service.StaffService;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.casestudy.connection.JDBCConnection.getConnection;

public class StaffDao {
    public StaffDao(){}
    public List<StaffDto> staffDtos = null;

    public void insertStaff(StaffDto staffDto) {
        try{
            if (staffDto.getId() != 0){
                System.out.println("Staff is existed.");
            }
            Connection connection = getConnection();
            String query = "INSERT INTO staff (name,birthday, sex, phonenumber, email, address) " +
                    "VALUES (?, ?, ?, ?, ?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, staffDto.getName());
            preparedStatement.setString(2, staffDto.getBirthday());
            preparedStatement.setString(3, staffDto.getSex());
            preparedStatement.setString(4, staffDto.getPhoneNumber());
            preparedStatement.setString(5, staffDto.getEmail());
            preparedStatement.setString(6, staffDto.getAddress());
            System.out.println(preparedStatement);

            if(preparedStatement.executeUpdate() > 0){
                System.out.println("Added staff successfully");
            } else {
                System.out.println("Failed to insert staff");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public StaffDto selectStaff(int id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "select id,name,birthday,sex,phonenumber,email,address from staff where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                StaffDto staffDto = new StaffDto();
                staffDto.setId(resultSet.getInt("id"));
                staffDto.setName(resultSet.getString("name"));
                staffDto.setBirthday(resultSet.getString("birthday"));
                staffDto.setSex(resultSet.getString("sex"));
                staffDto.setPhoneNumber(resultSet.getString("phonenumber"));
                staffDto.setEmail(resultSet.getString("email"));
                staffDto.setAddress(resultSet.getString("address"));
                return staffDto;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new StaffDto();
    }


    public List<StaffDto> selectAllStaff() {
        staffDtos = new LinkedList<>();
        try {
            Connection connection = getConnection();
            String query =  "select * from staff;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                StaffDto staffDto = new StaffDto(id, name, birthday, sex,phone, email, address);
                staffDtos.add(staffDto);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffDtos;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    public boolean deleteStaff(int id) throws SQLException {
        boolean rowDeleted;
        String query = "DELETE FROM staff WHERE id = ?;";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    public void updateStaff(StaffDto staff) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "UPDATE staff SET name = ?, birthday = ?," +
                    " sex = ?, phonenumber = ?, email = ?, address =? WHERE id =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getBirthday());
            preparedStatement.setString(3, staff.getSex());
            preparedStatement.setString(4, staff.getPhoneNumber());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getAddress());
            preparedStatement.setInt(7, staff.getId());

            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Edited staff successfully");
            } else {
                System.out.println("Failed to edit staff");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StaffDto> searchByName(String name){
        List<StaffDto> staffDtoList = new ArrayList<>();
        try{
            Connection connection = JDBCConnection.getConnection();
            String query = "SELECT * FROM staff WHERE name like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                StaffDto staffDto = new StaffDto(id, name, birthday, sex,phone, email, address);
                staffDtos.add(staffDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffDtoList;
    }


//    public Staff get(int id) {
//        try{
//            Connection connection = JDBCConnection.getConnection();
//            String query = "SELECT * FORM staffs WHERE id = ?;";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Staff staff = new Staff();
//                staff.setId(resultSet.getInt("id"));
//                staff.setName(resultSet.getString("name"));
//                staff.setBirthday(resultSet.getString("birthday"));
//                staff.setSex(resultSet.getString("sex"));
//                staff.setPhoneNumber(resultSet.getString("phonenumber"));
//                staff.setEmail(resultSet.getString("email"));
//                staff.setAddress(resultSet.getString("address"));
//                return staff;
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return new Staff();
//    }
}

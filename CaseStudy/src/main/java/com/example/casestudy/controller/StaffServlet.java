package com.example.casestudy.controller;

import com.example.casestudy.model.dto.StaffDto;
//import com.example.casestudy.model.entity.Staff;
import com.example.casestudy.model.dao.StaffDao;
import com.example.casestudy.service.StaffService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StaffDao staffDao;

    private StaffService service = null;
    public void init() throws ServletException{
        service = new StaffService();
        staffDao = new StaffDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteStaff(request, response);
                    break;
                case "searchByName":
                    searchByName(request, response);
                    break;
                case "sortByName":
//                    sortByName(request,response);
                    break;
                case "detail":
                    detailId(request, response);
                    break;
                default:
                    listStaff(request, response);
                    break;
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StaffDto> listStaff = staffDao.searchByName(request.getParameter("searchName"));
        request.setAttribute("listStaff", listStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
        dispatcher.forward(request, response);
    }

    private void detailId(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("staff", service.find(id));
        request.getRequestDispatcher("/WEB-INF/view/detail.jsp");
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffDao.deleteStaff(id);

        List<StaffDto> staffList = staffDao.selectAllStaff();
        request.setAttribute("listStaff", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StaffDto existingStaff = staffDao.selectStaff(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/edit.jsp");
        request.setAttribute("staff", existingStaff);
        requestDispatcher.forward(request, response);
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StaffDto> listStaff = staffDao.selectAllStaff();
        request.setAttribute("listStaff", listStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action   = request.getParameter("action");
        if (action == null);{
            action = "";
        }
        switch (action){
            case "create":
                insertStaff(request, response);
                break;
            case "edit":
                try {
                    updateStaff(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    private void insertStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        StaffDto staff = new StaffDto(name, birthday, sex, phone, email, address);
        staffDao.insertStaff(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/create.jsp");
        request.setAttribute("message", "New Staff was created");
        dispatcher.forward(request, response);
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        StaffDto staff = new StaffDto(id, name, birthday, sex, phone, email, address);
        staffDao.updateStaff(staff);
        request.setAttribute("message", "EditSuccessfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/edit.jsp");
        dispatcher.forward(request, response);
    }
}

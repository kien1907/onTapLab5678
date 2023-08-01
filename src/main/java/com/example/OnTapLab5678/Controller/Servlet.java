package com.example.OnTapLab5678.Controller;

import com.example.OnTapLab5678.Entity.MayTInh;
import com.example.OnTapLab5678.Service.MayTinhService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/may-tinh/hien-thi",
        "/may-tinh/add",
        "/may-tinh/update",
        "/may-tinh/delete",
        "/may-tinh/detail",
        "/may-tinh/view-update"
})
public class Servlet extends HttpServlet {
    MayTinhService mayTinhService;
    public Servlet() {
        mayTinhService = new MayTinhService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String uri = request.getRequestURI();
              if (uri.contains("/hien-thi")){
                  List<MayTInh> list = this.mayTinhService.getAll();
                  request.setAttribute("list",list);
                  request.getRequestDispatcher("/index.jsp").forward(request,response);
              }else if(uri.contains("/detail")){
                   String ma = request.getParameter("ma");
                   MayTInh mayTInh = this.mayTinhService.findById(ma);
                   request.setAttribute("mt",mayTInh);
                  List<MayTInh> list = this.mayTinhService.getAll();
                  request.setAttribute("list",list);
                  request.getRequestDispatcher("/index.jsp").forward(request,response);
              }else if(uri.contains("/delete")){
                  String ma = request.getParameter("ma");
                  MayTInh mayTInh = this.mayTinhService.findById(ma);
                  this.mayTinhService.delete(mayTInh);
                  response.sendRedirect("/may-tinh/hien-thi");
              }else if(uri.contains("/view-update")){
                  String ma = request.getParameter("ma");
                  MayTInh mayTInh = this.mayTinhService.findById(ma);
                  request.setAttribute("mt",mayTInh);
                  request.getRequestDispatcher("/detail.jsp").forward(request,response);
              }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")){
            MayTInh mayTInh = new MayTInh();
            BeanUtils.populate(mayTInh,request.getParameterMap());
            this.mayTinhService.add(mayTInh);
            response.sendRedirect("/may-tinh/hien-thi");
        }else if(uri.contains("/update")){
            MayTInh mayTInh = new MayTInh();
            BeanUtils.populate(mayTInh,request.getParameterMap());
            this.mayTinhService.update(mayTInh);
            response.sendRedirect("/may-tinh/hien-thi");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlet;

import control.Init;
import etc.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerModel;
import model.iofile.ReadFile;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author nguyenphi
 */
public class Customer extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Init.setHeader(request, response);
        PrintWriter print = response.getWriter();
        String ac = request.getParameter("action");
        if (StringUtils.isBlank(ac)) {
            Init.badRequest(response);
            return;
        }

        if (ac.equals("getAll")) {
            print.write(ReadFile.read("src\\java\\etc\\data\\customer_list.txt"));
            return;
        }

        if (ac.equals("add")) {
            String ccode = request.getParameter("ccode");
            String cusName = request.getParameter("cusName");
            String phone = request.getParameter("phone");
            if (StringUtils.isBlank(ccode) || StringUtils.isBlank(cusName) || StringUtils.isBlank(phone)) {
                Init.badRequest(response);
                return;
            }
            model.entities.Customer customer = new model.entities.Customer();
            customer.setCcode(ccode);
            customer.setCusName(cusName);
            customer.setPhone(phone);
            if (CustomerModel.add(customer)) {
                print.write(ReadFile.read("src\\java\\etc\\data\\customer_list.txt"));
                return;
            }
            Init.forbidden(response);
            return;
        }

        if (ac.equals("delete")) {
            String ccode = request.getParameter("quantity");
            if (StringUtils.isBlank(ccode)) {
                Init.badRequest(response);
                return;
            }
            if (CustomerModel.deleteByCode(ccode)) {
                print.write(ReadFile.read("src\\java\\etc\\data\\customer_list.txt"));
                return;
            }
            Init.forbidden(response);
            return;
        }

        if (ac.equals("sort")) {
            String trs = request.getParameter("isLowToHigh");
            if (StringUtils.isBlank(trs) || !(trs.equals("1") || trs.equals("0"))) {
                Init.badRequest(response);
                return;
            }
            if (CustomerModel.sort(trs.equals("1"))) {
                print.write(ReadFile.read("src\\java\\etc\\data\\customer_list.txt"));
                return;
            }
            Init.forbidden(response);
            return;
        }

        if (ac.equals("search")) {
            String c = request.getParameter("ccode");
            if (StringUtils.isBlank(c)) {
                Init.badRequest(response);
                return;
            }
            print.write(CustomerModel.searchAll(c).displayForward());
            return;
        }
        print.write("[]");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the c.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

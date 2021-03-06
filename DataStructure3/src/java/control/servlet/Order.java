package control.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderModel;
import model.iofile.ReadFile;

import org.apache.commons.lang.StringUtils;
import org.apache.http.ParseException;
import org.apache.log4j.Logger;

import control.Init;
import etc.Constants;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * this is servlet class provided Order API
 */
public class Order extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Logger logger = Logger.getLogger(Order.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Init.setHeader(request, response);
        PrintWriter print = response.getWriter();
        String action = request.getParameter("action");
        if (StringUtils.isBlank(action)) {
            Init.badRequest(response);
            return;
        }

        if (action.equals("getAll")) {
            print.write(ReadFile.read(Constants.ORDER_DATA_URL));
            return;
        }

        if (action.equals(Constants.ADD_ACTION)) {
            String ccode = request.getParameter(Constants.ORDER_CUSTOMER_CODE);
            String pcode = request.getParameter(Constants.ORDER_PRODUCT_CODE);
            String strQuantity = request.getParameter(Constants.ORDER_QUANTITY);
            if (StringUtils.isBlank(ccode) || StringUtils.isBlank(pcode) || StringUtils.isBlank(strQuantity)) {
                Init.badRequest(response);
                return;
            }
            int quantity = 0;
            try {
                quantity = Integer.parseInt(strQuantity);
            } catch (ParseException e) {
                logger.error("ParseException: ", e);
            }

            model.entities.Order order = new model.entities.Order();
            order.setCcode(ccode);
            order.setPcode(pcode);
            order.setQuantity(quantity);
            if (OrderModel.add(order)) {
                print.write(ReadFile.read(Constants.ORDER_DATA_URL));
                return;
            }
            Init.forbidden(response);
            return;
        }

        if (action.equals(Constants.SORT_ACTION)) {
            String type = request.getParameter(Constants.SEARCH_TYPE);
            String strLowToHigh = request.getParameter(Constants.IS_LOW_TO_HIGH);
            if (StringUtils.isBlank(strLowToHigh) || !(strLowToHigh.equals("1") || strLowToHigh.equals("0"))
                    || type == null || !(type.equals(Constants.ORDER_PRODUCT_CODE) || type.equals(Constants.ORDER_CUSTOMER_CODE))) {
                Init.badRequest(response);
                return;
            }
            if (OrderModel.sort(type.equals(Constants.ORDER_PRODUCT_CODE), strLowToHigh.equals("1"))) {
                print.write(ReadFile.read(Constants.ORDER_DATA_URL));
                return;
            }
            Init.forbidden(response);
            return;
        }
        if (action.equals(Constants.FIND_ORDER_ACTION)) {
            String ccode = request.getParameter(Constants.ORDER_CUSTOMER_CODE);
            String pcode = request.getParameter(Constants.ORDER_PRODUCT_CODE);
            if (StringUtils.isBlank(ccode) || StringUtils.isBlank(pcode)) {
                Init.badRequest(response);
                return;
            }
            print.write(OrderModel.get(ccode, pcode));
            return;
        }

        print.write(Constants.DEFAULT_RESULT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

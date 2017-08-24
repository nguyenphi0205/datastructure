package control;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * this is class use to set header when servlet return value
 */
public class Init {

    final static Logger logger = Logger.getLogger(Init.class);

    /**
     * Allow get api from ajax
     *
     * @param request servlet request
     * @param res servlet res
     */
    public static void setHeader(HttpServletRequest req, HttpServletResponse res) {
        String clientOrigin = req.getHeader("origin");
        res.setHeader("Access-Control-Allow-Origin", clientOrigin);
        res.setHeader("Access-Control-Allow-Methods", "POST");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        res.setHeader("Access-Control-Max-Age", "86400");
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
    }

    /**
     * return 400 status code to client
     *
     * @param res servlet res
     */
    public static void badRequest(HttpServletResponse res) {
        res.setContentType("text/html");
        res.setStatus(400);
        try {
            res.getWriter().write("<!DOCTYPE html><html><head><title>400: Bad Request</title></head><body>");
            res.getWriter().write("<h1>400: Bad Request</h1>The server cannot or will not process the request due to an apparent client error");
            res.getWriter().write("</body></html>");
        } catch (IOException e) {
            logger.error("IOException: ", e);
        }
    }

    /**
     * return 403 status code to client
     *
     * @param res servlet res
     */
    public static void forbidden(HttpServletResponse res) {
        res.setContentType("text/html");
        res.setStatus(403);
        try {
            res.getWriter().write("<!DOCTYPE html><html><head><title>403: Forbidden</title></head><body>");
            res.getWriter().write("<h1>403: Forbidden</h1>The request was valid, but the server is refusing action. The user might not have the necessary permissions for a resource, or may need an account of some sort.");
            res.getWriter().write("</body></html>");
        } catch (IOException e) {
            logger.error("IOException: ", e);
        }
    }
}

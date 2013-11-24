package vn.edu.rmit.common.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import vn.edu.rmit.common.utility.FileHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/24/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
//This is programed based on the HelloWorld Tutorial that Mr.Thanh has send
//Source: http://www.mkyong.com/spring-mvc/spring-mvc-hello-world-example/
public class LocalServerController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("SuccessfulWebNotification");
        model.addObject("msg", "hello world");

        if (request.getParameter("Data") != null)
        {
            FileHandler handler = new FileHandler(request.getParameter("Data"));
            handler.insertValueFromJson();
        }

        return model;
    }
}

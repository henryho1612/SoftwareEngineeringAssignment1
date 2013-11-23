package vn.edu.rmit.common.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import vn.edu.rmit.common.utility.FileHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world");

        if (request.getParameter("Data") != null)
        {
            FileHandler handler = new FileHandler(request.getParameter("Data"));
            handler.insertValueFromJson();
        }

        return model;
    }
}
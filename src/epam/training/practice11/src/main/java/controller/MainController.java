package controller;

import controller.constants.Views;
import entities.ResultWithPrecision;
import service.convert.AngleConverter;
import service.convert.AngleUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "main", urlPatterns = {"/calc"})
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String function = req.getParameter("function");
        int precision = Integer.parseInt(req.getParameter("precision"));
        double value = Double.parseDouble(req.getParameter("value"));
        String unit = req.getParameter("unit");

        try {
            TrigonometricFunction trigonometricFunction = TrigonometricFunction.valueOf(function.toUpperCase());
            AngleUnit angleUnit = AngleUnit.valueOf(unit.toUpperCase());
            value = AngleConverter.convertToRadians(value, angleUnit);
            double result = trigonometricFunction.calc(value);
            ResultWithPrecision resultWithPrecision = new ResultWithPrecision(result, precision);

            req.setAttribute("resultObject", resultWithPrecision);
        } catch (Exception e){
            req.setAttribute("error", "Введены неверные данные");
        }

        req.getRequestDispatcher(Views.RESULT_VIEW).forward(req, resp);
    }
}

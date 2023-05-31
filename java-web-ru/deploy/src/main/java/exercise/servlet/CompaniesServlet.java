package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        List<String> listOfSearchCompanies = new ArrayList<>();
        String queryString = request.getQueryString();
        String searchParam = request.getParameter("search");

        if (searchParam.equals("") || searchParam == null) {
            listOfSearchCompanies = Data.getCompanies();
        } else {
            for (String company: Data.getCompanies()) {
                if (company.contains(searchParam)) {
                    listOfSearchCompanies.add(company);
                }
            }
        }

        if (listOfSearchCompanies.isEmpty()) {
            out.println("Companies not found.");
        } else {
            out.println(listOfSearchCompanies);
        }

        // END
    }
}

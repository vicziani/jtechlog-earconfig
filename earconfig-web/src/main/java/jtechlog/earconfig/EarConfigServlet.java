package jtechlog.earconfig;

import java.io.IOException;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class EarConfigServlet extends HttpServlet {

    @EJB
    private EarConfig earConfig;

    private static final String SYSTEM_PROPERTY_NAME = "earconfig.system.property";

    private static final String[] NAMES = new String[]{"earconfig/string", "earconfig/url", "earconfig/inetaddress", "earconfig/properties"};

    public String readConfigurationsFromSystemProperty() {
        return System.getProperty(SYSTEM_PROPERTY_NAME);
    }

    public Object[] readConfigurationsFromContext() {

        Object[] configurations = new Object[NAMES.length];

        // Read global names
        Context context;
        try {
            context = new InitialContext();
        } catch (NamingException ne) {
            throw new RuntimeException("Error by accessing context.", ne);
        }

        for (int i = 0; i < NAMES.length; i++) {
            try {
                configurations[i] = context.lookup(NAMES[i]);

            } catch (NamingException ne) {
                System.out.println("Error by loading config from JNDI name: " + NAMES[i]);
            }

        }
        return configurations;
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("systemPropertyEjb", earConfig.readConfigurationsFromSystemProperty());
        request.setAttribute("contextEjb", Arrays.asList(earConfig.readConfigurationsFromContext()));

        request.setAttribute("systemPropertyWeb", readConfigurationsFromSystemProperty());
        request.setAttribute("contextWeb", Arrays.asList(readConfigurationsFromContext()));


        getServletConfig().getServletContext().getRequestDispatcher(
                "/WEB-INF/jsp/earConfig.jsp").forward(request, response);
    }
}

package jtechlog.earconfig;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class EarConfigBean implements EarConfig {

    private static final String SYSTEM_PROPERTY_NAME = "earconfig.system.property";

    private static final String[] NAMES = new String[]{"earconfig/string", "earconfig/url", "earconfig/properties"};

    @Override
    public String readConfigurationsFromSystemProperty() {
        return System.getProperty(SYSTEM_PROPERTY_NAME);
    }

    @Override
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
}

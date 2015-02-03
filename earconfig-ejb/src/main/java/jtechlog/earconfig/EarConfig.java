package jtechlog.earconfig;

import javax.ejb.Remote;

@Remote
public interface EarConfig {

    public String readConfigurationsFromSystemProperty();

    public Object[] readConfigurationsFromContext();
}

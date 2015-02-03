<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <h1>EAR konfig példa</h1>
    <p>A projekt bemutatja, hogy hogyan lehet Java EE alkalmazásból konfigurációs paramétereket beolvasni.</p>

    <ul>
        <li>System property EJB rétegben (kulcs: earconfig.system.property): ${systemPropertyEjb}</li>
        <li>Context lookup (JNDI) EJB rétegben (JNDI nevek: earconfig/string, earconfig/url, earconfig/inetaddress, earconfig/properties): ${contextEjb}</li>
        <li>System property web rétegben (kulcs: earconfig.system.property): ${systemPropertyWeb}</li>
        <li>Context lookup (JNDI) web rétegben (JNDI nevek: earconfig/string, earconfig/url, earconfig/inetaddress, earconfig/properties): ${contextWeb}</li>
    </ul>

</html>
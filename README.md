Konfigurációs paraméterek
=========================

Ez a program a JTechLog (<http://www.jtechlog.hu>) blog "Konfigurációs paraméterek EJB és web rétegben
Glassfish alkalmazásszerveren" és "Konfigurációs paraméterek EJB és web rétegben JBoss alkalmazásszerveren"
posztjaihoz készült példaprogram.

A projekt bemutatja, hogy hogyan lehet Java EE alkalmazásból konfigurációs paramétereket beolvasni.

Az `mvn package` paranccsal előáll az ear állomány az `earconfig-ear/target` könyvtárban, mely telepíthető az
alkalmazásszerverekre.

Amennyiben a Glassfishen properties állományt is be akarunk olvasni, használjuk a következőt:

    key1=value1
    key2=value2
    
WildFly-on a következő beállításokat használhatjuk a `standalone/configuration/standalone.xml` állományban:

    <system-properties>
        <property name="earconfig.system.property" value="Hello System Property!"/>
    </system-properties>
    
    <subsystem xmlns="urn:jboss:domain:naming:2.0">
        <bindings>
            <simple name="java:/earconfig/string" value="Hello, JNDI!" type="java.lang.String" />
            <simple name="java:/earconfig/url" value="http://www.jtechlog.hu" type="java.net.URL" />
        </bindings>
        <remote-naming/>
    </subsystem>

viczian.istvan a gmail-en

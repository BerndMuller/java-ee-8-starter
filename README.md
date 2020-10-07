# Java EE 8 and Jakarta EE 8 Starter

Simple {Java|Jakarta} EE 8 Starter Application for WildFly and Payara.

It activates und uses

* JAX-RS by JaxRxActivator class
* JSF 2.3 by faces-config.xml and version by Jsf23Activator
* CDI by beans.xml
* JPA by persistence.xml
* BV because JSF and JPA is used

## Getting Started

Run

```
mvn clean package
```

and deploy on your app server. For example

```
cp target/java-ee-8-starter.war <WILDFLY>/standalone/deployments/
```


## Prerequisites

Java EE 8 Application Server. Tested with WildFly 20 and Payara 5.2020.4.
Payara is restricted to Java 11.


## Brief Description

* An instance of the JPA entity ``Message`` is persisted to the database because of the startup and singleton EJB ``MessageInit``
* The database is the built in H2 database (WildFly and Payara) via JPA's default datasource (``persistence.xml`` empty)
* An HTTP GET request is directed to ``/message.xhtml`` which shows the JSF version and the last message
* You can insert new message in ``/message.xhtml`` 
* All messages are available via REST at http://localhost:8080/java-ee-8-starter/resources/messages delivered by ``MessageResource``


## License

See the [LICENSE](LICENSE.txt) file for license rights and limitations (MIT).

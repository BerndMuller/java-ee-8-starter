# Java EE 8 and Jakarta EE 8 Starter

Simple {Java|Jakarta} EE 8 Starter Application for WildFly and Payara.

It activates und uses

* JAX-RS by JaxRxActivator class
* JSF 2.3 by faces-config.xml and version by Jsf23Activator
* CDI by beans.xml
* JPA by persistence.xml
* BV because JSF and JPA is used
* EJB 

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

Java EE 8 Application Server. Tested on WildFly 21 with Java 15 and Payara 5.2020.4 with
Java 11 because Payara is restricted to Java 11.


## Brief Description

* An instance of the JPA entity ``Message`` is persisted to the database because of the startup and singleton EJB ``MessageInit``
* The database is the built in H2 database (WildFly and Payara) via JPA's default datasource (``persistence.xml`` empty)
* An HTTP GET request is directed to ``/message.xhtml`` which shows the JSF version and the last message
* You can insert new message in ``/message.xhtml`` 
* All messages are available via HTTP GET at ``http://localhost:8080/java-ee-8-starter/resources/messages`` delivered by ``MessageResource``


## WildFly Bootable Jar

After the retirement of 
[WildFly Swarm](https://www.wildfly.org/news/2015/05/05/WildFly-Swarm-Released/) and
[Thorntail](https://thorntail.io/) WildFly 21 is now capable to package itself and the application
into a Jar file via [WildFly Jar Maven Plugin](https://docs.wildfly.org/bootablejar/) and
[Galleon Layers](https://docs.wildfly.org/galleon/). We do not use a profile but a separate POM
to handle this.

Build the Jar:

```
mvn clean package -f pom-bootable.xml
```

creates ``java-ee-8-starter-bootable.jar`` in the target folder which contains WildFly base as well as
all used layers. 

And run it:

```
java -jar target/java-ee-8-starter-bootable.jar
```

The deployment name disappears. Point your browser to 
``http://localhost:8080`` to use the UI. The REST endpoint is abailable at
``http://localhost:8080/resources/messages``.


## WildFly Bootable Jar Dev Mode

There is also a developer mode with hot deployment. Simply run

```
mvn wildfly-jar:dev-watch -f pom-bootable.xml
```

and the Maven plugin will detect code changes of classes, JSF pages and resources and will redeploy
the application automatically. To stop dev mode type CTRL-C.


## License

See the [LICENSE](LICENSE.txt) file for license rights and limitations (MIT).

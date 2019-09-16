**PROPERTIES FILE CONFIGURATION**

Config Server Project 
Application.properties file:

server.port=9999
spring.cloud.config.server.git.uri=https://github.com/coding-boot-camp/enterprise-cloud-config

Annotations needed on Application class: @EnableConfigServer

===========================================================================  
**Eureka Server Project**
Application.properties file:

server.port=8761
eureka.instance.hostname=localhost

Shut off the client functionality of the Eureka server (used for HA)
eureka.client.registerWithEureka=false
eureka.client.fetchRegistry=false


Annotations needed on Application class : @EnableEurekaServer

===========================================================================  
>First Microservice that will connect

**Bootstrap.proprerties file**
this file has just enough information so that our application can find the configuration service and its configuration settings.
This name must match the name of the properties file for this application in the configuration repository. we are looking for a 
file that exists on GITHUB.

This is the name url to the configuration service that we'll use to get our configuration
>spring.application.name=random-greeting-service (exists on Github, name must match)
>spring.cloud.config.uri=http://localhost:9999


Annotations needed on Application class: @EnableDiscoveryClient

A typical controller will have the following Code :

``` java
@RestController
@RefreshScope
public class HelloCloudServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${randomGreetingServiceName}")
    private String randomGreetingServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @Value("${officialGreeting}")
    private String officialGreeting;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloCloud() {

        List<ServiceInstance> instances = discoveryClient.getInstances(randomGreetingServiceName);

        String randomGreetingServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String greeting = restTemplate.getForObject(randomGreetingServiceUri, String.class);

        return greeting;
    }

}
```

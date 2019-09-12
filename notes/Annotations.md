# Spring Framework annotations (Boot,Web, Cloud)
> Legend: T = class level, F = field level, C = constructor level, M = method level, P = parameter level
- **SpringFramework**
  - @ComponentScan - make Spring scan the package for the @Configuration classes. **T**
  - @Configuration - mark a class as a source of bean definitions. **T**
- **SpringBoot**
  - @SpringBootApplication - uses @Configuration, @EnableAutoConfiguration and @ComponentScan (on application file). **T**
  - @EnableAutoConfiguration - make Spring guess the configuration based on the classpath. **T**
- **SpringWebStarter**
  - @RestController - marks the class as web controller, capable of handling the requests. a convenience annotation of a @Controller and @ResponseBody. **T**
  - @ResponseBody - makes Spring bind method’s return value to the web response body. **T && M**
  - @RequestMapping - specify on the method in the controller, to map a HTTP request to the URL to this method. **M**
  - @RequestParam - bind HTTP parameters into method arguments. **P**
  - @PathVariable - binds placeholder from the URI to the method parameter. **P**
 - **SpringCloud**
  - @EnableConfigServer - turns your application into a server other apps can get their configuration from. **T**
  - @EnableEurekaServer - makes your app an Eureka discovery service, other apps can locate services through it. **T**
  - @EnableDiscoveryClient - makes your app register in the service discovery server and discover other services through it. **T**
  - @EnableCircuitBreaker - configures Hystrix circuit breaker protocols. **T**
  - @Bean - indicates that a method produces a bean to be managed by the Spring container. **M**
  - @Component - turns the class into a Spring bean at the auto-scan time. @Service - specialization of the @Component, has no encapsulated state. **T**
  - @Autowired - Spring’s dependency injection wires an appropriate bean into the marked class member. **C && F && M**
  - @Lazy - makes @Bean or @Component be initialized on demand rather than eagerly. **T && M**
  - @Qualifier - filters what beans should be used to @Autowire a field or parameter. **C && F && M**
  - @Value - indicates a default value expression for the field or parameter, typically something like “#{systemProperties.myProp}”. **C && F && M**
  - @Required - fail the configuration, if the dependency cannot be injected. **C && F && M**
  

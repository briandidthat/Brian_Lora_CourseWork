# MicroServices Week 8
> What are microservices? What are the benefirs of this architectural style?
- Microservices is an architectural design pattern that is becoming more prevalent as the benefits become more apparent with large scale applications. 
  The “Microservice” style is an approach to developing an application as a suite of several small services, each running its own independent process and communicating with lightweight mechanisms such as an HTTP resource API. 
  The benefits to utilizing this architectural style, is that it offers the possibility of no down time applications. As these processes or “microservices” all run independently, certain parts of the application can be updated/edited without having to shut the entire service down. 
  Your development team can continue to work behind the scenes, without disrupting the end users experience. With a monolith application, any changes to the system involves building and deploying a new version of the server-side application. Another benefit of this abstraction, 
  is the separation of concerns. In theory, one can have any number of microservices that communicate with the same API, but each reading a certain resource. My favorite benefit, is that this makes parts of the application language-agnostic as one component can be written in Python
  (maybe to perform some ML), and another can be written in Java.

> What are the limitations of traditional configuration? What are the advantages of externalizing configuration settings?
- While traditional configuration has served us well for many years, it does have many limitations. For instance, if you want to modify the configuration for a microservice that has been replicated a hundred times (one hundred processes are running). If the configuration for this 
  microservice is packaged with the microservice itself, you’ll have to redeploy each of the one hundred instances. This can prove to be very time consuming, and can lead to unnecessary headaches as we must account for human error (we are not perfect after all).
- A service with externalized configuration works by keeping the configuration information in an external store, such as a database, file system, or environment variables. At startup, microservices load the configuration from the external store. During runtime, microservices 
  provide an option to reload the configuration without having to restart the service. This not only automates the update of important information on several services, it also provides one central place to update it. Spring cloud config gives us this functionality. Less redundant work 
  = Happy Dev team.

> What is Spring Cloud? List and explain five features. 
- External configuration which allows you to store the configuration information in one file (env file, github etc) and consume that information across multiple microservices.
- Service registry is essentially a database of all services, their instances and their location. Service instances are registered with the service registry on startup, to enable easy identification.
- Client side load-balancing allows the client to decide where to send the traffic also using an algorithm like round-robin. It can either discover the instances, via service discovery, or can be configured with a predefined list. Netflix Ribbon is an example of a client-side load balancer.
- Circuit breakers operate similar to electric circuit breakers. Sometimes, when using several services, there is always a possibility that one may be unavailable or exhibiting such high latency that it is ultimately rendered unusable causing a failure. When the number of consecutive failures 
  crosses a threshold, the circuit breaker trips, and for the duration of the timeout period all attempts to invoke the remote service will fail immediately. After the timeout expires the circuit breaker allows a limited number of test requests to pass through. If those requests succeed the 
  circuit breaker resumes normal operation. Otherwise, if there is a failure the timeout period begins again.
- Leader election allows the application to work together with other applications to coordinate a cluster leadership via a third party system. A leader can then be used to provide global state or global ordering, generally without sacrificing availability. 


# Service Registry
> What is a service registry? 
- Service registry is essentially a database of all the available services, instances and their locations. Applications use service registries to discover registered services and make calls to them. A client will use the service registry to identify where they should send their requests based
  on the available services.

> How does a service registry work?
- A service will be registered with the service registry, and it will provide all the necessary details such as its host and port. This service, will periodically ping the service registry to notify it of its status, sort of like a heartbeat. If the service does not send a consistent heartbeat, 
  the service registry will eventually the instance from the registry.

> What are the advantages and disadvantages of using a service registry?
- Advantages:
  - Service instances are registered at startup and deregistered at shutdown.
  - Allows the client to find available instances of a service.
  - Can use the Health Check API to verify that the service is available to handle the request.
- Disadvantages: 
  - A service registry must be set up and configured, which implies more labor initially.
  - It must be managed, to ensure that it is reliable and contains the latest information.
  - Is a critical system component—therefore, it needs to be highly available and up-to-date.
  - You must take precautionary measures to ensure that you have a backup in the event that your service registry fails.


# Load Balancing
> What is a load balancer and how does it work?
- Load balancing is a method for distributing tasks onto multiple computers. For instance, distributing incoming HTTP requests   (tasks) for a web application onto multiple web servers. The primary purpose of load balancing is to distribute the work       load of an application onto multiple computers, so the application can process a higher work load. Load balancing is a way     to scale an application. A secondary goal of load balancing is often (but not always) to provide redundancy in your           application. That is, if one server in a cluster of servers fail, the load balancer can temporarily remove that server from
  the cluster, and divide the load onto the functioning servers. Having multiple servers help each other in this way is    
  typically called "redundancy". When an error happens and the tasks is moved from the failing server to a functioning server,   this is typically called "failover".

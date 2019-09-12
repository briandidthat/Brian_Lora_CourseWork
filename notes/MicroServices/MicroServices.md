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
  the cluster, and divide the load onto the functioning servers. Having multiple servers help each other in this way is         typically called "redundancy". When an error happens and the tasks is moved from the failing server to a functioning server,   this is typically called "failover".
- The most common load balancing schemes are:
  - Even Task Distribution Scheme
    - An even task distribution scheme means that the tasks are distributed evenly between the servers in the cluster. This         scheme is thus very simple. This makes it easier to implement. The even task distribution scheme is also known as "Round       Robin", meaning the servers receive work in a round robin fashion (evenly distributed). 
      Even task distribution load balancing is suitable when the servers in the cluster all have the same capacity, and the         incoming tasks statistically require the same amount of work.

      Even task distribution ignores the difference in the work required to process each task. That means, that even if each         server is given the same number of tasks, you can have situations where one server has more tasks requiring heavy             processing than the others. This may happen due to the randomness of incoming tasks. This would often even itself out         over time, since the overloaded server may all of a sudden receive a set of light work load tasks too.
  - Weighted Task Distribution Scheme
    - A weighted task distribution load balancing scheme distributes the incoming tasks onto the servers in the cluster using       weights. That means that you can specify the weight (ratio) of tasks a server should receive relative to other servers.       This is useful if the servers in the cluster do not all have the same capacity.  
      For instance, if one of three servers only has 2/3 capacity of the two others, you can use the weights 3, 3, 2. This           means that the first server should receive 3 tasks, the second server 3 tasks, and the last server only 2 tasks, for q         every 8 tasks received. That way the server with 2/3 capacity only receives 2/3 tasks compared to the other servers in         the cluster.
      
      As mentioned earlier, weighted task distribution load balancing is useful when the servers in the cluster do not all           have the same capacity. However, weighted task distribution still does not take the work required to process the tasks         into consideration.
  - Sticky Session Scheme
    - The two previous load balancing schemes are based on the assumption that any incoming task can be processed                   independently of previously executed tasks. This may not always be the case though.  
      Imagine if the servers in the cluster keep some kind of session state, like the session object in a Java web application       (or in PHP, or ASP). If a task (HTTP request) arrives at server 1, and that results in writing some value to session           state, what happens if subsequent requests from the same user are sent to server 2 or server 3? Then that session value       might be missing, because it is stored in the memory of server 1.
      
      With sticky session load balancing it isn't the tasks that are distributed out to the servers, but rather the task             sessions. This will of course result in a somewhat more unpredictable distribution of work load, as some sessions will         contain few tasks, and other sessions will contain many tasks.
  - Even Size Task Queue Distribution Scheme
    - The even size task queue distribution scheme is similar to the weighted task distribution scheme, but with a twist.           Instead of blindly distributing the tasks onto the servers in the cluster, the load balancer keeps a task queue for each       server. The task queues contain all requests that each server is currently processing, or which are waiting to be             processed. When a server finishes a task, for instance has finished sending back an HTTP response to a client, the task       is removed from the task queue for that server.

      The even tasks queued distribution scheme works by making sure that each server queue has the same amount of tasks in         progress at the same time. Servers with higher capacity will finish tasks faster than servers with low capacity. Thus         the task queues of the higher capacity servers will empty faster and thus faster have space for new tasks.
  - Autonomous Queue Scheme
    - The autonomous queue load balancing scheme, all incoming tasks are stored in a task queue. The servers in the server           cluster connects to this queue and takes the number of tasks they can process. 
      In this scheme there is no real load balancer. Each server takes the load it is able to handle. There is just the task         queue and the server. If a server falls out of the cluster, its tasks are kept unprocessed on the task queue, and             processed by other servers later. Thus each server functions autonomously of the other servers and of the task queue. No       load balancer needs to know what servers are part of the cluster etc. The task queue does not need to know about the           servers. Each server just needs to know about the task queue.

      Autonomous queue load balancing also implicitly takes the work load and capacity of each sever into consideration.             Servers only take tasks from the queue then they have capacity to process them.

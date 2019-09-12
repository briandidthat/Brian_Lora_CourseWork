# Services 

> Business Logic does not exist inside the controlller nor the DAO/DTO. It lives inside the "Service Layer".
* Service Layer
    - The java object model of simple CRUD applications can be tightly coupled with the database structure. 
    - The service layer can validate model data before passing it to the DAO.
    - The service layer needs references to all dao's in order to properly communicate. 
    Example implementation:
        - The AlbumViewModel contains the information about the album DTO but also has the following:
            - An artist object (rather than just the id)
            - A label object (rather than just the id)
            - A list of associated tracks (the album dto does not contain any reference to the tracks.)  
            - With this type of architecture, the controller will only return view models. 
            **This type of model is more convenient for the end user.**

> Sometimes you may use an external api or database and would like to test your own code against certain things.
* Testing the Service Layer:
    - Types of testing:
        - Unit Testing
        - Integration Testing
        - Performance Testing 
        - User Acceptance Testing
    - We use mock objects to test out our code. Mockito is the current preferred library.
        - Mockito is already included in the start depencies of SpringBoot. 
        - With Mockito you can simulate the functionality of the DAO and Implementation. This allows you to isolate and test the 
          service layer by itself.
        - While testing the service layer, the database is unimportant for the timebeing. 
# Services 

> Business Logic does not exist inside the controlller nor the DAO/DTO. It lives inside the "Service Layer".
* Service Layer
    - The java obhect model of simple CRUD applications can be tightly coupled with dthe database structure. 
    - The service layer can validate model data before passing it to the DAO.
    - The service layer needs references to all dao's in order to properly communicate. 
    Example implementation:
        - The AlbumViewModel contains the information about the album DTO but also has the following:
            - An artist object (rather than just the id)
            - A label object (rather than just the id)
            - A list of associated tracks (the album dto does not contain any reference to the tracks.)  
            - With this type of architecture, the controller will only return view models. 
            **This type of model is more convenient for the end user.**
            
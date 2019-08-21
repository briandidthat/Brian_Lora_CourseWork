# Spring/MYSQL 

> Steps to generate Spring application 
- Visit start.spring.io and enter the appropriate name for your project.
- You will need to add MYSQL and JDBC as dependencies when initializing a project that will use MYSQL connectivity.
- Create your model that will map 1:1 with the table (so it MUST have all properties(columns))
- Create "dao" package that should contain the "DAO" interface and a "DaoJdbcTemplateImpl" that will implement it.
- The interface should have all of the CRUD methods that your baseline implementation will use.
- This new implementation class should have the annotation "@Repository" to notify Spring to track it.
>TDD - Test Driven Development
- Generate tests for your Interface that should exist inside the "dao" folder using the auto-generator with Junit4.
    - The @Autowired annotation tells Spring to check the repository class and return an 
      implementation of this interface
    - Always start from "red" to fail all of your tests, and then refactor in order to achieve "green" to represent 
      passing the tests.
    - When testing, always start with the most obvious/extreme cases and consider more edge cases as you go along.
    
 - To connect the DB, add the following to the src/resources/application.properties with the correct attributes:
 ``` java
 spring.datasource.url: jdbc:mysql://localhost:3306/moto_inventory?useSSL=false
 spring.datasource.username: root
 spring.datasource.password: rootroot
 spring.datasource.driver-class-name: com.mysql.jdbc.Driver
 ```
- After inserting that to the file, copy that file into the src/test directory.(Remember to adjust the values to point 
    to your test database)
- Add your prepared statements to the implementation file *JdbcTemplateImpl*. They follow the following format: 
``` java
    private static final String INSERT_MOTO_SQL =
            "insert into motorcycle (vin, make, model, year, color) values (?, ?, ?, ?, ?)";

    private static final String SELECT_MOTO_SQL =
            "select * from motorcycle where id = ?";

    private static final String SELECT_ALL_MOTOS_SQL =
            "select * from motorcycle";

    private static final String DELETE_MOTO_SQL =
            "delete from motorcycle where id = ?";

    private static final String UPDATE_MOTO_SQL =
            "update motorcycle set vin = ?, make = ?, model = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_MOTOS_BY_MAKE_SQL =
            "select * from motorcycle where make = ?";
```





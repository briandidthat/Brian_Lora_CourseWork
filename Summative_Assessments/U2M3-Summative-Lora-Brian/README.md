# U2 M3 Summative Assessment

The purpose of this assessment is for you to demonstrate your ability to apply Spring security to an existing application and deploy it to PWS.

## Requirements

This assessment is based on the Game Store Capstone Project that you completed for Unit 1. If you were unable to complete any of the features of that project, you must complete them before beginning this assessment.

### Security Rules

Apply the following security rules to your Game Store application:

* Searching:
  * Any user (both authenticated and unauthenticated) can search for products.
* Updates:
  * Any staff member can update a product.
* Create:
  * Only Managers and above can create new products.
* Delete
  * Only Admin users can delete a product.

### Users

You are responsible for creating users and assigning roles so that you can verify your security configuration.


```sql
create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));
	create unique index ix_auth_username on authorities (username,authority
);


```


### Deployment

After implementing the above changes and verifying that they work locally you must deploy your application to PWS and demonstrate that it is working on that platform.


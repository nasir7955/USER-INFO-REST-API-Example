## Quick Look

* SpringBoot
* JDK 1.8
* Maven
* H2 Database
* Http Rest API


&nbsp; 


## Getting started
- 'UserService' module has one module which provides service to:
    - add a new user
    - update existing user
    - delete existing user
    - update user picture
    - delete user picture


&nbsp; 

## API Contract:
- add new user: 
    #End point /user/info/user
  - Alls fields are mandatory except image
    {
    	"userName":"",
    	"firstName":"",
    	"lastName":"",
    	"email": "@.",
    	"phoneNo": "8888888888",
    	"password": "123",
    	"image": "ab"
    	
    }
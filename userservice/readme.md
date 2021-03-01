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
- add new user 
    #End point: POST /users/info/v1/user
  - All fields are mandatory except image, image is binary data
    - Request body:
    - {
    	"userName":"nas158",
    	"firstName":"Naz",
    	"lastName":"K",
    	"email": "test@test.com",
    	"phoneNo": "8888888888",
    	"password": "123",
    	"image": "abcdef123"
    	
    }
    - Response
        - code: 201 for success
        - Response body:
            - {
              "userName":"nas158",
              "message":" Was Added",
              "timeStamp":"2021-02-28T17:22:45.777"
              }
- Update user
    - End Point:PUT /users/info/v1/updateuser 
    - Requst body:
    - {
      "userName":"nas158",
      "firstName":"Naz",
      "lastName":"Kh",
      "email": "test2@test.com",
      "phoneNo": "8888888888",
      "password": "1233",
      "image": "abcdef12rrrer3"

    }
  - Response
  - code: 200 for success
  - Response body:
   - {
      "userName":"nas158",
      "message":" Was Updated",
      "timeStamp":"2021-02-28T17:24:45.777"
      }

- Delete User
    - End Point: DELETE /users/info/v1/delete/{id}
    - Request body: none
    - Response body: code 200
      - {
        "userName":"nas158",
        "message":" Was Deleted",
        "timeStamp":"2021-02-28T21:24:04.208"
        }
    
    
- Disply All users:
    - end point: GET /users/info/v1/users_inquiry
    - Request none
    - Response body:
        - [ {
          "userName":"nas158",
          "firstName":"Naz",
          "lastName":"Kh",
          "email": "test2@test.com",
          "phoneNo": "8888888888",
          "password": "1233",
          "image": "abcdef12rrrer3",
          "userName":"nas795",
          "firstName":"Naz",
          "lastName":"Kh",
          "email": "test2@test.com",
          "phoneNo": "8888888888",
          "password": "1233",
          "image": "abcdef12rrrer3"
          ]

  }
    
      
    
    

        
    
    
    
    
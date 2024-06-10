## Setup Instructions

To set up the backend of the Book Social Network project, follow these steps:
1. Clone the repository:

```bash
   git clone https://github.com/PhuNguyenPT/Shopping_Cart.git
```

2. Run the docker-compose file in a terminal

```bash
   docker-compose up -d
```
3. Install dependencies (assuming Maven is installed) in a second terminal:

```bash
   mvn clean install
```
4. Run the application in the second terminal

```bash
   java -jar target/shopping-cart-api-0.0.1-SNAPSHOT.jar
```
5. Run Postman and send to the register api by POST

```bash
   https://localhost:443/api/v1/auth/register
```

example in body:
```bash
{
    "firstName": "firstname",
    "lastName": "lastname",
    "email": "test@gmail.com",
    "password": "password"
}
```
6. Use a browser to access to mail server at the URL
    
```bash
   http://localhost:1080
```

7. Copy the 6-digit activation code and send to the activate-account api by GET

```bash
   https://localhost:443/api/v1/auth/activate-account?token=value
```
// Replace the value with the actual 6-digit activation code

8. Login to the account by POST

```bash
https://localhost:443/api/v1/auth/login
```

example in body

```bash
{
    "email": "test@gmail.com",
    "password": "password"
}
```


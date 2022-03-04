## Spring Boot Book Store

### Endpoints

#### Sign-up
```
GET /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
"username" : "username",
"password" : "123456",
"name" : "User"
}
```

#### Sign-in
```
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username" : "username",
    "password" : "123456"
}
```

#### Make-admin
```
PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey1234!
```

#### Save Book
```
POST /api/books HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...
Content-Type: application/json
Content-Length: 134

{
    "title" : "Homo Deus",
    "descrption" : "Yarinin kisa bir tarihi",
    "author" : "Yuval Noah Harari",
    "price" : 24
}
```

#### Delete Book
```
DELETE /api/books/2 HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...
```

#### Get All Books
```
GET /api/books HTTP/1.1
Host: localhost:8080
```

#### Save Purchase
```
POST /api/purchases HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...
Content-Type: application/json
Content-Length: 60

{
    "userId" : 1,
    "bookId" : 1,
    "price" : 32
}
```

#### Get User Purchase
```
GET /api/purchases HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...
```

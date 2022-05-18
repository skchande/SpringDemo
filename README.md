

# Person

## Post:
http://localhost:8080/api/v1/person
```JSON
{
    "name": "NewPerson",
    "dateOfBirth": "2000-12-31",
    "email": "person@test.com"
}
```

## Delete:
http://localhost:8080/api/v1/person/3

## Update:
http://localhost:8080/api/v1/person/3?name=Kasper&eMail=Kasper@kasper.it


# Product

## Post:
http://localhost:8080/api/v1/product
```JSON
{
    "name": "Beans",
    "price": "2.99"
}
```


# Purchase

## Post:
http://localhost:8080/api/v1/purchase
```JSON
{
    "productName": "Bean",
    "orderNumber": "NBAEW",
    "buyerName": "Person"
}
```
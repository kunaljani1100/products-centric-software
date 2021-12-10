**Products API**

The Products API is a tool that can be used to insert product details into the database and return product details into the database.

**Testing the API**
Clone the repository and open it using Intellij IDEA. Run the code and open Postman to test the API.

**Sample Postman request to add a sample to the database.**

URL: http://localhost:8080/v1/products
Method: POST
Body: 

{
    "name": "Red Shirt",
    "description": "Red hugo boss shirt.",
    "brand": "Hugo boss",
    "tags": [
        "red",
        "shirt",
        "slim fit"
    ],
    "category": "apparel"
}

**Sample Postman request to get paginated samples from the database.**

URL: http://localhost:8080/v1/products/categories
Method: POST
Body:

{
    "category": "apparel",
    "pageNumber": 1,
    "maxEntries": 3
}

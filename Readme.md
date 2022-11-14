
Postman Link :


########################### For Token-Service ##########################

## To Getting Token

	Method: GET
	Endpoint: consumer/get-token/{id}

##################################################################

########################### For Admin-Service ##########################

## To SignUp For Service.
	Method: POST
        Endpoint: consumer/signup
	Payload: 
	{   
            "username": "USERNAME", 
            "password": "PASSWORD", 
            "confirm_password": "PASSWORD", 
            "email": "OPTIONAL_EMAIL" 
    }

## To Login For Service.
	Method: POST
    Endpoint: consumer/login
	Payload: 
	{   
            "username": "USERNAME", 
            "password": "PASSWORD"
    }

## To Check All User.
	Method: GET
    Endpoint: consumer/get-users

##################################################################

########################### For Shop-Service ##########################

## To Getting Product or Category From Shop.
	Method: GET
    Endpoint: shop/products (or) shop/categories 


## To Getting Product or Category By Field From Shop.
	Method: POST
	Endpoint: shop/products (or) shop/categories
	Payload: { "FIELD_NAME": "VALUE" }
	allowed fields : description OR name OR id Or cate_name or price

##################################################################


################# For Shop Management-Service #################
## LINK PRODUCT WITH CATEGORY
    METHOD: PUT
    Endpoint: consumer/shop-management/product-with-category/{product_id}/{category_id}


## To Getting Product or Category From Shop Management.
	Method: GET
    Endpoint: consumer/shop-management/categories
                            (or)
		      consumer/shop-management/categories

## To Add Product or Category From Shop Management.
	Method: POST
    Endpoint: consumer/shop-management/add-product
                            (or)
		      consumer/shop-management/add-category

	PAYLOAD : { "name": "value", "price": "value", "description": "value" }
                            (or)
              { "name": "value", description": "value" }
                            (or)
		      { List of products -> see sample-products.json }

## UPDATE Product or Category From Shop Management.
	Method: POST
    Endpoint: consumer/shop-management/update-product-by-id/{id}
                            (or)
		      consumer/shop-management/update-category-by-id/{id}

    PAYLOAD : { “FIELD_NAME” : VALUE }
    allowed fields ->  description OR name OR id OR price 
                            (or)
			   description OR name

## DELETE Product or Category From Shop Management.
	Method: DELETE
    Endpoint: consumer/shop-management/delete-product-by-id/{id}
                            (or)
    consumer/shop-management/delete-category-by-id/{id}

##################################################################
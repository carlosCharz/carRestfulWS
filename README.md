carRestfulWS
============

A car restful WS. 

Technologies: 

1.springws

2.mybatis

3.mysql

Methods:

1. 	/* Get list of cars */
    HTTP Method: GET
	  http://localhost:8080/carRestfulWS/car/list

2. 	/* Get a car */
    HTTP Method: GET
    http://localhost:8080/carRestfulWS/car/1 

3. /* Create a car */
   HTTP Method: POST
	 http://localhost:8080/carRestfulWS/car/create 
	 {"model": "Yaris2","year": 2014,"manufacturer": "Toyota","country": "Japan"}

4. /* Update a car */
   HTTP Method: PUT
   http://localhost:8080/carRestfulWS/car/6 
   {"model": "Yaris3","year": 2015,"manufacturer": "Toyota","country": "Japan"}

5. /* Delete a car */
   HTTP Method: DELETE
   http://localhost:8080/carRestfulWS/car/6

# Ride-Rating

This project is a basic implementaion of how a rating service works.

# Assumptions:
  Host : Ride Driver, Customer : Ride Customer 
  1. The order are managed by a separate service. So is the database.
  2. There is no concurrency issue when both host and customer are rating other.
  3. The API's are called with some information that is necessary for the use case designed, We can tweak the API's to increase or decrease data in them.


# Approach to solution
  
The solution has been designed as a part of multiple serivces that handle a single order i.e. ride, When a order is created, We have following information order id, cutomer id, host id etc. We also have a ratings table which stores ratings given to each other by both host and customer corresponding to a order. Now we have 4  basic API's supported by Service.

  1. Create a new Rating: This API is is used when a user (can be customer or a host) requests to add rating for any order. The API requires UserType(to determine        whether Host or Customer), Rating, Order Id corresponding to which the rating has to be created.
  
  2. Update a Rating: This API is used for updating existing ratings done by a user. This is also used when a either host or customer has already rated and the          other one comes to rate.
  
  3. Get Ratings Achieved:  Api is used to get Ratings achieved by the user from other user corresponding to a order.
  
  4. Get Aggregated Ratings of a User: API is used to get aggregated Rating achieved by a user for all orders made.
  
  
  # DB Schema
  
      CREATE TABLE ratings
    ( id  int NOT NULL,
      order_id  int NOT NULL,
      customer_id int NOT NULL,
      host_id int NOT NULL,
      customer_rating int NOT NULL,
      host_rating int NOT NULL,
      PRIMARY KEY (id),
      FOREIGN KEY (order_id) REFERENCES Order(id)
    );

    CREATE TABLE user_data
    ( id  int NOT NULL,
      user_name VARCHAR(30) NOT NULL,
      CONSTRAINT user_data_pk PRIMARY KEY (id)
    );

# Steps to Run
  
  Requires JDK 8 installed
  
  1. Clone the repository and mvn clean install in the folder ride-rating
  
  2. Build and Run the program.
  
  3. Go to http://localhost:8080/ratings This is the base URL for the project.
  
  4. Choose API and Post Data accordingly.


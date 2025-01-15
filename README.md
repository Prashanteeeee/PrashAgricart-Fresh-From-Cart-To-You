Agricart - Fresh Seasonal Produce Platform
Agricart is a web-based platform that allows customers to purchase fresh, seasonal fruits and vegetables directly from farmers, avoiding preservatives and ensuring that the products are healthy and tasty. Farmers are also able to receive fair prices for their produce.

Features
User Registration & Login: Customers can sign up and log in to their accounts.
Browse Products: Customers can browse available seasonal fruits and vegetables.
Place Orders: Customers can place orders for products and track order history.
Admin Panel: Admins can manage users and products.
Technologies Used
Frontend:
HTML, CSS, JavaScript
Bootstrap (for responsive UI)
Backend:
Java (JSP)
Spring Boot
JDBC (for database interaction)
Database:
MySQL
Testing:
JUnit 5 (for unit tests)
Other:
Maven (for project management)
Prerequisites
Before you begin, ensure you have the following installed:

Java Development Kit (JDK) 8 or above
MySQL Database installed and running
Maven for project management
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/agricart.git
Set up the MySQL Database:

Create a database named Agricart and configure the database credentials in the UserDAO.java class.
Install dependencies:

Navigate to the project directory and run:
bash
Copy code
mvn install
Run the application:

You can run the application using your IDE or by executing the following Maven command:
bash
Copy code
mvn spring-boot:run
Access the application:

Open your browser and go to http://localhost:8080 to access the platform.
Usage
User Registration:

Navigate to the registration page, fill out the required details, and click "Register".
Login:

After registration, log in with your credentials to access the product catalog and place orders.
Admin Panel:

Admins can log in and manage users and products via the admin dashboard.
Running Tests
To run the unit tests for the project (JUnit 5):

bash
Copy code
mvn test
Project Structure
bash
Copy code
agricart/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── user/
│   │   │   │   │   ├── dao/       # Data Access Objects (UserDAO, etc.)
│   │   │   │   │   ├── model/     # Model classes (User, Product, etc.)
│   │   │   │   │   └── controller/ # Controllers (Servlets, JSP)
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── com/
│       │   │   └── user/           # Test cases (JUnit)
│       └── resources/
└── pom.xml                         # Maven configuration
License
This project is licensed under the MIT License - see the LICENSE.md file for details.

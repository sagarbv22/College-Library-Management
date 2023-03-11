# College-Library-Management


High level design of Library Management System.
===============================================

User Management:
User Registration
User Login
User Profile Management

Book Management:
Add/Update/Delete Books
Search Books
Overdue Books
View Books
Check-In/Check-Out Books

Member Management:
Add/Update/Delete Members
Search Members
View Members

System Management:
Database Management

Security:
User Authentication
User Authorization
Password Management

Low level design of Library Management system
===============================================
User Management:
User Registration: User provides basic details like name, email, and password. A new record is created in the user table with a unique ID, and the details are stored in the user profile.
User Login: User provides username and password, which is verified against the database. If the details are correct, a session ID is generated and stored in the session table.

Book Management:
Add/Update/Delete Books: Admin can add, update, or delete books. When adding a new book, admin provides details like title, author, ID. A new record is created in the book table with a unique ID, and the details are stored in the book details table.
Search Books: Users can search books by title, author, or Id. The search query is executed against the book details table.
View Books: Users can view book details like title, author, ID. The details are fetched from the book details table.
 overdue-Books: A report is generated that displays all books that are overdue for return.
Check-In/Check-Out Books: When a user checks out a book, a new record is created in the checkout table with the book ID, user ID, and checkout date. When a user returns a book, the record is updated with the return date.

Member Management:
Add/Update/Delete users: Admin can add, update, or delete users. When adding a new user, admin provides details like name, email, and address. A new record is created in the user table with a unique ID, and the details are stored in the user details table.
Search user: user can be searched using Id by querying from database.


Database Management: Admin can create, update or delete tables, views or stored procedures as per requirement.

Security:
User Authentication: Passwords are hashed and stored in the database. When a user logs in, the entered password is hashed and compared against the hashed password stored in the database.
User Authorization: Different user roles can be defined like admin or member, with different levels of access.



Architecture
============
Presentation Layer: This layer is responsible for handling the user interface and user interactions. It includes the web pages, forms, and other elements that users interact with when using the system. The presentation layer communicates with the business logic layer to retrieve and display data.

Business Logic Layer: This layer contains the business logic of the system. It handles the application flow, data validation, and other business rules. The business logic layer communicates with the data access layer to retrieve and update data.

Data Access Layer: This layer is responsible for accessing the database and retrieving or updating data. It includes the database schema, stored procedures, and other database-related elements. The data access layer communicates with the business logic layer to retrieve and update data.

Database: This layer contains the actual data stored in the system. It includes the user data, book data, and other system-related data. The database communicates with the data access layer to store and retrieve data.

Regarding user authorization, here's an architecture:

Authentication Module: This module handles user authentication. When a user logs in, the entered password is hashed and compared against the hashed password stored in the database. If the passwords match, a session ID is generated and stored in the session table.

Authorization Module: This module handles user authorization. Different user roles can be defined like admin or member, with different levels of access. When a user logs in, their role is checked, and they are granted access to the appropriate features based on their role.

Access Control Module: This module handles access control. It ensures that users can only access the features they are authorized to access based on their role. If a user tries to access a feature they are not authorized to access, they are denied access.

User Management Module: This module handles user management. It allows administrators to create, update, or delete user accounts, as well as define user roles and permissions.


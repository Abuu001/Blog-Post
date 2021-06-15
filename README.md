# Backend REST Api for Blog-Post
# Technologies used
-Java(spring boot)
-SQL(postgres)

# How to Run
1. open terminal type commands --> psql -U (username) -h localhost 
2. enter password then change directory to spring security database. (to connect to the db)

# API's Endpoints

-The APIs for the blog are :
1.    (blog post endpoints)
2.  /api/v1/blogs/post (to create a blog post)
3.  /api/v1/blogs/all (to view all blogs posted)
4.  /api/v1/blogs/remove/{blogId}  (to delete a blog)
5.  /api/v1/blogs/find/{blogId}   (to find a specific blog)
6.  /api/v1/blogs/update/{blogId}  (to update a specific blog)
     (users endpoints)
7.  /api/v1/user/save (api to reqister a user)
8.  /api/v1/user/login (api route to login)


# Hint
- For the users there are 2 types of roles : ADMIN and USER
- ADMIN can perform all CRUD operations like create,read,update and delete
- USERS can only read data(blogs) but doesnt have previledges to create,delete,update ..
- Once a person registers with username and password they are given a JWT token which identifies them.

# Assumptions 
-Only registered users can become ADMINS and can perform crud operations
-When you have not registered , you become a USER

# Other
You can find the screenshots of the apis in Postman Images in the git hub directory https://github.com/Abuu001/Blog-Post/tree/main/Postman%20Images




 



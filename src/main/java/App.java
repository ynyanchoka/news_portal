import dao.Sql2oDepartmentDao;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import exceptions.ApiException;
import models.Department;
import models.DepartmentNews;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    private static Sql2o sql2o;

    public static void main(String[] args) {
        port(8080);

        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Sql2oDepartmentNewsDao departmentNewsDao;

        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/newsportal";
        Sql2o sql2o = new Sql2o(connectionString, null, null);

        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        departmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();


        //department
//post new department
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

//get department by id
        get("/department/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No departments with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });
//get all departments
        get("/department", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());

            if (departmentDao.getAll().size() > 0) {
                return gson.toJson(departmentDao.getAll());
            } else {
                return "{\"message\":\"I'm sorry, but no departments are available.\"}";
            }

        });



        //user
        //post new user
        post("/user/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });

        //get all users
        get("/user", "application/json", (req, res) -> {
            System.out.println(userDao.getAllUsers());

            if (userDao.getAllUsers().size() > 0) {
                return gson.toJson(userDao.getAllUsers());
            } else {
                return "{\"message\":\"I'm sorry, but no users are available.\"}";
            }

        });
        //get users by id

        get("/user/:id", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("id"));
            User userToFind = userDao.findById(userId);
            if (userToFind == null) {
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(userToFind);
        });


        get("/department/:id/user", "application/json", (req, res) -> {
            int department_id = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(department_id);
            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            } else if (departmentDao.getAllUsersInDepartment(department_id).size() == 0) {
                return "{\"message\":\"I'm sorry, but no users are listed for this department.\"}";
            } else {
                return gson.toJson(departmentDao.getAllUsersInDepartment(department_id));
            }
        });



        //news

        //post general news

        post("/news/new/general","application/json",(request, response) -> {
            News news =gson.fromJson(request.body(),News.class);
            news.setCreatedat();
            news.setFormattedCreatedAt();
            newsDao.add(news);
            response.status(201);
            return gson.toJson(news);
        });
        //get general news
        get("/news/general","application/json",(request, response) -> {
            if(newsDao.getAllNews().size()>0){
                return gson.toJson(newsDao.getAllNews());
            }
            else {
                return "{\"message\":\"I'm sorry, but no news is available currently.\"}";
            }
        });


//post department news

        post("/department/:id/news/new","application/json",(request, response) -> {

            int id = Integer.parseInt(request.params("id"));
            DepartmentNews departmentNews = gson.fromJson(request.body(),DepartmentNews.class);
            departmentNews.setCreatedat();
            departmentNews.setFormattedCreatedAt();
            departmentNews.setDepartmentId(id);
            departmentNewsDao.add(departmentNews);
            response.status(200);
            return  gson.toJson(departmentNews) ;

        });


//       get departmental news

        get("/department/:id/news","application/json",(request, response) -> {
            if(departmentNewsDao.getAllDepartmentNews().size()>0){
                return gson.toJson(departmentNewsDao.getAllDepartmentNews());
            }
            else {
                return "{\"message\":\"I'm sorry, but no news are currently available.\"}";
            }
        });



        // FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });




    }
}
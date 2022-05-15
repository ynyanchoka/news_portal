package interfaces;

import models.DepartmentNews;
import models.News;

import java.util.List;

public interface DepartmentNewsDao {
    //Create
    void add(DepartmentNews departmentNews);

    //Read

    List<DepartmentNews> getAllDepartmentNews();
    News findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllDepartmentNews();
}

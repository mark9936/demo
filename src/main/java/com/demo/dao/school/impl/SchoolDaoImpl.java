package com.demo.dao.school.impl;

import com.demo.dao.AbstractDao;
import com.demo.dao.school.SchoolDao;
import com.demo.model.school.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolDaoImpl extends AbstractDao implements SchoolDao {

    @Override
    public List<Student> findBySpecificGPA(double start, double end) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sb.append(" SELECT * ");
        sb.append(" FROM Student ");
        sb.append(" WHERE StudentGPA >= :start AND StudentGPA <= :end ");

        params.put("start", start);
        params.put("end", end);
        Query query = schoolEntityManager.createNativeQuery(sb.toString(), Student.class);
        params.forEach(query::setParameter);
        return query.getResultList();
    }
}

package com.demo.dao.school.impl;

import com.demo.dao.school.SchoolDao;
import com.demo.model.school.Student;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/** SchoolDao 的實作，示範如何使用 EntityManager 執行 JPQL。 */
@Repository
public class SchoolDaoImpl implements SchoolDao {

    /**
     * {@link PersistenceContext} 會注入由 JPA 管理的 EntityManager。
     * EntityManager 負責建立 JPQL 查詢與和資料庫溝通。
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findByGpaBetween(double minGpa, double maxGpa) {
        String jpql = "SELECT s FROM Student s " +
                "WHERE s.studentGpa >= :minGpa AND s.studentGpa <= :maxGpa";
        TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
        query.setParameter("minGpa", minGpa);
        query.setParameter("maxGpa", maxGpa);
        return query.getResultList();
    }

    /**
     * 使用 StringBuilder 依照非空參數加入 JPQL 條件。
     *
     * <p>JPQL 字串只組合固定的欄位與條件，使用者輸入則透過
     * {@link TypedQuery#setParameter(String, Object)} 傳入，避免把輸入值直接串接進 JPQL。</p>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> search(String studentName, Double minGpa, Double maxGpa) {
        StringBuilder jpql = new StringBuilder("SELECT s FROM Student s WHERE 1 = 1");
        boolean hasStudentName = studentName != null && !studentName.trim().isEmpty();

        // WHERE 1 = 1 永遠成立，後續每個可選條件都可以統一使用 AND 串接。
        if (hasStudentName) {
            jpql.append(" AND LOWER(s.studentName) LIKE :studentName");
        }
        if (minGpa != null) {
            jpql.append(" AND s.studentGpa >= :minGpa");
        }
        if (maxGpa != null) {
            jpql.append(" AND s.studentGpa <= :maxGpa");
        }
        jpql.append(" ORDER BY s.studentId ASC");

        TypedQuery<Student> query = entityManager.createQuery(jpql.toString(), Student.class);
        if (hasStudentName) {
            query.setParameter(
                    "studentName",
                    "%" + studentName.trim().toLowerCase(Locale.ROOT) + "%");
        }
        if (minGpa != null) {
            query.setParameter("minGpa", minGpa);
        }
        if (maxGpa != null) {
            query.setParameter("maxGpa", maxGpa);
        }
        return query.getResultList();
    }
}

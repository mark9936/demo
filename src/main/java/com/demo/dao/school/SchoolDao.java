package com.demo.dao.school;

import com.demo.model.school.Student;
import java.util.List;

/**
 * 自訂資料庫查詢的 DAO 介面。
 *
 * <p>Repository 適合常見 CRUD；當查詢需要自己撰寫 JPQL 時，可以放在 DAO
 * 介面與實作中。本專案保留固定 GPA 查詢與多條件動態搜尋作為學習範例。</p>
 */
public interface SchoolDao {

    /**
     * 查詢 GPA 位於指定範圍內的學生。
     *
     * @param minGpa 最低 GPA
     * @param maxGpa 最高 GPA
     * @return 符合條件的學生
     */
    List<Student> findByGpaBetween(double minGpa, double maxGpa);

    /**
     * 依照使用者有提供的條件動態搜尋學生。
     *
     * <p>{@link Double} 可以保存 {@code null}，用來表示「未提供這個條件」；
     * 如果改用基本型別 {@code double}，參數就一定會有數值，無法區分是否省略。</p>
     *
     * @param studentName 學生姓名關鍵字；null 或空白表示不限制姓名
     * @param minGpa 最低 GPA；null 表示不設定下限
     * @param maxGpa 最高 GPA；null 表示不設定上限
     * @return 符合所有已提供條件的學生；未提供條件時回傳全部學生
     */
    List<Student> search(String studentName, Double minGpa, Double maxGpa);
}

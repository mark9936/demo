package com.demo.repository.school;

import com.demo.model.school.Buildings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Buildings 的資料存取介面。
 *
 * <p>繼承 {@link JpaRepository} 後，Spring Data JPA 會自動提供 findAll、
 * findById、save、deleteById 等常用 CRUD 方法，不需要自行撰寫 SQL。</p>
 */
public interface BuildingsRepository extends JpaRepository<Buildings, Integer> {
}

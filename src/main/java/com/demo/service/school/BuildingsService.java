package com.demo.service.school;

import com.demo.model.school.Buildings;
import java.util.List;

/** Buildings 的商業邏輯介面。Service interface 讓 Controller 不必依賴實作細節。 */
public interface BuildingsService {

    List<Buildings> findAll();

    Buildings findById(Integer id);

    Buildings create(Buildings buildings);

    Buildings update(Integer id, Buildings buildings);

    void delete(Integer id);
}

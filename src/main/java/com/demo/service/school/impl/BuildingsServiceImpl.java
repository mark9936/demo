package com.demo.service.school.impl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.school.Buildings;
import com.demo.repository.school.BuildingsRepository;
import com.demo.service.school.BuildingsService;
import java.util.List;
import org.springframework.stereotype.Service;

/** BuildingsService 的實作，負責把請求交給 Repository。 */
@Service
public class BuildingsServiceImpl implements BuildingsService {

    private final BuildingsRepository repository;

    /** 單一建構子會由 Spring 自動注入 Repository，不需要再寫 @Autowired。 */
    public BuildingsServiceImpl(BuildingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Buildings> findAll() {
        return repository.findAll();
    }

    @Override
    public Buildings findById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("找不到 Building，id=" + id));
    }

    @Override
    public Buildings create(Buildings buildings) {
        return repository.save(buildings);
    }

    @Override
    public Buildings update(Integer id, Buildings buildings) {
        findById(id);
        buildings.setBuildingId(id);
        return repository.save(buildings);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}

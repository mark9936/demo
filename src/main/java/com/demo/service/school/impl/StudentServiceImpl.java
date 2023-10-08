package com.demo.service.school.impl;

import com.demo.bean.school.StudentBean;
import com.demo.dao.school.SchoolDao;
import com.demo.mapper.school.StudentMapper;
import com.demo.mapstruct.MapStructService;
import com.demo.repository.school.StudentRepository;
import com.demo.service.school.StudentService;
import com.demo.util.ErrorMessageEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Function: StudentServiceImpl.java
 * @Description: Student ServiceImpl
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MapStructService mapStructService;

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentBean findById(Integer id) {
        return mapStructService.mapToBean(
                studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                        ErrorMessageEnum.NO_DATA.getValue())), StudentMapper.class);
    }

    @Override
    public List<StudentBean> findAll() {
        return mapStructService.mapAsListToBean(studentRepository.findAll(), StudentMapper.class);
    }

    @Override
    public List<StudentBean> findBySpecificGPA(double start, double end) {
        return mapStructService.mapAsListToBean(schoolDao.findBySpecificGPA(start, end),
                StudentMapper.class);
    }
}

package com.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.model.school.Student;
import com.demo.repository.school.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Spring Boot 整合測試。
 *
 * <p>{@link SpringBootTest} 會啟動完整 Spring Context，
 * {@link AutoConfigureMockMvc} 則讓測試可以模擬 HTTP 請求而不必真的開瀏覽器。</p>
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    private static final int TEST_STUDENT_ID = 99;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void removeTestData() {
        studentRepository.findById(TEST_STUDENT_ID).ifPresent(studentRepository::delete);
    }

    @Test
    void contextLoads() {
        // 如果 Spring Context 無法建立，測試會在進入這裡前失敗。
    }

    @Test
    void studentCrudShouldWork() throws Exception {
        String createJson = "{"
                + "\"studentId\":99,"
                + "\"studentGpa\":3.8,"
                + "\"studentName\":\"New Student\","
                + "\"personId\":1"
                + "}";

        mockMvc.perform(post("/api/students")
                        .contentType(APPLICATION_JSON)
                        .content(createJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.studentId").value(TEST_STUDENT_ID));

        mockMvc.perform(get("/api/students/{id}", TEST_STUDENT_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("New Student"));

        String updateJson = "{"
                + "\"studentGpa\":4.0,"
                + "\"studentName\":\"Updated Student\","
                + "\"personId\":1"
                + "}";

        mockMvc.perform(put("/api/students/{id}", TEST_STUDENT_ID)
                        .contentType(APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentId").value(TEST_STUDENT_ID))
                .andExpect(jsonPath("$.studentName").value("Updated Student"));

        mockMvc.perform(delete("/api/students/{id}", TEST_STUDENT_ID))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/students/{id}", TEST_STUDENT_ID))
                .andExpect(status().isNotFound());
    }

    @Test
    void studentGpaQueryShouldReturnMatchingStudents() throws Exception {
        mockMvc.perform(get("/api/students/gpa")
                        .param("minGpa", "3.5")
                        .param("maxGpa", "4.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void invalidGpaRangeShouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/api/students/gpa")
                        .param("minGpa", "4.0")
                        .param("maxGpa", "3.0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void dynamicStudentSearchShouldSupportOptionalConditions() throws Exception {
        // 姓名不分大小寫且只比對部分文字；maxGpa 可以省略。
        mockMvc.perform(get("/api/students/search")
                        .param("studentName", "rYaN")
                        .param("minGpa", "3.5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].studentId").value(1));

        // 也可以只提供 GPA 上限。
        mockMvc.perform(get("/api/students/search")
                        .param("maxGpa", "3.5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].studentId").value(2));

        // 三個條件都省略時，應回傳全部學生。
        mockMvc.perform(get("/api/students/search"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void invalidDynamicSearchGpaRangeShouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/api/students/search")
                        .param("minGpa", "4.0")
                        .param("maxGpa", "3.0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void repositoryCanReadSeedData() {
        Student student = studentRepository.findById(1).orElse(null);

        org.junit.jupiter.api.Assertions.assertNotNull(student);
        org.junit.jupiter.api.Assertions.assertEquals("Jerry Ryan", student.getStudentName());
    }
}

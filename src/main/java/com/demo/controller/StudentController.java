package com.demo.controller;

import com.demo.model.school.Student;
import com.demo.service.school.StudentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student REST Controller。
 *
 * <p>{@link RestController} 會把方法回傳的 Java 物件自動轉成 JSON。
 * {@link RequestMapping} 設定這個 Controller 共用的 URL 前綴，
 * 其餘 Mapping annotation 再指定 HTTP 方法與路徑。</p>
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    /** 建構子注入可讓相依物件明確且方便測試。 */
    public StudentController(StudentService service) {
        this.service = service;
    }

    /** {@link GetMapping} 對應 HTTP GET，通常用來讀取資料。 */
    @GetMapping
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    /** {@link PostMapping} 對應 HTTP POST，{@link RequestBody} 會把 JSON 轉成 Student。 */
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(student));
    }

    /** {@link PutMapping} 對應 HTTP PUT，通常用來完整更新一筆資料。 */
    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Integer id, @RequestBody Student student) {
        return service.update(id, student);
    }

    /** {@link DeleteMapping} 對應 HTTP DELETE。204 表示刪除成功且沒有回應內容。 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * DAO 自訂查詢範例：GET /api/students/gpa?minGpa=3.0&maxGpa=4.0。
     */
    @GetMapping("/gpa")
    public ResponseEntity<List<Student>> findByGpa(
            @RequestParam("minGpa") double minGpa,
            @RequestParam("maxGpa") double maxGpa) {
        if (minGpa > maxGpa) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.findByGpaBetween(minGpa, maxGpa));
    }

    /**
     * 多條件動態搜尋範例：
     * GET /api/students/search?studentName=ryan&amp;minGpa=3.0&amp;maxGpa=4.0。
     *
     * <p>{@code required = false} 表示 Query String 可以省略該參數。
     * GPA 使用 {@link Double} 而不是 {@code double}，因此未提供時可以接收 null。</p>
     */
    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(
            @RequestParam(value = "studentName", required = false) String studentName,
            @RequestParam(value = "minGpa", required = false) Double minGpa,
            @RequestParam(value = "maxGpa", required = false) Double maxGpa) {
        if (minGpa != null && maxGpa != null && minGpa.doubleValue() > maxGpa.doubleValue()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.search(studentName, minGpa, maxGpa));
    }
}

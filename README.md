# Spring Boot 基本 CRUD 教學

這是一個給 Java/Spring Boot 初學者閱讀的 REST API 範例。專案以學校資料為主題，
保留常見的 `Controller → Service → Repository/DAO → Database` 分層，並提供
School 資料的基本 CRUD。

本分支名稱是 `feature/springboot-basic-crud-tutorial`。

## 1. 執行環境

- JDK 8 以上（本專案使用 Java 8 語法）
- Maven 3.6 以上；也可以直接使用專案內的 Maven Wrapper
- 不需要另外安裝 MySQL 或 SQL Server

本專案使用 H2 記憶體資料庫。應用程式啟動時會建立資料表並執行
`src/main/resources/data.sql`，所以下載專案後即可執行。

## 2. 啟動專案

Windows PowerShell：

```powershell
.\mvnw.cmd spring-boot:run
```

執行測試：

```powershell
.\mvnw.cmd test
```

也可以先打包，再執行產生的 JAR：

```powershell
.\mvnw.cmd clean package
java -jar target/springboot-basic-crud-0.0.1-SNAPSHOT.jar
```

啟動後的 API 位址是 `http://localhost:8080`。

## 3. 專案結構

```text
src/main/java/com/demo
├── Application.java                 # Spring Boot 啟動點
├── controller/                      # 接收 HTTP 請求、回傳 HTTP 回應
├── service/                         # 定義商業流程
│   └── school/
│       └── impl/                    # Service interface 的實作
├── repository/                      # Spring Data JPA 的一般 CRUD
├── dao/                             # 固定與多條件動態 JPQL 查詢範例
├── model/school/                    # JPA Entity，同時是本範例的 POJO
└── exception/                       # 找不到資料時的例外
```

測試程式分開放在 `src/test/java`：

```text
src/test/java/com/demo
├── DemoApplicationTests.java                       # 啟動 Spring 與 H2 的整合測試
├── controller/StudentControllerTest.java           # Controller 單元測試
└── service/school/impl/StudentServiceImplTest.java # Service 單元測試
```

一次讀取學生資料的流程如下：

```text
HTTP GET /api/students/1
        ↓
StudentController
        ↓
StudentService / StudentServiceImpl
        ↓
StudentRepository
        ↓
H2 Database
```

### 各層的責任

| 層 | 工作 | 初學者可以先記住的重點 |
|---|---|---|
| Controller | 處理 URL、HTTP 方法與 JSON | 不直接寫資料庫程式 |
| Service | 放置商業規則與流程 | Controller 呼叫 Service |
| Repository | 提供一般 CRUD | `JpaRepository` 已經提供常用方法 |
| DAO | 放自訂查詢 | 本專案以 GPA 範圍與多條件搜尋示範 JPQL |
| Model/POJO | 保存資料欄位 | `@Entity` 讓 JPA 知道如何對應資料表 |

## 4. CRUD API

所有 School 資料都提供相同的五個基本 API。`{id}` 代表該資料的主鍵。

| HTTP 方法 | URL | 用途 | 成功狀態碼 |
|---|---|---|---|
| GET | `/api/students` | 取得全部學生 | 200 |
| GET | `/api/students/{id}` | 取得單一學生 | 200 |
| POST | `/api/students` | 新增學生 | 201 |
| PUT | `/api/students/{id}` | 更新學生 | 200 |
| DELETE | `/api/students/{id}` | 刪除學生 | 204 |

其他資源的 URL 如下：

- `/api/buildings`
- `/api/classrooms`
- `/api/colleges`
- `/api/courses`
- `/api/faculties`
- `/api/interns`
- `/api/persons`
- `/api/sections`
- `/api/textbooks`

### API 範例

取得全部學生：

```text
GET http://localhost:8080/api/students
```

新增學生：

```http
POST http://localhost:8080/api/students
Content-Type: application/json

{
  "studentId": 99,
  "studentGpa": 3.8,
  "studentName": "New Student",
  "personId": 1
}
```

更新學生時，URL 的 ID 會被當成真正的主鍵；即使 JSON 內沒有 studentId，
Service 也會使用 URL 的 ID：

```http
PUT http://localhost:8080/api/students/99
Content-Type: application/json

{
  "studentGpa": 4.0,
  "studentName": "Updated Student",
  "personId": 1
}
```

刪除學生：

```text
DELETE http://localhost:8080/api/students/99
```

DAO 自訂查詢範例：

```text
GET http://localhost:8080/api/students/gpa?minGpa=3.0&maxGpa=4.0
```

多條件動態搜尋範例：

```text
GET http://localhost:8080/api/students/search?studentName=ryan&minGpa=3.5&maxGpa=4.0
```

`studentName`、`minGpa`、`maxGpa` 都可以省略，例如只設定 GPA 上限：

```text
GET http://localhost:8080/api/students/search?maxGpa=3.5
```

姓名使用不分大小寫的部分比對；三個條件都省略時會回傳全部學生。
DAO 使用 `StringBuilder` 加入有提供的 JPQL 條件，但使用者輸入仍透過
`setParameter` 傳入，而不是直接串接到 JPQL 字串。

查不到資料時，Service 會拋出 `ResourceNotFoundException`，
`@ResponseStatus(HttpStatus.NOT_FOUND)` 會讓 API 回傳 HTTP 404。

## 5. 常見 Annotation 說明

| Annotation | 放在哪裡 | 作用 |
|---|---|---|
| `@SpringBootApplication` | 啟動類別 | 啟用自動設定，並掃描 Spring 元件 |
| `@RestController` | Controller 類別 | 表示這個類別提供 REST API，回傳值會轉成 JSON |
| `@RequestMapping` | 類別或方法 | 設定共用或指定的 URL |
| `@GetMapping` | Controller 方法 | 對應 HTTP GET |
| `@PostMapping` | Controller 方法 | 對應 HTTP POST |
| `@PutMapping` | Controller 方法 | 對應 HTTP PUT |
| `@DeleteMapping` | Controller 方法 | 對應 HTTP DELETE |
| `@PathVariable` | 方法參數 | 取得 URL 中的值，例如 `/students/{id}` 的 id |
| `@RequestParam` | 方法參數 | 取得 Query String，例如 `?minGpa=3.0` |
| `@RequestBody` | 方法參數 | 把 JSON 內容轉成 Java 物件 |
| `@Service` | Service 實作類別 | 告訴 Spring 這是商業邏輯元件 |
| `@Repository` | DAO 實作類別 | 告訴 Spring 這是資料存取元件 |
| `@Entity` | Model 類別 | 將 Java 類別交給 JPA 對應資料表 |
| `@Table` | Entity 類別 | 指定對應的資料表名稱 |
| `@Id` | Entity 欄位 | 指定資料表主鍵 |
| `@Column` | Entity 欄位 | 指定欄位名稱或欄位設定 |
| `@PersistenceContext` | DAO 欄位 | 注入 JPA 管理的 EntityManager |
| `@Transactional` | DAO/Service 方法 | 將資料庫操作放在交易中；本範例查詢使用 readOnly |
| `@ResponseStatus` | 例外類別 | 指定例外發生時要回傳的 HTTP 狀態碼 |

Service 與 Controller 使用建構子注入：

```java
public StudentController(StudentService service) {
    this.service = service;
}
```

Spring 4.3 之後，類別只有一個建構子時不需要額外加 `@Autowired`。
這樣可以清楚看到類別需要哪些相依物件，也方便測試時傳入假的物件。

## 6. 如何新增一個 CRUD 功能

假設要新增 `Teacher`：

1. 在 `model/school` 建立 `Teacher`，加上 `@Entity`、`@Table`、`@Id` 與欄位。
2. 在 `repository/school` 建立 `TeacherRepository extends JpaRepository<Teacher, IdType>`。
3. 在 `service/school` 建立 `TeacherService`，宣告 findAll、findById、create、update、delete。
4. 在 `service/school/impl` 建立 `TeacherServiceImpl`，注入 `TeacherRepository`。
5. 在 `controller` 建立 `TeacherController`，加入五個 CRUD URL。
6. 在 `data.sql` 加入可選的初始資料。
7. 使用 `mvnw.cmd test` 確認 Spring Context 與 API 測試通過。

先照著 `Student` 的檔案逐一複製並修改名稱，是最容易理解分層關係的方式。

## 7. 單元測試與整合測試

本專案同時保留兩種測試，兩者用途不同：

| 測試 | 是否啟動 Spring/H2 | 驗證重點 |
|---|---|---|
| `StudentServiceImplTest` | 否 | CRUD 流程、找不到資料、Repository 與 DAO 呼叫 |
| `StudentControllerTest` | 否 | Controller 回傳值、HTTP 狀態碼與參數轉交 |
| `DemoApplicationTests` | 是 | HTTP 路由、JSON、Spring Bean、JPA 與資料庫整合 |

單元測試使用 Mockito：

- `@Mock` 建立假的 Repository、DAO 或 Service，不會真的存取資料庫。
- `@InjectMocks` 將 mock 傳入被測試類別。
- `when(...).thenReturn(...)` 設定 mock 的預期回傳值。
- `verify(...)` 確認程式是否呼叫了預期的方法。

執行全部單元測試與整合測試：

```powershell
.\mvnw.cmd test
```

只執行兩個單元測試類別：

```powershell
.\mvnw.cmd "-Dtest=StudentServiceImplTest,StudentControllerTest" test
```

單元測試適合快速確認單一類別的邏輯；整合測試較慢，但能發現資料表名稱、
Spring annotation 或 HTTP 路由等跨元件問題。新增其他資源時，可以 Student 的測試為範本。

## 8. H2 Console

瀏覽 `http://localhost:8080/h2-console`，填入：

- JDBC URL：`jdbc:h2:mem:schooldb`
- User Name：`sa`
- Password：留白

H2 是記憶體資料庫，程式停止後資料會消失；正式環境通常會改用 MySQL、PostgreSQL
或其他持久化資料庫，並將連線資訊放到環境變數或安全的設定管理工具中。

## 9. 為什麼這個分支移除一些套件？

本教學只聚焦在基本 CRUD，因此移除 AOP、Async、MapStruct、Swagger/OpenAPI、
Lombok、FreeMarker、Store 領域與雙資料庫設定。這些工具在大型專案可能很有用，
但初學時先看懂 Java 類別、Spring 分層與 JPA 資料流會比較容易建立基礎。

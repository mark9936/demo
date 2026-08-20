package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 應用程式的啟動類別。
 *
 * <p>{@link SpringBootApplication} 是三個 annotation 的組合：
 * {@code @Configuration}、{@code @EnableAutoConfiguration} 與
 * {@code @ComponentScan}。因此 Spring Boot 會自動尋找 Controller、Service
 * 及 Repository 並建立物件。</p>
 */
@SpringBootApplication
public class Application {

    /**
     * Java 程式的進入點，也是啟動內嵌 Web Server 的地方。
     *
     * @param args 啟動程式時傳入的參數
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

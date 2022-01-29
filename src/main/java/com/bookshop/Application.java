package com.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
public class Application {
    @Autowired
    Environment environment;

    // Port via annotation
//    @Value("${server.port}")
//    int aPort;
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(Application.class, args);

        Application application = new Application();
        System.out.println("-----------111");
        application.somePlaceInTheCode();
    }

    public void somePlaceInTheCode() throws UnknownHostException {
//        // Port
//        System.out.println(environment.getProperty("server.port"));
//
        // Local address
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());

        // Remote address
        System.out.println(InetAddress.getLoopbackAddress().getHostAddress());
        System.out.println(InetAddress.getLoopbackAddress().getHostName());
    }
}

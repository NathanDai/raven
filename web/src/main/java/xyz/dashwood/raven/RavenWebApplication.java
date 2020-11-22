package xyz.dashwood.raven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.dashwood.raven.biz.common.init.InitService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RavenWebApplication {
    @Autowired
    private InitService initService;

    private static RavenWebApplication app;

    public static void main(String[] args) {
        SpringApplication.run(RavenWebApplication.class, args);
        // 应用初始化
        app.initService.init();
    }

    @PostConstruct
    private void init() {
        app = this;
        app.initService = this.initService;
    }
}

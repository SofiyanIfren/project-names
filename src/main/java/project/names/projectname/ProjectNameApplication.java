package project.names.projectname;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import project.names.http.HttpName;
import project.names.http.HttpOrigin;
import project.names.model.Origin;

import java.util.List;

@SpringBootApplication
@EntityScan("project.names.model")
@ComponentScan(basePackages = {"project.names.controller", "project.names.service", "project.names.dao"})
@EnableJpaRepositories("project.names.dao")
public class ProjectNameApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectNameApplication.class, args);
    }
}

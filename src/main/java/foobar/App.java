package foobar;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;

public class App {


    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource( "jdbc:mysql://localhost:3306/webusertest?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL","root","123456").load();
        // Start the migration
        flyway.migrate();

    }

}

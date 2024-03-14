package school.project.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class OpenAPIConfiguration {
    @Bean
    public OpenAPI defineOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Students Api");

        Contact myContact = new Contact();
        myContact.setName("Tamir Moradi");
        myContact.setEmail("Moradi@gmail.com");

        Info info = new Info()
                .title("Student and grades management system API")
                .version("1.0")
                .description("This API exposes scores ")
                .contact(myContact);

        return new OpenAPI().info(info).servers(List.of(server));

    }
}

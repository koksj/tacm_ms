package za.co.tacm.resource;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "TACM API", description = "TACM Farmer api operations."),
        },
        info = @Info(
                title = "User API with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Admin",
                        url = "http://tacm.co.za/contact",
                        email = "admin@tacm.co.za"),
                license = @License(
                        name = "Private",
                        url = "https://tacm.co.za/"))
)
public class SwaggerConfig extends Application {

    
}

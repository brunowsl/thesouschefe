package com.api.thesouschefe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.IOException;

@Configuration
public class OpenApiDocs {

    @Bean
    public OpenAPI customOpenAPI() throws IOException, XmlPullParserException {

        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));

        return new OpenAPI()
                .info(
                        new Info()
                                .title("The Sous-Chefe API")
                                .description("The Sous-Chefe API")
                                .version(model.getVersion())
                );
    }
}

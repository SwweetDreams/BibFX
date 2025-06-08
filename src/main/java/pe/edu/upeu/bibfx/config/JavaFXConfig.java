package pe.edu.upeu.bibfx.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaFXConfig {

    private final ApplicationContext applicationContext;

    public JavaFXConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public FXMLLoader fxmlLoader() {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(applicationContext::getBean);
        return loader;
    }
} 
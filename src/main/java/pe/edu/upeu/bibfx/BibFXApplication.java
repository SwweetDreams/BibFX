package pe.edu.upeu.bibfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BibFXApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        applicationContext = new SpringApplicationBuilder(BibFXApplication.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            applicationContext.publishEvent(new StageReadyEvent(stage));
        } catch (Exception e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    @Override
    public void stop() {
        if (applicationContext != null) {
            applicationContext.close();
        }
        Platform.exit();
    }

    public static void main(String[] args) {
        // Configurar los argumentos de la VM para JavaFX
        System.setProperty("javafx.verbose", "true");
        System.setProperty("javafx.verbose.exceptions", "true");
        
        // Agregar los módulos de JavaFX necesarios
        String[] vmArgs = {
            "--module-path", System.getProperty("java.home") + "/lib",
            "--add-modules", "javafx.controls,javafx.fxml,javafx.graphics,javafx.base,javafx.media,javafx.web"
        };
        
        // Combinar los argumentos de la VM con los argumentos de la aplicación
        String[] allArgs = new String[args.length + vmArgs.length];
        System.arraycopy(vmArgs, 0, allArgs, 0, vmArgs.length);
        System.arraycopy(args, 0, allArgs, vmArgs.length, args.length);
        
        launch(BibFXApplication.class, allArgs);
    }
}

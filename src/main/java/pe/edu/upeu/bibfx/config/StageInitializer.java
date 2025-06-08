package pe.edu.upeu.bibfx.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pe.edu.upeu.bibfx.StageReadyEvent;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FXMLLoader fxmlLoader;

    public StageInitializer(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage stage = event.getStage();
            fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("BibFX - Sistema de Gestión de Biblioteca");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la interfaz principal", e);
        }
    }
} 
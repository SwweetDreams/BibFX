package pe.edu.upeu.bibfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @FXML
    private TabPane tabPane;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private TextField searchUserField;
    
    @FXML
    private TextField searchPrestamoField;
    
    @FXML
    private TableView<?> librosTable;
    
    @FXML
    private TableView<?> usuariosTable;
    
    @FXML
    private TableView<?> prestamosTable;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleLibrosTab() {
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    private void handleUsuariosTab() {
        tabPane.getSelectionModel().select(1);
    }

    @FXML
    private void handlePrestamosTab() {
        tabPane.getSelectionModel().select(2);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText("Sistema de Biblioteca");
        alert.setContentText("Versión 1.0\nDesarrollado por UPeU");
        alert.showAndWait();
    }

    @FXML
    private void handleSearch() {
        // TODO: Implementar búsqueda de libros
    }

    @FXML
    private void handleNewBook() {
        // TODO: Implementar creación de nuevo libro
    }

    @FXML
    private void handleEditBook() {
        // TODO: Implementar edición de libro
    }

    @FXML
    private void handleDeleteBook() {
        // TODO: Implementar eliminación de libro
    }

    @FXML
    private void handleSearchUser() {
        // TODO: Implementar búsqueda de usuarios
    }

    @FXML
    private void handleNewUser() {
        // TODO: Implementar creación de nuevo usuario
    }

    @FXML
    private void handleEditUser() {
        // TODO: Implementar edición de usuario
    }

    @FXML
    private void handleDeleteUser() {
        // TODO: Implementar eliminación de usuario
    }

    @FXML
    private void handleSearchPrestamo() {
        // TODO: Implementar búsqueda de préstamos
    }

    @FXML
    private void handleNewPrestamo() {
        // TODO: Implementar creación de nuevo préstamo
    }

    @FXML
    private void handleDevolverPrestamo() {
        // TODO: Implementar devolución de préstamo
    }

    @FXML
    private void handleViewPrestamoDetails() {
        // TODO: Implementar visualización de detalles de préstamo
    }
} 
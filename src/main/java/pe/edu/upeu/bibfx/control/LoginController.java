package pe.edu.upeu.bibfx.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.bibfx.modelo.Usuario;
import pe.edu.upeu.bibfx.servicio.AuthService;

@Controller
public class LoginController {

    @Autowired
    private AuthService authService;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMensaje;

    @FXML
    private void handleLogin() {
        String email = txtUsuario.getText();
        String password = txtPassword.getText();

        if (email.isEmpty() || password.isEmpty()) {
            lblMensaje.setText("Por favor, complete todos los campos");
            return;
        }

        Usuario usuario = authService.authenticate(email, password);

        if (usuario == null) {
            lblMensaje.setText("Credenciales inválidas o usuario inactivo");
            return;
        }

        lblMensaje.setText("Login exitoso - Bienvenido " + usuario.getNombres());
    }

    @FXML
    private void handleCancel() {
        txtUsuario.clear();
        txtPassword.clear();
        lblMensaje.setText("");
    }
} 
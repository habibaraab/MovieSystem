/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication9;

import com.mysql.cj.xdevapi.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @Habiba Rajab
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane sigin_form;

    @FXML
    private TextField sigin_username;

    @FXML
    private PasswordField sigin_password;

    @FXML
    private Button signin_btn;

    @FXML
    private Hyperlink createnewAccount;

    @FXML
    private AnchorPane sigup_form;

    @FXML
    private TextField sigup_username;

    @FXML
    private PasswordField sigup_password;

    @FXML
    private Button signup_btn;

    @FXML
    private Hyperlink alreadyHaveAccount;

    @FXML
    private TextField sigup_email;

    private Connection connect;
    private PreparedStatement prepare;
 
    private ResultSet result;

    public void signup() {
        String sql = "insert into admin (email,username,password) values (?,?,?)";

        connect = database.getCon();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, sigup_email.getText());
            prepare.setString(2, sigup_username.getText());
            prepare.setString(3, sigup_password.getText());

            Alert alert;
            if (sigup_email.getText().isEmpty() || sigup_password.getText().isEmpty() || sigup_username.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (sigup_password.getText().length() < 5) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invaild password");
                alert.showAndWait();

            } else {

                prepare.execute();
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully create a new account!");
                alert.showAndWait();

                sigup_email.setText("");
                sigup_username.setText("");
                sigup_password.setText("");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void sigin() {
        String sql = "select *from admin where username = ?and password = ?";
        connect = database.getCon();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, sigin_username.getText());
            prepare.setString(2, sigin_password.getText());
            result = prepare.executeQuery();
            Alert alert;
            if (sigin_username.getText().isEmpty() || sigin_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (result.next()) {

                    getData.username = sigin_username.getText();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    signin_btn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username or password");
                    alert.showAndWait();

                }

            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void switchForm(ActionEvent ev) {
        if (ev.getSource() == createnewAccount) {
            sigin_form.setVisible(false);
            sigup_form.setVisible(true);
        } else if (ev.getSource() == alreadyHaveAccount) {
            sigin_form.setVisible(true);
            sigup_form.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

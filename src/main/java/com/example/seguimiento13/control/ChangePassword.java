package com.example.seguimiento13.control;

import com.example.seguimiento13.HelloApplication;
import com.example.seguimiento13.model.FileOpenerData;
import com.example.seguimiento13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class ChangePassword {

    @FXML
    private HBox boxes;

    @FXML
    private HBox boxes1;

    @FXML
    private Button changePasswordBT;

    @FXML
    private Button closeSafeBT;

    @FXML
    private PasswordField newPass1PF;

    @FXML
    private PasswordField newPass2PF;

    @FXML
    private PasswordField newPass3PF;

    @FXML
    private PasswordField newPass4PF;

    @FXML
    private PasswordField newPass5PF;

    @FXML
    private PasswordField newPass6PF;

    @FXML
    private PasswordField pass1PF;

    @FXML
    private PasswordField pass2PF;

    @FXML
    private PasswordField pass3PF;

    @FXML
    private PasswordField pass4PF;

    @FXML
    private PasswordField pass5PF;

    @FXML
    private PasswordField pass6PF;

    @FXML
    void closeSafe(ActionEvent event) {
        Stage stage = (Stage) boxes1.getScene().getWindow();
        stage.hide();
        HelloApplication.showWindow("Login.fxml");
    }

    @FXML
    void onKey(KeyEvent event) {
        if(event.getSource().equals(pass1PF)) {
            pass2PF.requestFocus();
        } else if(event.getSource().equals(pass2PF)) {
            pass3PF.requestFocus();
        } else if(event.getSource().equals(pass3PF)) {
            pass4PF.requestFocus();
        } else if(event.getSource().equals(pass4PF)) {
            pass5PF.requestFocus();
        } else if(event.getSource().equals(pass5PF)) {
            pass6PF.requestFocus();
        }
    }

    @FXML
    void onKeyNewPassword(KeyEvent event) {
        if(event.getSource().equals(newPass1PF)) {
            newPass2PF.requestFocus();
        } else if(event.getSource().equals(newPass2PF)) {
            newPass3PF.requestFocus();
        } else if(event.getSource().equals(newPass3PF)) {
            newPass4PF.requestFocus();
        } else if(event.getSource().equals(newPass4PF)) {
            newPass5PF.requestFocus();
        } else if(event.getSource().equals(newPass5PF)) {
            newPass6PF.requestFocus();
        }
    }

    @FXML
    void verifyPassword(ActionEvent event) {
        String realPassword = FileOpenerData.getInstance().getUser().getBankPassword();
        StringBuilder enteredPassword = new StringBuilder();
        for (Node node: boxes.getChildren()) {
            TextField tf = (TextField) node;
            enteredPassword.append(tf.getText());
        }
        StringBuilder newPassword = new StringBuilder();
        for (Node node: boxes1.getChildren()) {
            TextField tf = (TextField) node;
            newPassword.append(tf.getText());
        }
        if(realPassword.replaceAll("\\s+","").equals(enteredPassword.toString().replaceAll("\\s+",""))) {
            FileOpenerData.getInstance().getUser().setBankPassword(newPassword.toString());
            FileUtils.writeFile("safePassword.txt", newPassword.toString());
            Stage stage = (Stage) boxes1.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Correct password");
            alert.setHeaderText("The credentials are correct");
            alert.setContentText("The password has been changed :)");
            alert.showAndWait();
            stage.hide();
            HelloApplication.showWindow("Login.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong password");
            alert.setHeaderText("Wrong password");
            alert.setContentText("Ooops, The password is incorrect " +
                    "\nYou can't change the password");
            alert.showAndWait();
        }
    }

}

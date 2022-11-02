package com.example.seguimiento13.control;

import com.example.seguimiento13.HelloApplication;
import com.example.seguimiento13.model.FileOpenerData;
import com.example.seguimiento13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private HBox boxes;
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
    void verifyPassword(ActionEvent event) {
        String realPassword = FileOpenerData.getInstance().getUser().getBankPassword();
        StringBuilder enteredPassword = new StringBuilder();
        for (Node node: boxes.getChildren()) {
            TextField tf = (TextField) node;
            enteredPassword.append(tf.getText());
            //System.out.println(enteredPassword);
        }
        if(realPassword.replaceAll("\\s+","").equals(enteredPassword.toString().replaceAll("\\s+",""))) {
            HelloApplication.showWindow("Home.fxml");
            Stage currentStage = (Stage) pass1PF.getScene().getWindow();
            currentStage.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong password");
            alert.setHeaderText("Wrong password");
            alert.setContentText("Ooops, you entered an incorrect password!!!");
            alert.showAndWait();
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String password = FileUtils.readFile("safePassword.txt");
        FileOpenerData.getInstance().getUser().setBankPassword(password);
    }
}
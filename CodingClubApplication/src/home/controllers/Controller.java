package home.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private JFXButton btnContribution;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnMembers;

    @FXML
    private VBox vBoxMembers;

    @FXML
    private VBox vBoxDashboard;

    @FXML
    private Label lblContent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vBoxDashboard.toFront();
    }

    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == btnDashboard){
            vBoxDashboard.toFront();
            lblContent.setText("Dashboard");
        } else if(event.getSource() == btnMembers){
            lblContent.setText("Members");
            vBoxMembers.toFront();

        } else if(event.getSource() == btnContribution){
//            clearMainContent();
            lblContent.setText("Contributions");
        }
    }

    private void clearMainContent(){
        vBoxMembers.setVisible(false);

    }


}

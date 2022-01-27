package home.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import home.domain.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Label lblContent;

    @FXML
    private Pane paneContributions;

    @FXML
    private Pane paneDashboard;

    @FXML
    private Pane paneMembers;

    @FXML
    private TableView<Member> membersTable;

    @FXML
    private TableColumn<Member, String> tbclActions;

    @FXML
    private TableColumn<Member, String> tbclName;

    @FXML
    private TableColumn<Member, String> tbclRegistrationNo;

//    @FXML
//    private TableColumn<Member, String> tblclAmount;

    private ObservableList<Member> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // fetch data from db
        tbclActions.setCellValueFactory(new PropertyValueFactory<>(""));
        tbclName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        tbclRegistrationNo.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
//        tblclAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        data = FXCollections.observableArrayList(
                new Member("33434", "Eliah Mbwilo"),
                new Member("33434", "Jane Mbwilo")
        );
        membersTable.setItems(data);
    }

    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == btnDashboard){

            lblContent.setText("Dashboard");
            paneDashboard.toFront();
        } else if(event.getSource() == btnMembers){
            lblContent.setText("Members");
            paneMembers.toFront();

        } else if(event.getSource() == btnContribution){
//            clearMainContent();
            lblContent.setText("Contributions");
            paneContributions.toFront();
        }
    }


}

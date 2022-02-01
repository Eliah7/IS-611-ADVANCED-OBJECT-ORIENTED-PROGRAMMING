package home.controllers;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import home.domain.Member;
import home.repository.MemberRepository;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private JFXButton btnMembers;


    @FXML
    private Label lblContent;



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
        MemberRepository memberRepository = new MemberRepository();
        try {
            System.out.println(memberRepository.getAll());
//            System.out.println(memberRepository.add(new Member("33434", "Jane Mbwilo")));


            tbclActions.setCellValueFactory(new PropertyValueFactory<>(""));
            tbclName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
            tbclRegistrationNo.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
    //        tblclAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    //        data = FXCollections.observableArrayList(
    //
    //        );
            data = FXCollections.observableArrayList(memberRepository.getAll());
            membersTable.setItems(data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }



    @FXML
    private void handleClicks(ActionEvent event){
         if(event.getSource() == btnMembers){
            lblContent.setText("Members");
            paneMembers.toFront();

        }
    }


}

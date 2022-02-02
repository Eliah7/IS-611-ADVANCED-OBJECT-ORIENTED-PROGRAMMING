package home.controllers;

import com.jfoenix.controls.JFXButton;
import home.domain.Member;
import home.repository.MemberRepository;
import home.services.MemberService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
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

    @FXML
    private JFXButton btnShowAddMember;

    @FXML
    private JFXButton btnAddMember;

    @FXML
    private JFXButton btnRefreshPage;

    @FXML
    private TextField txtMembershipNo;

    @FXML
    private TextField txtName;

    private ObservableList<Member> data;

    public static Stage pStage;
    private URL location;
    private ResourceBundle resources;
    private MemberService memberService;
    private static Stage dialogStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.location = location;
        this.resources = resources;
        // fetch data from db
        System.out.println(location.getPath());
        memberService = new MemberService();
        try {
            if(location.getPath().contains("home/fxml/add_member.fxml")){

            } else if(location.getPath().contains("home/fxml/member_contributions.fxml")){

            }
            else if(location.getPath().contains("home/fxml/pay.fxml")){

            }else{
                updateTable();
                System.out.println(memberService.getAllMembers());
//            System.out.println(memberRepository.add(new Member("33434", "Jane Mbwilo")));

                tbclName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
                tbclRegistrationNo.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
//            tbclActions.setCellValueFactory(new PropertyValueFactory<>("actions"));

                addButtonToTable(MemberService.Delete);
                addButtonToTable(MemberService.Edit);
                addButtonToTable(MemberService.VIEW_CONTRIBUTIONS);
                addButtonToTable(MemberService.PAY);

                data = FXCollections.observableArrayList(memberService.getAllMembers());
                membersTable.setItems(data);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addButtonToTable(String columnName) {
        TableColumn<Member, Void> colBtn = new TableColumn(columnName);

        Callback<TableColumn<Member, Void>, TableCell<Member, Void>> cellFactory = new Callback<TableColumn<Member, Void>, TableCell<Member, Void>>() {
            @Override
            public TableCell<Member, Void> call(final TableColumn<Member, Void> param) {
                final TableCell<Member, Void> cell = new TableCell<Member, Void>() {

                    private final Button btn = new Button(columnName);

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Member data = getTableView().getItems().get(getIndex());
                            executeTableAction(columnName, data);
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);


        membersTable.getColumns().add(colBtn);

    }

    private void updateTable() throws Exception{
        data = FXCollections.observableArrayList(memberService.getAllMembers());
        membersTable.setItems(data);
    }

    @FXML
    private void executeTableAction(String columnName, Member data) {
        try {
            if (MemberService.Delete.equalsIgnoreCase(columnName)) {

                System.out.println("Deleting " + data.getMemberName());
                memberService.deleteMember(data);

                // refresh view
                updateTable();
            } else if (MemberService.Edit.equalsIgnoreCase(columnName)) {
                System.out.println("Editing " + data.getMemberName());

                dialogStage = showDialog("add_member");
//                txtName.setText(data.getMemberName());
//                txtMembershipNo.setText(data.getMembershipNumber());
            } else if (MemberService.PAY.equalsIgnoreCase(columnName)) {
                System.out.println("Paying " + data.getMemberName());
                dialogStage = showDialog("pay");
            } else if (MemberService.VIEW_CONTRIBUTIONS.equalsIgnoreCase(columnName)) {
                System.out.println("View Contributions " + data.getMemberName());
                dialogStage = showDialog("member_contributions");
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private void refreshView(){
        this.initialize(this.location, this.resources);
    }


    @FXML
    private void handleClicks(ActionEvent event){
         if(event.getSource() == btnMembers){
            lblContent.setText("Members");
            paneMembers.toFront();

        } else if(event.getSource() == btnShowAddMember){
             dialogStage = showDialog("add_member");
         } else if(event.getSource() == btnAddMember){
             System.out.println(dialogStage);
             if(!txtMembershipNo.getCharacters().toString().equalsIgnoreCase("")){
                 Member member = new Member(txtMembershipNo.getCharacters().toString() ,txtName.getCharacters().toString());
                 System.out.println(member);

                 try {
                     memberService.addMember(member);
                     dialogStage.close();
//                     btnRefreshPage.fire();
//                     updateTable();
                 } catch (Exception e){
                     e.printStackTrace();
                 }

             } else {
                 dialogStage.close();
             }

         } else if(event.getSource() == btnRefreshPage){
             System.out.println("Refreshing page");
             try {
                 updateTable();
             }catch (Exception e){
                 e.printStackTrace();
             }

         }
    }

    private Stage showDialog(String fxml){
        try{
            System.out.println("../fxml/" + fxml + ".fxml");
            Parent parent = FXMLLoader.load(getClass().getResource("../fxml/" + fxml + ".fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(true);

            stage.setAlwaysOnTop(true);
            stage.setX(pStage.getX() + pStage.getHeight()/2);
            stage.setY(pStage.getY() + pStage.getWidth()/3 );
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            return stage;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }




}

package home.controllers;

import com.jfoenix.controls.JFXButton;
import home.domain.Member;
import home.domain.MonthlyPayment;
import home.domain.MonthlyPaymentList;
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
import java.text.DateFormatSymbols;
import java.util.*;

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
    private TableView<MonthlyPayment> contributionsTable;

    @FXML
    private TableColumn<MonthlyPayment, String> tbclAmountContributions;

    @FXML
    private TableColumn<MonthlyPayment, String> tbclMonth;

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
    private ComboBox<String> cbxMonth;

    @FXML
    private TextField txtName;


    @FXML
    private TextField txtAmountAddPayment;


    @FXML
    private JFXButton btnAddPaymentModal;

    private ObservableList<Member> data;

    public static Stage pStage;
    private URL location;
    private ResourceBundle resources;
    private MemberService memberService;
    private static Stage dialogStage;
    private static Member selectedMember;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.location = location;
        this.resources = resources;
        // fetch data from db
        System.out.println(location.getPath());
        memberService = new MemberService();
        try {
            if(location.getPath().contains("home/fxml/add_member.fxml")){
                if(selectedMember != null){
                    txtName.setText(selectedMember.getMemberName());
                    txtMembershipNo.setText(selectedMember.getMembershipNumber());
                    btnAddMember.setText("Edit Member");
//                    selectedMember = null;
                }

            } else if(location.getPath().contains("home/fxml/member_contributions.fxml")){
                tbclMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
                tbclAmountContributions.setCellValueFactory(new PropertyValueFactory<>("amount"));

                System.out.println("Selected member payment list" + selectedMember);
                System.out.println("Monthly payment list " +  selectedMember.getMonthlyPaymentList());

                contributionsTable.setItems
                        (FXCollections.observableArrayList(
                                selectedMember.getMonthlyPaymentList() != null?
                                selectedMember.getMonthlyPaymentList().getMonthlyPayments() :
                                new ArrayList()));
            }
            else if(location.getPath().contains("home/fxml/pay.fxml")){
                if(selectedMember != null){
                    // set the combobox values to days of the month
                    String[] months = new DateFormatSymbols().getMonths();
                    cbxMonth.setItems(FXCollections.observableArrayList(months));


//                    selectedMember = null;
                }
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
                selectedMember = data;
                dialogStage = showDialog("add_member");
            } else if (MemberService.PAY.equalsIgnoreCase(columnName)) {
                selectedMember = data;
                System.out.println("Paying " + data.getMemberName());
                dialogStage = showDialog("pay");
                System.out.println("Selected " + selectedMember);
            } else if (MemberService.VIEW_CONTRIBUTIONS.equalsIgnoreCase(columnName)) {
                selectedMember = data;
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
             selectedMember = null;
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

         } else if(event.getSource() == btnAddPaymentModal){
             // add payment for member
             try {
                 System.out.println("Refreshing page " + selectedMember);
                 System.out.println(txtAmountAddPayment.getText() + " " + cbxMonth.getValue());
                 MonthlyPaymentList monthlyPaymentList = selectedMember.getMonthlyPaymentList() != null? selectedMember.getMonthlyPaymentList(): new MonthlyPaymentList();
                 monthlyPaymentList.add(new MonthlyPayment(Double.parseDouble(txtAmountAddPayment.getText()), cbxMonth.getValue()));
                 selectedMember.setMonthlyPaymentList(monthlyPaymentList);

                 memberService.addMember(selectedMember);
//                 selectedMember = null;

                 dialogStage.close();
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

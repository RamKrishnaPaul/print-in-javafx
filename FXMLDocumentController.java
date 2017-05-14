/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malapplication;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Predicate;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import static malapplication.LoginFXMLController.name;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Ram Krishna Paul
 */
public class FXMLDocumentController implements Initializable {

// initialize observable list to hold the data from datbase
    ObservableList<String> Selectlist = FXCollections.observableArrayList("Contacts", "Global Address Book", "Personal Address Book", "Standard Organization Address Book", "Contact Group");

    //ObservableList<String> Selectlist1 = FXCollections.observableArrayList("Global Address Book");
    public static String itm = null;  // decleare item statically and globally to access aonther class
    final DatePicker datePicker = new DatePicker();
    @FXML
    private Label lbluser;

    @FXML
    private ComboBox myCombobox1;

    @FXML
    private Button btn1;
    @FXML
    private ProgressIndicator progressBar = new ProgressIndicator();
    @FXML
    private Button btncancel;

    private DBConnection dc;

    @FXML
    private TextField textsearch;

// code for retrieve data from database to contact list table
    @FXML
    private TableView<usermstpojo> contacttable;
    @FXML
    private TableColumn<usermstpojo, String> colcontactlist;
    @FXML
    private TableColumn<usermstpojo, Boolean> colemailaddress;

    @FXML
    private ObservableList<usermstpojo> data1;
    // private ObservableList<usermstpojo> data2;
    boolean val = true;

    public boolean receval() {
        if (val == false) {
            Set<Node> cells = contacttable.lookupAll(".table-cell");
            cells.forEach((c) -> {
                c.setStyle("-fx-font-weight:lighter;-fx-font-style:italic;");
            });

        }
        if (val == true) {
            Set<Node> cells = contacttable.lookupAll(".table-cell");
            cells.forEach((c) -> {
                c.setStyle("-fx-font-weight:bold;");
            });

        }
        return val;
    }

    @FXML

    public void onselectaction(ActionEvent event) throws SQLException {
        String comboval = "Global Address Book";
        receval();
        String str = myCombobox1.getSelectionModel().getSelectedItem().toString();
        System.out.println("combobox id : " + str);
        if (str.equalsIgnoreCase(comboval)) {

            Connection conn2;
            conn2 = dc.Connect();
            data1 = FXCollections.observableArrayList();

            ResultSet rs1 = conn2.createStatement().executeQuery("SELECT username,emailid FROM awan_user_mst");
            try {
                while (rs1.next()) {
                    data1.add(new usermstpojo(rs1.getString("username"), rs1.getString("emailid")));
//                    System.out.println("data1"+data1);
//                    contacttable.setItems(data1);
                    System.out.println("rs1" + rs1.getString(1));
                    Text t = new Text(rs1.getString(1));
                    t.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                }
                colcontactlist.setCellValueFactory(new PropertyValueFactory<>("username"));

                colemailaddress.setCellValueFactory(new PropertyValueFactory<>("emailid"));
//                CheckBox checkBox = new CheckBox();

//                colemailaddress.setCellFactory(column -> new CheckBoxTableCell<>());
            } catch (SQLException e) {
                System.out.println(e);

            }
            contacttable.setItems(data1);
            contacttable.setVisible(true);

            contacttable.getItems();

            contacttable.setRowFactory(val -> new TableRow<usermstpojo>() {
                @Override
                public void updateItem(usermstpojo item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null) {
                        setStyle("");
                    } else if (item.getUsername().equals("chaitra")) {
                        setStyle("-fx-background-color: tomato;");
                    } else if (item.getUsername().equals("yogita")) {
                        setStyle("-fx-background-color: blue;");
                    } else if (item.getUsername().equals("daivik")) {
                        setStyle("-fx-background-color: green;");
                    } else if (item.getUsername().equals("sumitra")) {
                        setStyle("-fx-background-color: orange;");
                    } else if (item.getUsername().equals("sandeep")) {
                        setStyle("-fx-background-color: pink;");
                    } else if (item.getUsername().equals("vinaya")) {
                        setStyle("-fx-background-color: lightgreen;");
                    } else {
                        setStyle("");
                    }
                }

            });

//            contacttable.setRowFactory(new Callback<TableView<usermstpojo>, TableRow<usermstpojo>>() {
//                @Override
//                public TableRow<usermstpojo> call(TableView<usermstpojo> tableView) {
//                    final TableRow<usermstpojo> row = new TableRow<usermstpojo>() {
//                        @Override
//                        protected void updateItem(usermstpojo row, boolean empty) {
//                            super.updateItem(row, empty);
//                            if (!empty) {
//                                
//                                styleProperty().bind(Bindings.when(row.getUsername().equals("chaitra"))
//                                        .then("-fx-font-weight: bold; -fx-font-size: 16;")
//                                        .otherwise(""));
//                            }
//                        }
//                    };
//                    return row;
//                }
//            });
// code for filtering username in contact list table//
            FilteredList<usermstpojo> filteredData = new FilteredList<>(data1, e -> true);
            textsearch.setOnKeyReleased(e -> {
                textsearch.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super usermstpojo>) user -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (user.getUsername().contains(newValue)) {
                            return true;
                        } else if (user.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<usermstpojo> sortedList = new SortedList<>(filteredData);
                sortedList.comparatorProperty().bind(contacttable.comparatorProperty());
                contacttable.setItems(sortedList);
            });
        } //end of if condition
        else {
            contacttable.getItems().clear();
            //contacttable.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning Dialogue");
            alert.setHeaderText(null);
            alert.setContentText("No Contacts in this addressbook!");
            alert.showAndWait();
            //contacttable.setDisable(false);
            // contacttable.getColumns().get(0).setVisible(false);

        }

    }

// code for fetching data from table for addressbook in treeview
    @FXML
    private TreeView<String> tableaddressbook;
    @FXML
    Connection conn;
    @FXML
    Image icon = new Image(getClass().getResourceAsStream("/img/folder.png"));
    Image icon1 = new Image(getClass().getResourceAsStream("/img/file.png"));
    @FXML
    private Button btnloadaddressbook;

    private ObservableList<addressbookpojo> data;

    @FXML
    public void loadDatafromDatabase(ActionEvent event) throws SQLException {
        progressBar.setProgress(0.75F);
        conn = dc.Connect();
        data = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("select addrbookname,addrid from awan_address_book_mst");

        TreeItem<String> root = new TreeItem<>("Address Book", new ImageView(icon));
        root.setExpanded(true);
        try {
            while (rs.next()) {

                data.add(new addressbookpojo(rs.getString("addrbookname"), rs.getString("addrid")));

                TreeItem<String> item = new TreeItem<>("item", new ImageView(icon1));

                item.setValue(new addressbookpojo(rs.getString(1)).getAddrbookname());

                root.getChildren().addAll(item);
                System.out.println(item.getValue());

            }

            tableaddressbook.setRoot(root);

        } catch (SQLException ex) {

            System.out.println("error" + ex);
        }

    }
    @FXML
    private MenuItem deletecontext;

//code for open new window to create new address book//
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        Parent root1;

        if (event.getSource() == btn1) {
            root1 = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
            stage1.setScene(new Scene(root1));
            stage1.setTitle("Add new addressbook");
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.initOwner(btn1.getScene().getWindow());
            stage1.toFront();
            stage1.showAndWait();
            stage1.setResizable(false);

            stage1.getIcons().add(new Image("/img/Mail-icon.png"));

        } else {
            stage1 = (Stage) btncancel.getScene().getWindow();
            stage1.close();
        }

    }

// code for opening of  edit and modify addressbook window
    @FXML
    private MenuItem editcontext;
    @FXML
    private Button btncancel1;

    @FXML
    public void oneditaction(ActionEvent event) throws IOException {
        Stage stage2 = new Stage();
        Parent root2;

        if (event.getSource() == editcontext) {
            root2 = FXMLLoader.load(getClass().getResource("modify.fxml"));
//            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("m.fxml"));
//            modifyController = fxmlloader.getController();

            stage2.setScene(new Scene(root2));
            stage2.setTitle("Modify AddressBook");
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initOwner(editcontext.getParentPopup().getOwnerWindow());
            stage2.toFront();
            stage2.showAndWait();
            stage2.getIcons().add(new Image("/img/Mail-icon.png"));
            stage2.setResizable(false);
        } else {
            stage2 = (Stage) btncancel1.getScene().getWindow();
            stage2.close();
        }

    }
// for removing treeitems

    @FXML
    public void deleteSelectedNode(ActionEvent e) throws SQLException {
        Connection conn5;
        conn5 = dc.Connect();
        ObservableList<addressbookpojo> alladdress;
        alladdress = FXCollections.observableArrayList();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning Dialogue");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure want to delete !");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                TreeItem c = (TreeItem) tableaddressbook.getSelectionModel().getSelectedItem();
                boolean remove = c.getParent().getChildren().remove(c);
                System.out.println("Remove" + remove);
                System.out.println(itm);
                int rs5 = conn5.createStatement().executeUpdate("delete from awan_address_book_mst where addrbookname =" + "'" + itm + "'");
                System.out.println("remove item is " + rs5);
            } catch (Exception ex) {
                System.out.println("error " + ex);
            }
        }
    }

    @FXML
    private ObservableList<usermstpojo> data3;

    @FXML
    private ObservableList<usermstpojo> data12;
//for notification

    private static void notifier(String pTitle, String pMessage) {
        Platform.runLater(() -> {
            Stage owner = new Stage(StageStyle.TRANSPARENT);
            StackPane root = new StackPane();
            root.setStyle("-fx-background-color: TRANSPARENT");
            Scene scene = new Scene(root, 1, 1);
//            owner.initModality(Modality.APPLICATION_MODAL);
            scene.setFill(Color.TRANSPARENT);

            owner.setScene(scene);
            owner.setWidth(1);
            owner.setHeight(1);
            owner.toBack();
            owner.show();
            Notifications.create().title(pTitle).text(pMessage).showInformation();

        }
        );
    }

    /// for progressindicator
    final ObservableList<String> listItems = FXCollections.observableArrayList();
    final ProgressIndicator loadingIndicator = new ProgressIndicator();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Platform.runLater(() -> {
//            Notifications.create().hideCloseButton().text("This notification WILL NOT steal focus, tabbing between the fields will be possible.").showInformation();
//        });

        Platform.runLater(() -> {
            Notifications.create().text(name + myCombobox1 + "hello").showInformation();
        });
        new JFXPanel();

// for combo box
        colemailaddress.setEditable(true);
        contacttable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        myCombobox1.setValue("Select");
        myCombobox1.setItems(Selectlist);

        lbluser.setText("Hello: " + name);
        dc = new DBConnection();

// code for auto load of addressbook in treeview
        try {
            conn = dc.Connect();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("select addrbookname,addrid from awan_address_book_mst");
            TreeItem<String> root = new TreeItem<>("Address Book", new ImageView(icon));
            root.setExpanded(true);
            try {
                while (rs.next()) {

                    data.add(new addressbookpojo(rs.getString("addrbookname"), rs.getString("addrid")));

                    TreeItem<String> item = new TreeItem<>("item", new ImageView(icon1));

                    item.setValue(new addressbookpojo(rs.getString(1)).getAddrbookname());

                    root.getChildren().addAll(item);

                    System.out.println(item.getValue());

                }

                tableaddressbook.setRoot(root);

            } catch (SQLException ex) {

                System.out.println("error" + ex);
            }

        } catch (SQLException ex) {
            System.out.println("error is" + ex);
        }
    }

//code for retrieving respective username and email adress of particular addressbook
    public void mouseclick(MouseEvent mouseEvent) throws SQLException {

        itm = tableaddressbook.getSelectionModel().getSelectedItem().getValue();
        System.out.println(itm);

        /// for global addressbook load on treeview
        String itm1 = "Global Address";
        if (itm1.equalsIgnoreCase(itm)) {
            Connection con;
            con = dc.Connect();
            data12 = FXCollections.observableArrayList();

            ResultSet rs5 = con.createStatement().executeQuery("SELECT username,emailid FROM awan_user_mst");
            try {
                while (rs5.next()) {
                    data12.add(new usermstpojo(rs5.getString("username"), rs5.getString("emailid")));
                    contacttable.setItems(data12);
                    System.out.println(rs5.getString(1));

                }
                colcontactlist.setCellValueFactory(new PropertyValueFactory<>("username"));
                colemailaddress.setCellValueFactory(new PropertyValueFactory<>("emailid"));
            } catch (SQLException e) {
                System.out.println(e);

            }
            contacttable.setItems(data12);
            contacttable.setVisible(true);
            contacttable.getItems();

        } else {
            Connection conn3;
            conn3 = dc.Connect();
            data3 = FXCollections.observableArrayList();
            ResultSet rs3 = conn3.createStatement().executeQuery("select username,emailid,addrid from awan_addrbookdtls,awan_user_mst,awan_address_book_mst where faddrid=addrid and fuserid = userid and addrbookname=" + "'" + itm + "'");

            try {
                while (rs3.next()) {

                    data3.add(new usermstpojo(rs3.getString("username"), rs3.getString("emailid")));

                    System.out.println(rs3.getString(1));
                    System.out.println(rs3.getString(3));
                }
                colcontactlist.setCellValueFactory(new PropertyValueFactory<>("username"));
                colemailaddress.setCellValueFactory(new PropertyValueFactory<>("emailid"));
            } catch (SQLException e) {
                System.out.println(e);

            }
            contacttable.setItems(data3);
            contacttable.setVisible(true);
            contacttable.getItems();

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickperformbylambda;

/**
 *
 * @author krish
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableWithCheckbox extends Application {

    final TableView<Player> table = new TableView<Player>();
    ObservableList<Player> data;

    @Override
    public void start(Stage primaryStage) {
        final BorderPane root = new BorderPane();

        table.setItems(createData());
        final TableColumn<Player, String> firstNameColumn = new TableColumn<>("First Name");
        final TableColumn<Player, String> lastNameColumn = new TableColumn<>("Last Name");
        final TableColumn<Player, Boolean> injuredColumn = new TableColumn<>("Injured");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));
        injuredColumn.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("injured"));
//        final Callback<TableColumn<Player, Boolean>, TableCell<Player, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(injuredColumn);
        injuredColumn.setCellFactory(CheckBoxTableCell.forTableColumn(injuredColumn));
//injuredColumn.setCellFactory(new Callback<TableColumn<Player, Boolean>, TableCell<Player, Boolean>>() {
//            @Override
//            public TableCell<Player, Boolean> call(TableColumn<Player, Boolean> column) {
//                TableCell<Player, Boolean> cell = cellFactory.call(column);
//                cell.setAlignment(Pos.CENTER);
//                return cell;
//            }
//        });
//        injuredColumn.setCellFactory(cellFactory);
//        injuredColumn.setEditable(true);

        // This appears not to get invoked:
//        injuredColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, Boolean>>() {
//            @Override
//            public void handle(CellEditEvent<Player, Boolean> event) {
//                System.out.println("Edit commit");
//            }
//        });

        table.setEditable(true);
        table.getColumns().addAll(firstNameColumn, lastNameColumn, injuredColumn);

        root.setCenter(table);

        Button button = new Button("Dump info");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Player p : table.getItems()) {
                    System.out.println(p);
                }
                System.out.println();
            }
        });
        Button button1 = new Button("add");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                data.add(new Player("hbghj", "hjhbbccc77", true));
            }
        });
        root.setBottom(button);
        root.setTop(button1);
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Player> createData() {
        List<Player> players = Arrays.asList(
                new Player("Hugo", "Lloris", false),
                new Player("Brad", "Friedel", false),
                new Player("Kyle", "Naughton", false),
                new Player("Younes", "Kaboul", true),
                new Player("Benoit", "Assou-Ekotto", false),
                new Player("Jan", "Vertonghen", false),
                new Player("Michael", "Dawson", false),
                new Player("William", "Gallas", true),
                new Player("Kyle", "Walker", false),
                new Player("Scott", "Parker", false),
                new Player("Mousa", "Dembele", false),
                new Player("Sandro", "Cordeiro", true),
                new Player("Tom", "Huddlestone", false),
                new Player("Gylfi", "Sigurdsson", false),
                new Player("Gareth", "Bale", false),
                new Player("Aaron", "Lennon", false),
                new Player("Jermane", "Defoe", false),
                new Player("Emmanuel", "Adebayor", true)
        );
        data = FXCollections.<Player>observableArrayList(
                new Callback<Player, Observable[]>() {
            @Override
            public Observable[] call(Player player) {
                return new Observable[]{player.injuredProperty()};
            }
        }
        );
        data.addAll(players);
        data.addListener(new ListChangeListener<Player>() {
            @Override
            public void onChanged(
                    javafx.collections.ListChangeListener.Change<? extends Player> change) {
                System.out.println("List changed");
                while (change.next()) {
                    if (change.wasUpdated()) {
                        String inj = (data.get(change.getFrom()).injured.getValue()) ? "injuried" : "no longer injuried";
                        System.out.println(data.get(change.getFrom()).lastName.getValue() + ", "
                                + data.get(change.getFrom()).firstName.getValue() + "  "
                                + "changed his status to " + inj);
                        System.out.println();
                    }
                }
            }
        });
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (table.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    System.out.println("Selected Value " + val);
                    System.out.println("Selected row " + newValue);
                }
            }
        });
        return data;
    }

    public static class Player {

        private final StringProperty firstName;
        private final StringProperty lastName;
        private final BooleanProperty injured;

        Player(String firstName, String lastName, boolean international) {
            this.firstName = new SimpleStringProperty(this, "firstName", firstName);
            this.lastName = new SimpleStringProperty(this, "lastName", lastName);
            this.injured = new SimpleBooleanProperty(this, "injured", international);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }

        public StringProperty lastNameProperty() {
            return lastName;
        }

        public boolean isInjuredl() {
            return injured.get();
        }

        public void setInjured(boolean international) {
            this.injured.set(international);
        }

        public BooleanProperty injuredProperty() {
            return injured;
        }

        @Override
        public String toString() {
            return firstName.get() + " " + lastName.get() + (injured.get() ? " true" : " false");
        }
    }
}

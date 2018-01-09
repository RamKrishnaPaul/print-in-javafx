/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author krish
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private RadioButton radioMale;
    @FXML
    private ToggleGroup myToggle;
    @FXML
    private RadioButton radioFemale;
    @FXML
    private Label lblradio;

    @FXML
    public void handleRadioAction(ActionEvent event) {
        String str = "";
        if (radioMale.isSelected()) {
            str += radioMale.getText();
        }
        if (radioFemale.isSelected()) {
            str += radioFemale.getText();
        }
        lblradio.setText(str);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

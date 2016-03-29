/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.exam;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Firas
 */
public class FirasController implements Initializable {

    @FXML
    private Text t1;
    @FXML
    private Button btn;

    @FXML
    private void SuivantAction(ActionEvent event) throws IOException {
        if (firas1 < ((exam.getListquestion().size()) - 2)) {
            firas1++;
            qinst = exam.getListquestion().get(firas1);

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        } else {
            firas1++;
            qinst = exam.getListquestion().get(firas1);

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras_1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        t1.setText(qinst.getQuestiontext());
    }

}

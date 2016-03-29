/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.exam;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import com.mooc.DAO.QuestionDAO;
import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Question;
import com.mooc.entities.Quiz;
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
public class Firas1Controller implements Initializable  {
    @FXML
    private Text t1;
    @FXML
    private Button btn;
    
    
     @FXML
     private void TerminerAction(ActionEvent event) throws IOException {
        
        
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        t1.setText(qinst.getQuestiontext());
    }
    
}

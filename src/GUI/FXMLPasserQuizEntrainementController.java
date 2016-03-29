/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.QuizlistController.idquiz1;
import com.mooc.DAO.QuestionDAO;
import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Question;
import com.mooc.entities.Quiz;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
 * FXML Controller class
 *
 * @author Firas
 */
public class FXMLPasserQuizEntrainementController implements Initializable {

    QuizDAO qd = new QuizDAO();
    QuestionDAO questd = new QuestionDAO();
    public static Quiz exam;
    public List<Question> qst = new ArrayList<>();
    public static Question qinst;
    public static int total;
    public static int firas1 = 0;

    @FXML
    private Text t1;

    @FXML
    private Text t2;

    @FXML
    private Text t3;
    @FXML
    private Button btn;

    @FXML
    private void CommancerAction(ActionEvent event) throws IOException {
        if (firas1 < ((exam.getListquestion().size()) - 2)) {
            firas1++;
            qinst = exam.getListquestion().get(firas1);
                if (qinst.getType()=="Choix unique")
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
                else if (qinst.getType()=="Choix multiple")
                {
                ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
                else
                {
                ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exam = qd.getquiz(idquiz1);
        exam.setListquestion(questd.ListByQuiz(idquiz1));
        t1.setText(exam.getQuiznom());
        t2.setText(exam.getQuizdescription());
        t3.setText(exam.getIntro());

        // TODO
    }

}

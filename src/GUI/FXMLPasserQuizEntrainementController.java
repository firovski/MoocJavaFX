/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.timeline;
import static GUI.QuizlistController.idquiz1;
import com.mooc.DAO.QuestionDAO;
import com.mooc.DAO.QuizDAO;
import com.mooc.entities.Question;
import com.mooc.entities.Quiz;
import com.mooc.entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

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
    public static int total=0;
    public static int totalpoint=0;
    public static int firas1 = -1;

    /**
     *
     */
    public static Timeline timeline;
                
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
            if (exam.getType().equals("Final")){
            timeline = new Timeline(new KeyFrame(
                        Duration.millis(exam.getDuree()*60000),
                        ae -> {
                            try {
                                doSomething(event);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLPasserQuizEntrainementController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }));
          
    timeline.play();
            }
            for(int i=0;i<exam.getListquestion().size();i++)
            {
                totalpoint=totalpoint+exam.getListquestion().get(i).getPoint();
            }
            
            
            
            
            firas1++;
            qinst = exam.getListquestion().get(firas1);
                List<Reponse> listrep = new ArrayList<>();

            listrep = qinst.getListreponse();
        if (qinst.getType().equals("Choix unique"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixUnique/FXMLChoixUnique1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixUnique/FXMLChoixUnique2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixUnique/FXMLChoixUnique3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixUnique/FXMLChoixUnique4.fxml"));
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
            loader.setLocation(getClass().getResource("Quiz/ChoixUnique/FXMLChoixUnique5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
        
        else if (qinst.getType().equals("Choix multiple"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixMultiple/FXMLChoixMultiple1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixMultiple/FXMLChoixMultiple2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixMultiple/FXMLChoixMultiple3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ChoixMultiple/FXMLChoixMultiple4.fxml"));
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
            loader.setLocation(getClass().getResource("Quiz/ChoixMultiple/FXMLChoixMultiple5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
        
        else if (qinst.getType().equals("Reponse par texte"))
        {
        if(listrep.size()==1)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ReponseText/FXMLReponseText1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==2)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ReponseText/FXMLReponseText2.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==3)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ReponseText/FXMLReponseText3.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        else if (listrep.size()==4)
                {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Quiz/ReponseText/FXMLReponseText4.fxml"));
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
            loader.setLocation(getClass().getResource("Quiz/ReponseText/FXMLReponseText5.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
                }
        }
                
        } else {
            firas1++;
            qinst = exam.getListquestion().get(firas1);

            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLFiras1.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        }

    }
    /**
     *
     * @param event
     * @return
     * @throws java.io.IOException
     */
    public KeyFrame doSomething(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/FXMLResultat.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show(); 
            return null;
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

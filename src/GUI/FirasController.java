/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.exam;
import static GUI.FXMLPasserQuizEntrainementController.firas1;
import static GUI.FXMLPasserQuizEntrainementController.qinst;
import com.mooc.entities.Reponse;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Firas
 */
public class FirasController implements Initializable {
    public static Reponse rep;

    @FXML
    private Text t1;
    @FXML
    private Button btn;
    @FXML
    private GridPane gp;
    @FXML
    RadioButton r1;

    final ToggleGroup group = new ToggleGroup();


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
        List<Reponse> listrep = new ArrayList<>();
        listrep= qinst.getListreponse();
        
        
        if (qinst.getType().equals("Choix unique")){
        for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
//            r1.setText(rep.getReponsetext());
  //          r1.setToggleGroup(group);
            gp.add(r1,0,i);
        }
            }
            else if (qinst.getType().equals("Choix multiple")) 
            {
                            System.out.println("Choix multiple");

                for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
            CheckBox c= new CheckBox(rep.getReponsetext());
           
            c.setId("chk"+i);
            gp.add(c,0,i);
        }
                
            }
            else
            {
            for (int i=0;i<listrep.size();i++)
        {  
            rep =listrep.get(i);
             TextField txt= new TextField();
            txt.setId("txt"+Integer.toString(i));
            gp.add(txt,1,i);
            Label ll = new Label(rep.getReponsetext());
            gp.add(ll,0,i);
        }
            }
            
        
    }

}

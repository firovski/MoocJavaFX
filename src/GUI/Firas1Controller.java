/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import static GUI.FXMLPasserQuizEntrainementController.qinst;
import static GUI.FirasController.rep;
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
public class Firas1Controller implements Initializable  {
    TextField txt= new TextField();

    @FXML
    private Text t1;
    @FXML
    private Button btn;
    @FXML
    private GridPane gp;
    
    final ToggleGroup group = new ToggleGroup();

    
    
     @FXML
     private void TerminerAction(ActionEvent event) throws IOException {
        if (qinst.getType().equals("Reponse par texte"))
                {
                    System.out.println(txt.getText());
                }
        ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLQuizlist.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
       
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
            RadioButton r1= new RadioButton(rep.getReponsetext());
            r1.setToggleGroup(group);
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
            txt.setId("txt"+Integer.toString(i));
            gp.add(txt,1,i);
            Label ll = new Label(rep.getReponsetext());
            gp.add(ll,0,i);
        }    
            }
    }
    
}


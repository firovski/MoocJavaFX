/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.FXMLPasserQuizEntrainementController.timeline;
import static GUI.FXMLPasserQuizEntrainementController.total;
import static GUI.FXMLPasserQuizEntrainementController.totalpoint;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class FXMLResultatController implements Initializable {
    @FXML
    private Text resultattext;
    @FXML
    private Text scoretext;
    MediaPlayer mediaplayer;
    Media musicsucce = new Media("file:///C:/Users/Firas/Music/song/congratulations.mp3");
    Media musicechoue = new Media("file:///C:/Users/Firas/Music/song/FailSoundEffect.mp3");

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(timeline.getCurrentTime().toSeconds());
        float x = 100*total/totalpoint;
        if (x>50){
        mediaplayer = new MediaPlayer(musicsucce);
        mediaplayer.setAutoPlay(true);
        }
        else
        {
        mediaplayer = new MediaPlayer(musicechoue);
        mediaplayer.setAutoPlay(true);
        }
scoretext.setText(Integer.toString(total)+"/"+Integer.toString(totalpoint));
resultattext.setText(Float.toString(x)+"%");
    }    
    
}

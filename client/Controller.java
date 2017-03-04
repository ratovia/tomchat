package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {


    //Text t1 = new Text();


    User user1 = new User(1, "name1");

//                t1.setText(user1.getIntID().toString());
    //  t1.setText(user1.getName());

    @FXML
    public Label showNameLabel;

    @FXML
    public void setNameonLabel(){
        showNameLabel.setText(user1.getName());
    }

    @FXML
    private TextField t1;

    @FXML
    private void setUserNameOnTextField(){
        //t1.setText(user1.getName());
    }
}

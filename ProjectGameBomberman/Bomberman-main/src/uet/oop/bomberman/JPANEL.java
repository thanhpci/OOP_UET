package uet.oop.bomberman;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import static javafx.scene.paint.Color.BLACK;

public class JPANEL extends AnchorPane{
    public Label labelLevel;

    public Label labelTime;

    public Label labelPoint;

    public Label labelLives;

    public JPANEL() {
        labelTime = new Label("TIME : " + BombermanGame.time);
        labelTime.setLayoutX(180);
        labelTime.setLayoutY(1);
        labelTime.setFont(Font.font(18));
        labelTime.setTextFill(BLACK);

        labelPoint = new Label("POINT : " + BombermanGame.score);
        labelPoint.setLayoutX(450);
        labelPoint.setLayoutY(1);
        labelPoint.setFont(Font.font(18));
        labelPoint.setTextFill(BLACK);

        labelLives = new Label("LIVES : " + BombermanGame.cout);
        labelLives.setLayoutX(800);
        labelLives.setLayoutY(1);
        labelLives.setFont(Font.font(18));
        labelLives.setTextFill(BLACK);
    }
    public void setPanel() {
        BombermanGame.ro.getChildren().addAll(labelTime,labelPoint,labelLives);
    }

//    public void setLevel(int t) {
//        labelLevel.setText("LEVEL : " + t);
//    }

    public void setTimes(int t) {
        labelTime.setText("TIMES : "+t);
    }

    public void setPoint(int t) {
        labelPoint.setText("POINT : "+t);
    }

    public void setLives(int t) {
        labelLives.setText("LIVES : "+t);
    }
}
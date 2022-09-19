package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;

public class Sound {
    private static Media media1 = new Media(new File("res/sound/AA126_11.wav").toURI().toString());
    private static Media media2 = new Media(new File("res/sound/BOM_11_M.wav").toURI().toString());
    private static Media media3 = new Media(new File("res/sound/BOM_SET.wav").toURI().toString());
    private static Media media4 = new Media(new File("res/sound/soundtrack.wav").toURI().toString());
    private static Media media5 = new Media(new File("res/sound/Item.wav").toURI().toString());
    private static Media media6 = new Media(new File("res/sound/CRYST_UP.wav").toURI().toString());
    private static Media media7 = new Media(new File("res/sound/endgame3.wav").toURI().toString());//qua man

    public static MediaPlayer no_bom = new MediaPlayer(media2);
    public static MediaPlayer dat_bom = new MediaPlayer(media3);
    public static MediaPlayer soundtrack = new MediaPlayer(media4);
    public static MediaPlayer enemyDie = new MediaPlayer(media1);
    public static MediaPlayer levelUp = new MediaPlayer(media6);
    public static MediaPlayer eatItem = new MediaPlayer(media5);
    public static MediaPlayer BomberDie = new MediaPlayer(media7);

}
package uet.oop.bomberman;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import uet.oop.bomberman.map.FileLevelLoader;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.movable.Bomber;
import uet.oop.bomberman.entities.movable.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static uet.oop.bomberman.sound.Sound.soundtrack;

public class BombermanGame extends Application {
    public static int WIDTH;        // chiều rộng của map
    public static int HEIGHT;
    public static int level = 1;
    public static GraphicsContext gc;
    private Canvas canvas;
    public static Scanner scanner;
    public static final List<Enemy> enemies = new ArrayList<>();        //danh sách quái
    public static final List<Entity> stillObjects = new ArrayList<>();  //danh sách đối tượng tĩnh
    public static final List<Flame> flameList = new ArrayList<>();      //danh sách flame
    public static int startBomb = 1;
    public static int startSpeed = 5;
    public static int startFlame = 1;
    //public static int time = 400;
    public static int time = 3;
    public static int score =0;
    public static int xStart;
    public static int yStart;
    public static Bomber bomberman;
    public static int cout = 3;                                          // mạng
    public static int countTime = 0;                                    //fps
    public static boolean check = false;
    public static AnchorPane ro = new AnchorPane();
    public static JPANEL jpanel = new JPANEL();

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        //tạo một Group chứa các đối tượng
        Group begin = new Group();

        //tạo màn hình, cỡ màn hình
        Scene sceneBegin = new Scene(begin, 992, 416);

        //tên cửa sổ
        stage.setTitle("BOMBERMAN");

        //thêm màn hình vào cửa sổ
        stage.setScene(sceneBegin);

        //show ra nội dung stage
        stage.show();


        Button startButton = new Button("Bắt đầu");

        startButton.setLayoutX(100);
        startButton.setLayoutY(208);


        startButton.setFont(new Font("Arial", 30));

        Image start = null;
        try {
            start = new Image(new FileInputStream("./1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView View = new ImageView(start);

        //cài đặt vị trí
        View.setX(0);
        View.setY(0);

        //cài đặt cỡ ảnh
        View.setFitHeight(416);
        View.setFitWidth(992);

        //Duy trì tỉ lệ
        View.setPreserveRatio(true);
        begin.getChildren().addAll(View, startButton);

        FileLevelLoader.createMap();
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT +25);
        gc = canvas.getGraphicsContext2D();
        Group root = new Group();
        root.getChildren().add(canvas);
        ro.getChildren().addAll(new Rectangle(2,3));
        jpanel.setPanel();
        root.getChildren().add(ro);
        Scene scene = new Scene(root);
        //stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
//        soundtrack.play();
//        soundtrack.seek(soundtrack.getStartTime());
        startButton.setOnAction(e -> {
            stage.setScene(scene);
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (check == true) {
                    FileLevelLoader.createMap();            //load map
                    check = false;
                }
                if (cout == 0) this.stop();
                render();
                update();
            }
        };
        timer.start();
        scene.setOnKeyPressed(event -> bomberman.handleKeyPressedEvent(event.getCode()));
        scene.setOnKeyReleased(event -> bomberman.handleKeyReleasedEvent(event.getCode()));
    }

    public void update() {
        if(countTime % 60 == 0){                            //fps: 60
            time--;
        }
//        if (time < 0) {
//            System.exit(0);
//        }
        jpanel.setTimes(time);
        jpanel.setPoint(score);
        jpanel.setLives(cout);
        for (int i = 0; i < enemies.size(); i++)
            enemies.get(i).update();
        for (int i = 0; i < flameList.size(); i++)
            flameList.get(i).update();
        bomberman.update();
        List<Bomb> bombs = bomberman.getBombs();
        for (Bomb bomb : bombs) {
            bomb.update();
        }

        for (int i = 0; i < stillObjects.size(); i++)
            stillObjects.get(i).update();
        bomberman.handleCollisions();
        bomberman.checkCollisionFlame();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = stillObjects.size() - 1; i >= 0; i--) {
            stillObjects.get(i).render(gc);
        }
        bomberman.render(gc);
        enemies.forEach(g -> g.render(gc));
//        for (Enemy enemy: enemies) {
//            enemy.render(gc);
//        }
        List<Bomb> bombs = bomberman.getBombs();
        bombs.forEach(b -> b.render(gc));
//        for (Bomb bomb : bombs) {
//            bomb.render(gc);
//        }
        coutTime();
        flameList.forEach(g -> g.render(gc));
    }
    public void coutTime() {
        if (countTime < 5*60) {
            countTime++;
        }
    }
}
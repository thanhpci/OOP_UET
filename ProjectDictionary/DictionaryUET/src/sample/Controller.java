package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML
    private Pane APIPane;

    @FXML
    private Pane editPane;

    @FXML
    private Circle circleExit;

    @FXML
    private Button translateBt;

    @FXML
    private HBox hBox;

    @FXML
    private ListView<String> listView;

    @FXML
    private ComboBox<String> comboBoxLangFrom;

    @FXML
    private ComboBox<String> comboBoxLangTo;

    @FXML
    private TextArea textAreaLangFrom;

    @FXML
    private TextArea textAreaLangTo;

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button saveAddBt;

    @FXML
    private Button saveChangeBt;

    @FXML
    private Button saveDeleteBt;

    @FXML
    private Label addTFLB;

    @FXML
    private Label addTALB;

    @FXML
    private Label changeOldTFLB;

    @FXML
    private Label changeNewTFLB;

    @FXML
    private Label changeTALB;

    @FXML
    private Label deleteTFLB;

    @FXML
    private Label saveChangeLB;

    @FXML
    private Label saveDeleteLB;

    @FXML
    private Label saveAddLB;

    @FXML
    private TextField deleteTF;

    @FXML
    private TextArea changeTA;

    @FXML
    private TextField changeNewTF;

    @FXML
    private TextField changeOldTF;

    @FXML
    private TextArea addTA;

    @FXML
    private Pane deletePane;

    @FXML
    private Pane addPane;

    @FXML
    private Pane changePane;

    @FXML
    private CheckBox deteleCB;

    @FXML
    private CheckBox addCB;

    @FXML
    private CheckBox changeCB;

    @FXML
    private Button EVspeechButton;

    @FXML
    private TextField addTF;

    private Speech speech = new Speech();

    private String itemSelected;
    private String langFrom;
    private String langTo;
    private String contentLangFrom;
    private String contentLangTo;
    private Map<String, String> wordMap = new HashMap<>();
    private ObservableList<String> wordEnglishObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setTranslateX(-201);
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.isBlank() || newValue.isEmpty() || newValue == null) {
                    TranslateTransition listViewTrans = new TranslateTransition();
                    listViewTrans.setNode(listView);
                    listViewTrans.setToX(-201);
                    listViewTrans.setDuration(Duration.seconds(0.2));
                    listViewTrans.play();

                    TranslateTransition hBoxTrans = new TranslateTransition();
                    hBoxTrans.setNode(hBox);
                    hBoxTrans.setToX(0);
                    hBoxTrans.setDuration(Duration.seconds(0.2));
                    hBoxTrans.play();
                    EVspeechButton.setVisible(false);
                }

                if (newValue.length() == 1) {
                    TranslateTransition listViewTrans = new TranslateTransition();
                    listViewTrans.setNode(listView);
                    listViewTrans.setToX(0);
                    listViewTrans.setDuration(Duration.seconds(0.2));
                    listViewTrans.play();

                    TranslateTransition hBoxTrans = new TranslateTransition();
                    hBoxTrans.setNode(hBox);
                    hBoxTrans.setToX(200);
                    hBoxTrans.setDuration(Duration.seconds(0.2));
                    hBoxTrans.play();
                }
            }
        });

        //search
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getBDConnection();

        String dbQuery = "SELECT * FROM test.tbl_edict";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOuput = statement.executeQuery(dbQuery);

            while (queryOuput.next()) {
                String queryWord = queryOuput.getString("word");
                String queryDetail = queryOuput.getString("detail");

                wordEnglishObservable.add(queryWord);
                wordMap.put(queryWord, queryDetail);
            }

            listView.setItems(wordEnglishObservable);
            FilteredList<String> filteredData = new FilteredList<>(wordEnglishObservable, b -> true);


            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(s -> {
                    String searchKeyWord = newValue.toLowerCase();

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    if (s.toLowerCase().startsWith(searchKeyWord)) {
                        return true;
                    } else
                        return false;
                });
            });

            SortedList<String> sortedData = new SortedList<>(filteredData, (o1, o2) -> {
                return (o1.compareTo(o2));
            });
            listView.setItems(sortedData);
        } catch (SQLException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newvalue) {
                itemSelected = listView.getSelectionModel().getSelectedItem();
                textArea.setText(wordMap.get(itemSelected));
                EVspeechButton.setVisible(true);
            }
        });

        //voice
        EVspeechButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                speech.speech(itemSelected);
            }
        });

        //API
        APIConnector apiConnector = new APIConnector();
        ObservableList<String> listLangFrom = comboBoxLangFrom.getItems();
        listLangFrom.addAll("Auto", "English", "Việt");
        ObservableList<String> listLangTo = comboBoxLangTo.getItems();
        listLangTo.addAll("English","Việt");
        comboBoxLangFrom.setValue("Auto");
        langFrom = comboBoxLangFrom.getValue();

        translateBt.disableProperty().bind(textAreaLangFrom.textProperty().isEmpty());
        translateBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                langFrom = comboBoxLangFrom.getValue().toLowerCase().substring(0, 2);
                langTo = comboBoxLangTo.getValue().toLowerCase().substring(0, 2);
                contentLangFrom = textAreaLangFrom.getText();
                contentLangTo = apiConnector.parseJSON(contentLangFrom, langFrom, langTo);
                textAreaLangTo.setText(contentLangTo);
            }
        });


        //Edit
        addPane.visibleProperty().bind(addCB.selectedProperty());
        deletePane.visibleProperty().bind(deteleCB.selectedProperty());
        changePane.visibleProperty().bind(changeCB.selectedProperty());

        saveAddBt.disableProperty().bind(addTF.textProperty().isEmpty().or(addTA.textProperty().isEmpty()));
        saveDeleteBt.disableProperty().bind(deleteTF.textProperty().isEmpty());
        saveChangeBt.disableProperty().bind( changeOldTF.textProperty().isEmpty().
                        or(changeNewTF.textProperty().isEmpty()).or(changeTA.textProperty().isEmpty()));

        deleteTFLB.visibleProperty().bind(deleteTF.textProperty().isEmpty());
        addTFLB.visibleProperty().bind(addTF.textProperty().isEmpty());
        addTALB.visibleProperty().bind(addTA.textProperty().isEmpty());
        changeOldTFLB.visibleProperty().bind(changeOldTF.textProperty().isEmpty());
        changeNewTFLB.visibleProperty().bind(changeNewTF.textProperty().isEmpty());
        changeTALB.visibleProperty().bind(changeTA.textProperty().isEmpty());


        saveAddBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word, detail;
                word = addTF.getText();
                detail = addTA.getText();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection DBConnect = databaseConnection.getBDConnection();
                String query = "INSERT INTO `tbl_edict`(`word`, `detail`) VALUES (\"" + word + "\",\"" + detail +"\")";
                try {
                    Statement statement = DBConnect.createStatement();
                    statement.executeUpdate(query);
                    //saveAddLB.setVisible(true);
                    saveAddLB.setText("them thanh cong");
                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setNode(saveAddLB);
                    fadeTransition.setDuration(Duration.seconds(1));
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.play();
                    addTF.setText("");
                    addTA.setText("");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    saveAddLB.setText("them that bai");
                }
            }
        });

        saveDeleteBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word;
                word = deleteTF.getText();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection DBConnect = databaseConnection.getBDConnection();
                String query = "DELETE FROM `tbl_edict` WHERE `word` = \"" + word + "\"";
                try {
                    Statement statement = DBConnect.createStatement();
                    statement.executeUpdate(query);
                    //saveDeleteLB.setVisible(true);
                    saveDeleteLB.setText("xoa thanh cong");
                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setNode(saveDeleteLB);
                    fadeTransition.setDuration(Duration.seconds(1));
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.play();
                    deleteTF.setText("");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    saveDeleteLB.setText("xoa that bai");

                }
            }
        });

        saveChangeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String wordOld, wordNew, detailNew;
                wordOld = changeOldTF.getText();
                wordNew = changeNewTF.getText();
                detailNew = changeTA.getText();
                DatabaseConnection databaseConnection = new DatabaseConnection();
                Connection DBConnect = databaseConnection.getBDConnection();
                String query = "UPDATE `tbl_edict` SET `word`=\"" + wordNew + "\",`detail`=\"" + detailNew
                        + "\" WHERE `word`=\"" + wordOld + "\"";
                try {
                    Statement statement = DBConnect.createStatement();
                    statement.executeUpdate(query);
                    //saveChangeLB.setVisible(true);
                    saveChangeLB.setText("thay doi thanh cong");
                    FadeTransition fadeTransition = new FadeTransition();
                    fadeTransition.setNode(saveChangeLB);
                    fadeTransition.setDuration(Duration.seconds(1));
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.play();
                    changeOldTF.setText("");
                    changeNewTF.setText("");
                    changeTA.setText("");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    saveChangeLB.setText("thay doi that bai");
                }
            }
        });
        //endEdit


    }

    public void exitProgram(MouseEvent mouseEvent) {
        System.exit(0);
    }


    public void EVbuttonClicked(MouseEvent mouseEvent) {
        textField.setDisable(false);
        textArea.setVisible(true);
        APIPane.setVisible(false);
        editPane.setVisible(false);
    }

    public void APIButtonClicked(MouseEvent mouseEvent) {
        textField.setDisable(true);
        textArea.setVisible(false);
        APIPane.setVisible(true);
        editPane.setVisible(false);
        EVspeechButton.setVisible(false);
    }

    public void editButtonClicked(MouseEvent mouseEvent) {
        textField.setDisable(true);
        textArea.setVisible(false);
        APIPane.setVisible(false);
        editPane.setVisible(true);
        EVspeechButton.setVisible(false);
    }
}

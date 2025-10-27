package Main;

import Lab1.Hero.HeroController;
import Lab2.AnnotationController;
import Lab3.TranslatorController;
import Lab4.StreamsController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class  Main extends Application {

    private VBox contentArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        ComboBox<String> selector = new ComboBox<>();
        selector.getItems().addAll("Работа 1", "Работа 2", "Работа 3", "Работа 4");
        selector.setPromptText("Выберите пункт");

        contentArea = new VBox(10);
        contentArea.setPadding(new Insets(10));

        selector.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateContent(newVal);
        });

        root.getChildren().addAll(selector, contentArea);
        Scene scene = new Scene(root, 550, 700);
        stage.setTitle("Курсовая работа");
        stage.setHeight(550);
        stage.setWidth(700);
        stage.setScene(scene);
        stage.show();
    }

    private void updateContent(String selectedValue) {
        contentArea.getChildren().clear();

        switch (selectedValue) {
            case "Работа 1":
                createType1Content(new HeroController());
                break;
            case "Работа 2":
                createType2Content(new AnnotationController());
                break;
            case "Работа 3":
                createType3Content(new TranslatorController());
                break;
            case "Работа 4":
                createType4Content(new StreamsController());
                break;
        }
    }

    private void createType1Content(HeroController heroController) {
        VBox heroInterface = heroController.createHeroInterface();
        contentArea.getChildren().add(heroInterface);
    }

    private void createType2Content(AnnotationController annotationController) {
        VBox heroInterface = annotationController.createAnnotationInterface();
        contentArea.getChildren().add(heroInterface);
    }

    private void createType3Content(TranslatorController translatorController) {
        VBox heroInterface = translatorController.createTranslatorInterface();
        contentArea.getChildren().add(heroInterface);
    }

    private void createType4Content(StreamsController sc) {
        VBox streams = sc.createStreamsInterface();
        contentArea.getChildren().add(streams);
    }
}
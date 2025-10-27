package Lab1.Hero;

import Lab1.MovingType.FlightMove;
import Lab1.MovingType.HorseMove;
import Lab1.MovingType.OnFootMove;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class HeroController {

    public Hero hero;
    public TextArea textArea;

    public HeroController() {
        this.hero = new Hero();
        textArea = new TextArea("");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(10);
        textArea.setMaxHeight(Double.MAX_VALUE);
    }

    public VBox createHeroInterface() {
        VBox heroBox = new VBox(10);
        heroBox.setPadding(new Insets(10));

        ComboBox<String> movementCombo = new ComboBox<>();
        movementCombo.getItems().addAll("Пешком", "На лошади", "Полёт");
        movementCombo.setPromptText("Выберите способ перемещения");

        Button moveButton = new Button("Переместиться");
        moveButton.setOnAction(e -> {
            String selectedMovement = movementCombo.getValue();
            if (selectedMovement != null) {
                performMovement(selectedMovement);
            } else {
                textArea.setText("Выберите способ перемещения!");
            }
        });

        Button finishButton = new Button("Завершить путь");
        finishButton.setOnAction(e -> {
            textArea.setText("Герой дошел до цели!\n" + textArea.getText());
        });

        heroBox.getChildren().addAll(
                new Label("Управление героем:"),
                new Label("Способ перемещения:"),
                movementCombo,
                moveButton,
                finishButton,
                new Label("Результат перемещения:"),
                textArea
        );

        return heroBox;
    }

    private void performMovement(String movementType) {
        String movementResult = "";

        switch (movementType) {
            case "Пешком":
                hero.setMoving(new OnFootMove());
                break;
            case "На лошади":
                hero.setMoving(new HorseMove());
                break;
            case "Полёт":
                hero.setMoving(new FlightMove());
                break;
            default:
                textArea.setText("Герой так не умеет!");
                return;
        }

        movementResult = hero.move();

        textArea.setText(movementResult + "\n" + textArea.getText());
    }
}
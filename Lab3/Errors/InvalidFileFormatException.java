package Lab3.Errors;

public class InvalidFileFormatException extends Throwable{
    private static final String text = "Невозможно прочитать файл такого формата!";

    public InvalidFileFormatException(String ext, String wExt) {
        super(text + " Ожидалось расширение " + ext + ". Передано: " + wExt);
    }
}

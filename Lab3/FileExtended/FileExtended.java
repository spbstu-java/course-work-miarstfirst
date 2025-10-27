package Lab3.FileExtended;

import Lab3.Errors.FileReadException;
import Lab3.Errors.InvalidFileFormatException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileExtended extends File  {

    private String pathname = "";
    private Map<String, String> content;
    private String contentString;

    /**
     * сразу при вызове конструктора попытаемся проверить файл на разщирение, доступ.
     * В случае успеха добавляем в content как ключ-значение
     */
    public FileExtended(String pathname, String format) throws FileReadException, InvalidFileFormatException {

        super(pathname);
        this.pathname = pathname;

        this.content = new HashMap<>();

        try (FileInputStream fileInput = new FileInputStream(this)) {
            InputStreamReader inputStream = new InputStreamReader(fileInput, "UTF-8");
            BufferedReader br = new BufferedReader(inputStream);
            String line;
            while ((line = br.readLine()) != null) {
                String[] line_ = line.split("\\|");

                if (line.contains("|") && line_.length == 2) {
                    content.put(line_[0], line_[1]);
                } else {
                    throw new FileReadException("Строка '" + line +  "' должна быть вида 'word | слово' ");
                }
            }
        } catch (IOException e) {
            throw new FileReadException("Невозможно прочитать файл " + e.getMessage());
        }

        if(!Objects.equals(getFileExtension(), format)){
            throw new InvalidFileFormatException(format, getFileExtension());
        }
    }

    public FileExtended(String pathname) throws FileReadException, InvalidFileFormatException {

        super(pathname);
        this.pathname = pathname;

        this.contentString = "";

        try (FileInputStream fileInput = new FileInputStream(this)) {
            InputStreamReader inputStream = new InputStreamReader(fileInput, "UTF-8");
            BufferedReader br = new BufferedReader(inputStream);
            String line;
            while ((line = br.readLine()) != null) {
                contentString += line + "\n";
            }
        } catch (IOException e) {
            throw new FileReadException("Невозможно прочитать файл " + e.getMessage());
        }
    }

    /**
     * возвращаем тип файла
     */
    public String getFileExtension(){
        int index = pathname.indexOf('.');
        return index == -1 ? null : pathname.substring(index);
    }

    /**
     * возвращаем набор прочитанных данных
     */
    public Map<String, String> getFileContent(){
        return content;
    }

    public String getFileContentString(){
        return contentString;
    }
}

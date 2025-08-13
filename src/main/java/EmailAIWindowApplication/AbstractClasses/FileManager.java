package EmailAIWindowApplication.AbstractClasses;


import java.io.IOException;
import java.nio.file.Path;


public abstract class FileManager {
    protected Path fileName;

    public FileManager(Path fileName){
        this.fileName = fileName;
    }

    public abstract boolean writeToFile(String text);

    public abstract void saveToFile(String text) throws IOException;

    public abstract String showContent();
}

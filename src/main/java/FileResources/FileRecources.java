package FileResources;

import FileManagerClasses.FileManagerClass;
import FileManagerClasses.FileManagerOpenAIClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class FileRecources {
    public static final Path HOST_ADDRESS = Paths.get(MAIN_PACKAGE_FILES,"hostAddress.txt");
    public static final Path POST_OFFICE = Paths.get(MAIN_PACKAGE_FILES,"postOfficeChoose.txt");
    public static final Path POST_PASSWORD = Paths.get(MAIN_PACKAGE_FILES,"postPassword.txt");
    public static final Path PLACE_OF_CHOICE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");
    public static final Path API_PATH = Paths.get(MAIN_PACKAGE_FILES , "APIKEY.txt");
    public static final Path TITLE_PATH = Paths.get(MAIN_PACKAGE_FILES , "emailTitleFile.txt");
    public final Path DESTRIPTION_PATH = Paths.get(MAIN_PACKAGE_FILES , "descriptionFile.txt");
    public final Path LINK = Paths.get(MAIN_PACKAGE_FILES, "link.txt");

    public final File apiFile = new File(String.valueOf(API_PATH));
    public final File hostAddressFile = new File(String.valueOf(HOST_ADDRESS));
    public final File postPasswordFile = new File(String.valueOf(POST_PASSWORD));
    public final File placeOfChoiceFile = new File(String.valueOf(PLACE_OF_CHOICE));
    public final File titleFile = new File(String.valueOf(TITLE_PATH));
    public final File descriptionFile = new File(String.valueOf(DESTRIPTION_PATH));
    public final File linkFile = new File(String.valueOf(LINK));

    public final FileManagerOpenAIClass apiKeySave = new FileManagerOpenAIClass(apiFile.toPath());
    public final FileManagerOpenAIClass postOfficeOption = new FileManagerOpenAIClass(POST_OFFICE);
    public final FileManagerOpenAIClass hostAddressSave = new FileManagerOpenAIClass(hostAddressFile.toPath());
    public final FileManagerOpenAIClass postPasswordSave = new FileManagerOpenAIClass(postPasswordFile.toPath());
    public final FileManagerOpenAIClass placeOfChoiceSave = new FileManagerOpenAIClass(placeOfChoiceFile.toPath());
    public final FileManagerOpenAIClass fileManagerTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());
    public final FileManagerOpenAIClass fileManagerDescriptionOpenAI = new FileManagerOpenAIClass(descriptionFile.toPath());

    public final FileManagerClass readLinkOfFile = new FileManagerClass(linkFile.toPath());

}

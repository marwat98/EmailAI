package EmailAIWindowAplication.FileResources;

import EmailAIWindowAplication.FileManagerClasses.FileManagerClass;
import EmailAIWindowAplication.FileManagerClasses.FileManagerOpenAIClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileRecources {
    public static final String MAIN_PACKAGE_FILES = "src/main/ProgramFiles";
    public static final Path HOST_ADDRESS = Paths.get(MAIN_PACKAGE_FILES,"hostAddress.txt");
    public static final Path POST_OFFICE = Paths.get(MAIN_PACKAGE_FILES,"postOfficeChoose.txt");
    public static final Path POST_PASSWORD = Paths.get(MAIN_PACKAGE_FILES,"postPassword.txt");
    public static final Path PLACE_OF_CHOICE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");
    public static final Path API_PATH = Paths.get(MAIN_PACKAGE_FILES , "APIKEY.txt");
    public static final Path TITLE_PATH = Paths.get(MAIN_PACKAGE_FILES , "emailTitleFile.txt");
    public static final Path DESTRIPTION_PATH = Paths.get(MAIN_PACKAGE_FILES , "descriptionFile.txt");
    public static final Path LINK = Paths.get(MAIN_PACKAGE_FILES, "link.txt");
    public static final Path FROM_PATH = Paths.get(MAIN_PACKAGE_FILES , "myEmailFile.txt");
    public final Path SEND_EMAIL_PATH = Paths.get(MAIN_PACKAGE_FILES, "sendEmailFile.txt");
    public final Path SEARCH_POLE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");

    public final File apiFile = new File(String.valueOf(API_PATH));
    public final File hostAddressFile = new File(String.valueOf(HOST_ADDRESS));
    public final File postPasswordFile = new File(String.valueOf(POST_PASSWORD));
    public final File placeOfChoiceFile = new File(String.valueOf(PLACE_OF_CHOICE));
    public final File titleFile = new File(String.valueOf(TITLE_PATH));
    public final File descriptionFile = new File(String.valueOf(DESTRIPTION_PATH));
    public final File linkFile = new File(String.valueOf(LINK));
    public final File myEmailFile = new File(String.valueOf(FROM_PATH));
    public final File sendEmailFile = new File(String.valueOf(SEND_EMAIL_PATH));
    public final File searchPoleFile = new File(String.valueOf(SEARCH_POLE));

    public final FileManagerOpenAIClass apiKeySave = new FileManagerOpenAIClass(apiFile.toPath());
    public final FileManagerOpenAIClass postOfficeOption = new FileManagerOpenAIClass(POST_OFFICE);
    public final FileManagerOpenAIClass hostAddressSave = new FileManagerOpenAIClass(hostAddressFile.toPath());
    public final FileManagerOpenAIClass postPasswordSave = new FileManagerOpenAIClass(postPasswordFile.toPath());
    public final FileManagerOpenAIClass placeOfChoiceSave = new FileManagerOpenAIClass(placeOfChoiceFile.toPath());
    public final FileManagerOpenAIClass fileManagerTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());
    public final FileManagerOpenAIClass fileManagerDescriptionOpenAI = new FileManagerOpenAIClass(descriptionFile.toPath());
    public final FileManagerClass fileSetYourEmailClass = new FileManagerClass(myEmailFile.toPath());
    public final FileManagerClass fileSendYourEmailClass = new FileManagerClass(sendEmailFile.toPath());
    public final FileManagerOpenAIClass saveTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());
    public final FileManagerOpenAIClass descriptionOpenAI = new FileManagerOpenAIClass(descriptionFile.toPath());

    public final FileManagerClass readLinkOfFile = new FileManagerClass(linkFile.toPath());
    public final FileManagerClass searchPole = new FileManagerClass(searchPoleFile.toPath());



}

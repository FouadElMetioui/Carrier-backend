package io.fouad.carrerbackend.fichier;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class FichierService {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();


    private static final String SERVICE_ACOUNT_KEY_PATH = getPathToGoogleCredentials();

    private static String getPathToGoogleCredentials() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            Path filePath = Paths.get(currentDirectory, "gcp.json");

            // Vérification si le fichier existe
            if (Files.exists(filePath)) {
                return filePath.toString();
            } else {
                throw new IllegalStateException("Le fichier de credentials Google 'gcp.json' est introuvable.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération du chemin des credentials Google", e);
        }
    }

    public String uploadImageToDrive(File file)  {

        try{
            String folderId = "1whoN-PIhtu-fXr_rSCrm9Qa_7QZg99j6";
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(file.getName());
            fileMetaData.setParents(Collections.singletonList(folderId));

            // Récupération dynamique du type MIME du fichier
            String mimeType = java.nio.file.Files.probeContentType(file.toPath());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            FileContent mediaContent = new FileContent(mimeType, file);
            com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
                    .setFields("id").execute();
            String fileUrl = "https://drive.google.com/uc?export=view&id="+uploadedFile.getId();
            System.out.println("FILE URL: " + fileUrl);
            file.delete();
            return fileUrl;

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "Faild to upload file to drive";
        }

    }

    private Drive createDriveService() throws GeneralSecurityException, IOException {

        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .build();

    }
}

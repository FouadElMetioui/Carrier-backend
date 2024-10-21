package io.fouad.carrerbackend.fichier;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FichierController {

    private final FichierService fichierService;

    @PostMapping("/uploadToGoogleDrive")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.println("vide");
            return "content not found";
        }
        File tempFile = File.createTempFile("temp", null);
        file.transferTo(tempFile);
        return fichierService.uploadImageToDrive(tempFile);
    }
}

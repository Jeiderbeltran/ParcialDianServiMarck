package org.mycompany.servimark.core.management;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    public String store(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(uploadDirectory).resolve(filename));
        return "/uploads/" + filename;
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(new File(uploadDirectory));
    }

    public void init() {
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}

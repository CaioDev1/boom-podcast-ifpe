package firebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageOptions;

import app_paths.AppPaths;

public class FirebaseController {
	private static com.google.cloud.storage.Storage storage;
	private static String bucket_name = "ifpe-boompodcast.appspot.com";
	
	public static void initFirebaseStorageConnetion() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(AppPaths.firebaseConfigPath);
		
		FirebaseController.storage = StorageOptions.newBuilder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .build().getService();
	}
	
	public static String uploadFile(MultipartFile multipartFile, String fileName, String folder) throws IOException {
		File file = FirebaseController.convertToFile(multipartFile, fileName);
		
		String file_path = folder.concat(fileName);
		
        BlobId blobId = BlobId.of(bucket_name, file_path);
        Map<String, String> map = new HashMap<>();
        map.put("firebaseStorageDownloadTokens", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
           .setMetadata(map)
           .setContentType(multipartFile.getContentType())
           .build();
        
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        
        file.delete();
        
        String encodedFilePath = URLEncoder.encode(file_path, StandardCharsets.UTF_8);
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        
        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media&token=%s", 
        	bucket_name, file_path, fileName);
    }

    private static File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }
}

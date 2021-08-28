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

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class FirebaseController {
	private static Storage storage;
	private static final String bucket_name = "ifpe-boompodcast.appspot.com";
		
	public static void initFirebaseStorageConnetion(String sdkString) throws IOException, JSONException {		
		sdkString = sdkString.replace("\n", "\\n");
		String sdkFilePath = System.getProperty("user.dir").concat("/firebase_admin_sdk.json");
		
		File sdkFile = new File(sdkFilePath);
		
		FileOutputStream fos = new FileOutputStream(sdkFile);
        fos.write(sdkString.getBytes());
        fos.close();
        
		FileInputStream sdkStream = new FileInputStream(sdkFilePath);
		
	    storage = StorageOptions.newBuilder()
	        .setCredentials(GoogleCredentials.fromStream(sdkStream))
	        .build().getService();
	}
	
	public static String uploadFile(MultipartFile multipartFile, String fileName, String folder) throws IOException {
		File file = convertToFile(multipartFile, fileName);
		
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
        
        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media&token=%s", 
        	bucket_name, URLEncoder.encode(file_path, StandardCharsets.UTF_8), URLEncoder.encode(fileName, StandardCharsets.UTF_8));
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

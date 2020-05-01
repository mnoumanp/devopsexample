package com.mobileservice.api.s3factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.mobileservice.api.model.DocumentModel;

@Service
public class S3Factory {

	@Autowired
	AmazonS3Client amazonS3Client;

	@Value("${s3.bucket.name}")
	String defaultBucketName;

	@Value("${s3.default.folder}")
	String defaultBaseFolder;

	@Value("${file.upload.base-url}")
	String baseUrl;

	public List<Bucket> getAllBuckets() {
		return amazonS3Client.listBuckets();
	}

	public void uploadFile(File uploadFile) {
		amazonS3Client.putObject(defaultBucketName, uploadFile.getName(), uploadFile);
	}

	public DocumentModel uploadFile(String name, byte[] content) {
		DocumentModel documentModel = new DocumentModel();
		File file = new File(name);
		file.canWrite();
		file.canRead();
		FileOutputStream iofs = null;
		try {
			iofs = new FileOutputStream(file);
			iofs.write(content);
			amazonS3Client.putObject(defaultBucketName, defaultBaseFolder + "/" + file.getName(), file);
			documentModel.setDocumentName(name);
			documentModel.setObjectKey(defaultBaseFolder + "/" + name);
			documentModel.setObjectUrl(baseUrl + "/" + defaultBaseFolder + "/" + name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return documentModel;

	}

	public byte[] getFile(String key) {
		S3Object obj = amazonS3Client.getObject(defaultBucketName, defaultBaseFolder + "/" + key);
		S3ObjectInputStream stream = obj.getObjectContent();
		try {
			byte[] content = IOUtils.toByteArray(stream);
			obj.close();
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

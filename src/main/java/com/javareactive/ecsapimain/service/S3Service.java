package com.javareactive.ecsapimain.service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import com.amazonaws.util.IOUtils;
import com.amazonaws.AmazonServiceException;
import java.io.IOException;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import com.javareactive.ecsapimain.dto.S3ObjectDto;
import com.amazonaws.AmazonClientException;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    //private Logger logger = LoggerFactory.getLogger();

    @Autowired
    private AmazonS3 s3client;

    @Value("${aws.s3-bucket}")
    private String bucketName;


    public byte[] downloadFile(String keyName){
        try {
            byte[] content = null;
            final S3Object s3Object = s3client.getObject(bucketName, keyName);
            final S3ObjectInputStream stream = s3Object.getObjectContent();
            try {
                content = IOUtils.toByteArray(stream);
//                logger.info("File downloaded successfully.");
                s3Object.close();
            } catch (final IOException ex) {
//                logger.info("IO Error Message= " + ex.getMessage());
            }
            return content;
        } catch (AmazonServiceException ase) {
//            logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
//            logger.info("Error Message:    " + ase.getMessage());
//            logger.info("HTTP Status Code: " + ase.getStatusCode());
//            logger.info("AWS Error Code:   " + ase.getErrorCode());
//            logger.info("Error Type:       " + ase.getErrorType());
//            logger.info("Request ID:       " + ase.getRequestId());
            throw ase;
        } catch (AmazonClientException ace) {
//            logger.info("Caught an AmazonClientException: ");
//            logger.info("Error Message: " + ace.getMessage());
            throw ace;
        }

    }
}

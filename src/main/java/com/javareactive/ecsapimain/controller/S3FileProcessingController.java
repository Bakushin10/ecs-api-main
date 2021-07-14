package com.javareactive.ecsapimain.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import com.javareactive.ecsapimain.service.S3Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3FileProcessingController {

//    @Autowired
//    S3Service s3Service;
//
//    @GetMapping("/api/file/download")
//    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam String keyName, @RequestParam String year) {
//        byte[] data = s3Service.downloadFile("Year-" + year + "/" + keyName);
//        final ByteArrayResource resource = new ByteArrayResource(data);
//
//        return ResponseEntity.ok().contentLength(data.length).contentType(customizedContentType(keyName))
//                .header("Content-type", "application/octet-stream")
//                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"").body(resource);
//    }

    private MediaType customizedContentType(String keyname) {
        String[] arr = keyname.split("\\.");
        String type = arr[arr.length - 1];
        switch (type) {
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "png":
                return MediaType.IMAGE_PNG;
            case "jpg":
                return MediaType.IMAGE_JPEG;
            case "pdf":
                return MediaType.APPLICATION_PDF;
            default:
                return MediaType.APPLICATION_OCTET_STREAM;
        }
    }


}

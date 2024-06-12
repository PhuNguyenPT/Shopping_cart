package com.example.shopping_cart.file;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;

@Service
public class FileMapper {

    public File toFile(MultipartFile multipartFile) {

        try {
            return File.builder()
                    .name(multipartFile.getOriginalFilename())
                    .fileType(multipartFile.getContentType())
                    .size(BigInteger.valueOf(multipartFile.getSize()))
                    .fileContent(toCompressedFileByteBase64(multipartFile.getBytes()))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Error converting MultipartFile to File");
        }
    }

    public byte[] toCompressedFileByteBase64(byte[] fileByte) {
        try {
            var compressedFileByte = FileUtil.compressByte(fileByte);
            return Base64.encodeBase64(compressedFileByte, true);
        } catch (Exception e) {
            throw new RuntimeException("Error compressing file byte array", e);
        }
    }

    public FileResponseDTO toFileResponseDTO(File file) {
        var compressedFileByte = Base64.decodeBase64(file.getFileContent(), 0, file.getFileContent().length);
        var fileByte = FileUtil.decompressByte(compressedFileByte);
//        var fileByte = FileUtil.decompressFile(file.getFileContent());
//        System.out.println(fileByte);
        return new FileResponseDTO(
                file.getName(),
                file.getFileType(),
                file.getSize(),
                fileByte
        );
    }
}

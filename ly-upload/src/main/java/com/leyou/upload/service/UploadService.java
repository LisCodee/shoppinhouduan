package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {

    private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg", "image/png", "imange/bmp");

    public String uploadImage(MultipartFile file) {
        try {
            //校验文件
            String contentType = file.getContentType();
            if(!ALLOW_TYPES.contains(contentType)){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            File dest = new File("D:\\leyou\\images\\",file.getOriginalFilename());
            file.transferTo(dest);
            //返回路径
            return "http://www.leyou.com/" + file.getOriginalFilename();
        } catch (IOException e) {
            log.error("上传文件失败" + e);
            throw new LyException(ExceptionEnum.FILE_UPLOAD_ERROR);
        }
    }
}

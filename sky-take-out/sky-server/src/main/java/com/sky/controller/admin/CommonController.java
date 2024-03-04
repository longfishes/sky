package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.LocalFileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用接口")
public class CommonController {

    /**
     * 文件上传
     * @param file 上传的文件
     * @return res
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}", file);
        try {
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));

            String filePath = LocalFileUtil.upload(file.getBytes(), UUID.randomUUID() + extension);

            return Result.success(filePath);
        } catch (Exception e) {
            log.error("文件上传失败：{}", e.toString());
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}

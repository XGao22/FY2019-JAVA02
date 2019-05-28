package com.neuedu.controller.backend;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-24 10:24
 **/

@Controller
@RequestMapping("/manage/")
public class UploadController {

    @Value("${business.imageHost}")
    private String imageHost;

    @GetMapping("upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("upload")
    @ResponseBody
    public ServerResponse upload(@RequestParam("uploadFile") MultipartFile upload){
//判断文件不为空
        if (upload == null || upload.getOriginalFilename().equals("")) {
            return ServerResponse.createServerResponseByFail(Const.PRODUCT_UPLOAD_IMAGE_EMPTY,"上传图片为空");
        }
        String fileName = upload.getOriginalFilename();
        //取出扩展名
        String exName = fileName.substring(fileName.lastIndexOf('.'));
        //获得随机文件名
        String newFileName = UUID.randomUUID().toString() + exName;
        //获取或创建路径
        File mkdir = new File("e:/upload");
        if (!mkdir.exists()) {
            mkdir.mkdirs();
        }
        //创建新文件
        File newFile = new File(mkdir,newFileName);
        try {
            //转换文件
            upload.transferTo(newFile);
            ImageVO imageVO = new ImageVO(newFileName,imageHost+newFileName);
            return ServerResponse.createServerResponseBySuccess("上传成功",imageVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ServerResponse.createServerResponseByFail(Const.PRODUCT_UPLOAD_IMAGE_FAIL,"上传图片失败");
    }
}

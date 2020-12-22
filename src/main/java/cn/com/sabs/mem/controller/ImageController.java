package cn.com.sabs.mem.controller;

import cn.com.sabs.mem.entity.dto.User;
import cn.com.sabs.mem.utils.UuidUtils;
import com.sun.tools.internal.ws.processor.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * 用于thymeleaf开发
 */
@Controller
@RequestMapping("/img")
@Slf4j
public class ImageController {

    @GetMapping("/toImgUpload")
    public ModelAndView toImgUpload(ModelAndView modelAndView){
        modelAndView.setViewName("thymeleaf/task/imgUpload");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, ModelMap map, HttpServletRequest request){
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UuidUtils.getUUid() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        map.addAttribute("filename", filename);
        return "redirect:/img/toImgUpload";

    }
}

package com.muskteerathos.facelooker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by wanglei on 2016/10/3.
 */
@Controller
@RequestMapping({"/face/*"})
public class FaceController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        sb.append("serverName:" + request.getServerName())
                .append("serverPort:" + request.getServerPort());
        return sb.toString();
    }

}

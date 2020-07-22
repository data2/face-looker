package com.muskteerathos.facelooker.common.imageio;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by wanglei on 2016/10/5.
 * 截取图片的一部分.
 * Beijing.
 */
public class InterceptPhoto {

    /**
     * 截取图片中指定矩形内容.
     *
     * @param filePath
     * @param outFilePath
     * @param rectangle
     * @throws IOException
     */
    public static void intercept(String filePath, String outFilePath, Rectangle rectangle) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        ImageInputStream is = ImageIO.createImageInputStream(fs);

        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("JPG");
        ImageReader reader = it.next();
        reader.setInput(is, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceRegion(rectangle);
        BufferedImage bi = reader.read(0, param);
        // 保存新图片
        ImageIO.write(bi, "JPG", new File(outFilePath));
    }

    /**
     * demo
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\foreign.JPG";
        String outFilePath = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\out.JPG";
        intercept(filePath, outFilePath, new Rectangle(200, 100, 50, 50));
    }
}

package com.muskteerathos.facelooker.common.opencv.product;

import com.muskteerathos.facelooker.common.imageio.InterceptPhoto;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

import java.awt.*;
import java.io.IOException;

public class FaceDetector {

    static String haarcascade_frontalface_alt = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\haarcascade_frontalface_alt.xml";
    static CascadeClassifier faceDetector;

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        faceDetector = new CascadeClassifier(haarcascade_frontalface_alt);
    }

    /**
     * 人脸识别
     *
     * @param filePath
     * @param outFilePath
     */
    public static void detect(String filePath, String outFilePath) {
        System.out.println("Face detector begin.");
        Mat image = Highgui.imread(filePath);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(203, 192, 255));
        }
        System.out.println(String.format("Writing %s", outFilePath));
        Highgui.imwrite(outFilePath, image);
    }

    /**
     * 人脸识别并且存储（支持单人）
     *
     * @param filePath
     * @param outFilePath
     */
    public static void detectSingleAndSave(String filePath, String outFilePath) throws IOException {
        System.out.println("Face detector begin.");
        Mat image = Highgui.imread(filePath);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        if (faceDetections.toArray().length != 1) return;
        Rect rect = faceDetections.toArray()[0];
        InterceptPhoto.intercept(filePath, outFilePath, new Rectangle(rect.x, rect.y, rect.width, rect.height));
    }

    /**
     * demo
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\static\\tiger.JPG";
        String outFilePath = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\out.JPG";
        detect(filePath, outFilePath);
    }
}
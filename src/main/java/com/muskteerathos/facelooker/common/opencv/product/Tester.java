package com.muskteerathos.facelooker.common.opencv.product;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class Tester {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");

        CascadeClassifier faceDetector = new CascadeClassifier("F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\haarcascade_frontalface_alt.xml");
        Mat image = Highgui
                .imread("F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\static\\foreign.JPG");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        String outFilePath = "F:\\my_sofware\\idea2016\\project\\facelooker\\src\\main\\resources\\out.JPG";

        System.out.println(String.format("Writing %s", outFilePath));
        Highgui.imwrite(outFilePath, image);
    }
}

import cv2


video_capture = cv2.VideoCapture(0)
cv2.namedWindow("frame", cv2.WINDOW_NORMAL)
cv2.setWindowProperty("frame", cv2.WND_PROP_FULLSCREEN, cv2.WND_PROP_FULLSCREEN)
video_capture.set(cv2.CAP_PROP_FRAME_WIDTH, 1920)
video_capture.set(cv2.CAP_PROP_FRAME_HEIGHT, 1080)
while True:
    ret, frame = video_capture.read()
    # (h, w) = frame.shape[:2]
    # print(h, w)
    # center = (w/2, h/2)
    # print()
    # M = cv2.getRotationMatrix2D(center, 90, 1.0)
    # rotated = cv2.warpAffine(frame, M, (1920, 1080))
    # cv2.imshow('image', rotated)
    # cv2.imwrite('2.png', rotated)
    # cv2.waitKey(0)
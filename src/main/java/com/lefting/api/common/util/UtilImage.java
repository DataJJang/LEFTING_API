package com.lefting.api.common.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class UtilImage {

	/**
	 * 파일(File) 객체를 이미지(BufferedImage) 객체로 변환
	 * @param file 변환할 파일 객체
	 * @param ext 이미지의 확장자(jpg,gif,png..)
	 * @return
	 * @throws IOException
	 */
    public static BufferedImage readImage(File file, String ext) throws IOException {
    	BufferedImage image = null;
		Graphics2D g2d = null;
    	InputStream picture = new FileInputStream(file);
    	ByteArrayOutputStream buf = new ByteArrayOutputStream();
    	byte[] b = new byte[10240];
    	int l = 0;
    	while ((l = picture.read(b)) >= 0) {
             buf.write(b, 0, l);
    	}
    	buf.close();
    	byte[] picturedata = buf.toByteArray();
    	buf = null;
    	picture.close();
    	try {
    		image = ImageIO.read(new ByteArrayInputStream(picturedata));
    		if(ext.equals("gif") == false) {
    			g2d = (Graphics2D) image.getGraphics();
    			g2d.drawImage(image, 0, 0, null);
    			g2d.dispose();
    		}
    	} catch (IIOException e) {

    	}
    	return image;
    }
}

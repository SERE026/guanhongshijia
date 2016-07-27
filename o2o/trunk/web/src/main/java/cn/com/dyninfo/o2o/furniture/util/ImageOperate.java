package cn.com.dyninfo.o2o.furniture.util;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageOperate {


	/**
	 * 给图片加水印，但不改变大小
	 * @param strOriginalFileName String(原始文件)
	 * @param strWaterMarkFileName String(水印后)
	 */
	public void waterMark(String strOriginalFileName,String strWaterMarkFileName,int flag,int type){
		try{
			//源文件
			File fileOriginal = new File(strOriginalFileName);
			Image imageOriginal = ImageIO.read(fileOriginal);
			int widthOriginal = imageOriginal.getWidth(null);
			int heightOriginal = imageOriginal.getHeight(null);
//	System.out.println("widthOriginal:" + widthOriginal + "theightOriginal:" + heightOriginal);

			BufferedImage bufImage = new BufferedImage(widthOriginal,heightOriginal,BufferedImage.TYPE_INT_RGB);
			Graphics g = bufImage.createGraphics();
			g.drawImage(imageOriginal,0,0,widthOriginal,heightOriginal,null);

			//水印文件
			File fileWaterMark = new File(strWaterMarkFileName);
			Image imageWaterMark = ImageIO.read(fileWaterMark);
			int widthWaterMark = imageWaterMark.getWidth(null);
			int heightWaterMark = imageWaterMark.getHeight(null);
//	System.out.println("widthWaterMark:" + widthWaterMark + "theightWaterMark:" + heightWaterMark);
			switch(flag){
				case 0:
				{
					int cx=0;
					int cy=0;
					switch(type){
						case 0://左上角
							break;
						case 1:{//顶居中
							cx=(widthOriginal-widthWaterMark)/2;
							break;
						}
						case 2:{//右上角
							cx=widthOriginal-widthWaterMark;
							break;
						}
						case 3:{//左居中
							cy=(heightOriginal-heightWaterMark)/2;
							break;
						}
						case 4:{//居中
							cy=(heightOriginal-heightWaterMark)/2;
							cx=(widthOriginal-widthWaterMark)/2;
							break;
						}
						case 5:{//右居中
							cy=(heightOriginal-heightWaterMark)/2;
							cx=widthOriginal-widthWaterMark;
							break;

						}case 6:{//左下角
							cy=heightOriginal-heightWaterMark;
							break;
						}
						case 7:{//下居中
							cy=heightOriginal-heightWaterMark;
							cx=(widthOriginal-widthWaterMark)/2;
							break;
						}
						case 8:{//右下角
							cy=heightOriginal-heightWaterMark;
							cx=widthOriginal-widthWaterMark;
							break;
						}
					}
					//水印文件在源文件的右下角
					g.drawImage(imageWaterMark,cx,cy,widthWaterMark,heightWaterMark,null);
					break;
				}
				case 1:{
					Font font=Font.getFont("微软雅黑");
					BufferedImage zmImage = new BufferedImage(0, 0,BufferedImage.TYPE_INT_RGB);
					Graphics fg = zmImage.createGraphics();
					fg.setFont(font);
					int fontWidth=fg.getFontMetrics().stringWidth(strWaterMarkFileName);
					int fontHeight=fg.getFontMetrics().getHeight();


					int cx=0;
					int cy=0;
					switch(type){
						case 0://左上角
							break;
						case 1:{//顶居中
							cx=(widthOriginal-fontWidth)/2;
							break;
						}
						case 2:{//右上角
							cx=widthOriginal-fontWidth;
							break;
						}
						case 3:{//左居中
							cy=(heightOriginal-fontHeight)/2;
							break;
						}
						case 4:{//居中
							cy=(heightOriginal-fontHeight)/2;
							cx=(widthOriginal-fontWidth)/2;
							break;
						}
						case 5:{//右居中
							cy=(heightOriginal-fontHeight)/2;
							cx=widthOriginal-fontWidth;
							break;

						}case 6:{//左下角
							cy=heightOriginal-fontHeight;
							break;
						}
						case 7:{//下居中
							cy=heightOriginal-fontHeight;
							cx=(widthOriginal-fontWidth)/2;
							break;
						}
						case 8:{//右下角
							cy=heightOriginal-fontHeight;
							cx=widthOriginal-fontWidth;
							break;
						}
					}
					g.drawString(strWaterMarkFileName, cx, cy);
				}
			}

			g.dispose();

//			FileOutputStream fos = new FileOutputStream(strOriginalFileName);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
//			encoder.encode(bufImage);
//			fos.flush();
//			fos.close();
//			fos = null;
			ImageIO.write(bufImage,  "jpeg" , new File(strWaterMarkFileName));
			bufImage.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 修改图片大小
	 */
	public void alterSize(String srcImgFile,String newFileName,int new_w,int new_h){
		java.io.File file=new java.io.File(srcImgFile);
		if(!file.exists())
			return ;

		String newUrlName=newFileName;
		//System.out.print("新文件名为"+newUrlName);
		Image src=null;
		try
		{
			src = javax.imageio.ImageIO.read(file);
			java.awt.image.BufferedImage tag = new java.awt.image.BufferedImage(new_w,new_h,java.awt.image.BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);
			tag.getGraphics().drawImage(
					src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH),0, 0, null);
//			FileOutputStream newimage=new FileOutputStream(newUrlName);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
//			encoder.encode(tag); //近JPEG编码
//			newimage.close();
			ImageIO.write(tag,  "jpeg" , new File(newUrlName));
			tag.flush();
		}
		catch(IIOException ee)
		{
			ee.printStackTrace();
//			System.out.print("这里出错了");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//End sizeAlter
}

package toaster;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class ToasterGetOffPC {

	public static void main(String[] args) {
		String imgPath = "/home/stoilov/Pictures/glasses_dog.jpg";

		Toaster toaster = new Toaster();
		toaster.setToasterWidth(450);
		toaster.setToasterHeight(300);
		toaster.setStep(200);

		File img = new File(imgPath);
		try {
			Image scaled = ImageIO.read(img).getScaledInstance(450, 300,
					Image.SCALE_DEFAULT);
			toaster.setBackgroundImage(scaled);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(new Date() + "\n");
			Thread.sleep(5 * 60 * 10);
			toaster.showToaster("Get a little rest, will you?");
			System.out.println(new Date() + "\n");
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}
	}

}

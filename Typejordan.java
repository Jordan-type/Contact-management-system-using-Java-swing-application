package cms;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JORDAN TYPE
 */
public class Typejordan {

    public ImageIcon resizepic(String picpath, byte[] BLOBpic, int wdth, int hgt) {
        ImageIcon mutype;

        if (picpath != null) {
            mutype = new ImageIcon(picpath);
        } else{
        mutype = new ImageIcon(BLOBpic);
        }

        //ImageIcon mutype = new ImageIcon(picpath);
        Image img = mutype.getImage().getScaledInstance(wdth, hgt, Image.SCALE_SMOOTH);
        ImageIcon mypicture = new ImageIcon(img);

        return mypicture;
    }

    public String browseImage(JLabel lbl) {
        String path = "";
        JFileChooser filej = new JFileChooser();
        filej.setCurrentDirectory(new File(System.getProperty("user.home")));

        // file extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.images", "jpg", "png", "gif");
        filej.addChoosableFileFilter(fileFilter);

        int filestate = filej.showSaveDialog(null);

        // if user select a file
        if (filestate == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filej.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            //imagepth = path;
            // display the image in the lbl_image using resize image
            lbl.setIcon(resizepic(path,null, lbl.getWidth(), lbl.getHeight()));
            
            

            //lbl_image.setIcon(new ImageIcon(path));
        } // if user cancel
        else if (filestate == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image was Selected !!");
        }
        return path;
    }
}

package managers;

/**
 * Created by val on 20/09/15.
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BarCode {
    // Tutorial: http://javapapers.com/core-java/java-qr-code/

    private static void createCode(final String qrCodeData, final String filePath, final String charset, int size) throws Exception {
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        createQRCode(qrCodeData, filePath, charset, hintMap, size, size);
        System.out.println("QR Code image created successfully! filePath : " + filePath);
        //System.out.println("Data read from QR Code: " + readQRCode(filePath, charset, hintMap));
    }

    public static String addToBottle(Long bottleId) {
        // TODO Change location for production environnement
        final String qrCodeData = "localhost:9000/bottle/" + bottleId.toString();
        // TODO Change location for production environnement
        final String filePath = "/Users/val/Workspace/maCave/public/images/qr/" + bottleId + ".png";
        final String charset = "UTF-8";

        try {
            createCode(qrCodeData, filePath, charset, 200);
        } catch (Exception e){
            System.out.println("--- EXCEPTION --- Verifier le filePath !");
        }
        return ("images/qr/" + bottleId + ".png");
    }

    public static String addToCave(Long caveId) {
        // TODO Change location for production environnement
        final String qrCodeData = "localhost:9000/cave";
        // TODO Change location for production environnement
        final String filePath = "/Users/val/Workspace/maCave/public/images/caves/" + caveId + ".png";
        final String charset = "UTF-8";

        try {
            createCode(qrCodeData, filePath, charset, 200);
        } catch (Exception e){
            System.out.println("--- EXCEPTION --- Verifier le filePath !");
        }
        return ("images/caves/" + caveId + ".png");
    }

    private static void createQRCode(final String qrCodeData, final String filePath, final String charset, Map hintMap, int qrCodeheight, int qrCodewidth) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
    }

    private static String readQRCode(final String filePath, final String charset, Map hintMap) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
        return qrCodeResult.getText();
    }
}

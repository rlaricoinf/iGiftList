package com.ryy.giftlist.bean;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenerator {
	public static void main(String[] args) {
        String data = "http://172.233.17.96:8080/iGiftList/"; // Cambia esto a la URL o texto que quieras codificar
        String filePath = "QRCode.png"; // Ruta donde se guardara el QR
        int width = 300; // Ancho de la imagen
        int height = 300; // Altura de la imagen

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            File file = new File(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", file.toPath());
            System.out.println("Código QR generado: " + filePath);
        } catch (Exception e) {
            System.err.println("Error al generar el código QR: " + e.getMessage());
        }
    }
}

package com.pluralsight.data;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public static void saveReceipt(Order order) {

        try {
            Files.createDirectories(Path.of("receipts"));
        } catch (IOException e) {
            System.out.println("Unable to create a receipt file");
            return;
        }

        String timestamp = generateTimestamp();
        String fileName = "receipts/" + timestamp + ".txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("======= Provision Lab Receipt =======\n");
            writer.write("Timestamp: " + timestamp + "\n\n");

            for (var item : order.getItems()) {
                writer.write(item.toString() + "\n\n");
            }

            writer.write("-------------------------------\n");
            writer.write("Total: $" + String.format("%.2f", order.getTotal()) + "\n");
            writer.write("===============================\n");

            writer.close();
            System.out.println("Receipt saved: " + fileName);

        } catch (IOException e) {
            System.out.println("Unable to make the receipt");
            e.printStackTrace();
        }
    }

    private static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter);
    }
}

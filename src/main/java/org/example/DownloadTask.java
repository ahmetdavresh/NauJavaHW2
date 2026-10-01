package org.example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadTask implements Task {
    private final String fileUrl;
    private final String destinationPath;

    private volatile boolean isRunning = false;
    private Thread downloadThread;

    public DownloadTask(String fileUrl, String destinationPath) {
        this.fileUrl = fileUrl;
        this.destinationPath = destinationPath;
    }

    @Override
    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;

        downloadThread = new Thread(() -> {
            BufferedInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new BufferedInputStream(new URL(fileUrl).openStream());
                out = new FileOutputStream(destinationPath);

                byte[] buffer = new byte[8192];
                int bytesRead;

                while (isRunning && (bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                if (!isRunning) {
                    System.out.println("Скачивание прервано, удаляем неполный файл...");
                    File incomplete = new File(destinationPath);
                    if (incomplete.exists()) {
                        incomplete.delete();
                    }
                } else {
                    System.out.println("Скачивание завершено успешно!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Гарантированно закрываем потоки
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isRunning = false;
            }
        });

        downloadThread.start();
    }

    @Override
    public void stop() {
        isRunning = false;
    }
}
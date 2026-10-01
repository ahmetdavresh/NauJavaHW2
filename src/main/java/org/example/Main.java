package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://httpbin.org/bytes/102400";
        String path = "downloaded_file.bin";

        Task task = new DownloadTask(url, path);

        System.out.println("Запуск скачивания...");
        task.start();
        Thread.sleep(500);
        System.out.println("Останавливаем...");
        //task.stop();

        Thread.sleep(3000);
        System.out.println("Файл скачан.");
    }
}
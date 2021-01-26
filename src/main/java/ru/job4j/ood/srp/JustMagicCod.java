package ru.job4j.ood.srp;

import java.io.File;

public class JustMagicCod {
    private String getTextFromFile(File file) {
        //тут идет считывание из файла с помощью потока и сохранение скажем
        // в String
        String val = new String();
        return val;
    }

    private void sendText() {
        // тут идет отправка текста клиенту через Socket
        // То есть создается сервер, открывается соединение
        // и отравляется клиенту текст считанный из файла.
    }
}

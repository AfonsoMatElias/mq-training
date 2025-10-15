package br.com.fiap.CryptographyClientServer.core;

import br.com.fiap.CryptographyClientServer.CryptographyClientServerApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Base64;

public class Connection {
    public static String receive(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();

        byte[] infoBytes = new byte[256];
        int readBytes = in.read(infoBytes);

        if (readBytes == 0)
            return "";

        return Base64.getEncoder().encodeToString(infoBytes);
    }

    public static PublicKey receiveKey(Socket socket) throws Exception {
        InputStream in = socket.getInputStream();

        byte[] infoBytes = new byte[2048];
        int readBytes = in.read(infoBytes);

        if (readBytes == 0)
            return null;

        return CryptographyClientServerApplication.bytesToKey(infoBytes);
    }

    public static void send(Socket socket, String content) throws IOException {
        byte[] requestBytes = Base64.getDecoder().decode(content);
        OutputStream out = socket.getOutputStream();
        out.write(requestBytes);
    }

    public static void sendKey(Socket socket, PublicKey key) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write(key.getEncoded());
    }
}

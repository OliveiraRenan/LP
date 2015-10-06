package socket.cliente;

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ClienteUDP {

    public static void main(String args[]) throws Exception {
        DatagramSocket socket = null;
        DatagramPacket request = null;
        DatagramPacket reply = null;
        int serverPort = 0;
        byte[] buf = new byte[1024];

        // Pegar parametros 
        String nomeServidor = "localhost";
        String numeroPorta = "6789";
        String mensagemEnviar = "HORA";

        // Inicializacao de sockets UDP com Datagrama 
        socket = new DatagramSocket();

        // Configuracao a partir dos parametros 
        InetAddress host = InetAddress.getByName(nomeServidor);
        serverPort = new Integer(numeroPorta).intValue();
        byte[] m = mensagemEnviar.getBytes();

        // Criacao do Pacote Datagrama para Envio 
        request = new DatagramPacket(m, m.length, host, serverPort);

        // Envio propriamente dito 
        socket.send(request);

        // Preparacao do Pacote Datagrama para Recepcao 
        reply = new DatagramPacket(buf, buf.length);

        // Recepcao do retorno 
        socket.receive(reply);

        // Imprime na tela o retorno 
        System.out.println("Retornou: [" + new String(reply.getData()) + "]");

        // Finaliza tudo 
        socket.close();
    }
}

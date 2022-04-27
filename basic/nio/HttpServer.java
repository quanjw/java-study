package basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(10086));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            int count = selector.select();
            if (count != 0){
                Set<SelectionKey> selectionKeys =selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()){
                        AcceptHandler acceptHandler = new AcceptHandler();
                        acceptHandler.connSocketChannel(selectionKey);
                    }else if(selectionKey.isReadable()) {
                        HttpRequest httpRequest = new HttpRequest();
                        httpRequest.parse(selectionKey);
                        System.out.println("httpRequest:"+httpRequest);

                        if (httpRequest.getRequestURI() == null || httpRequest.getRequestURI().equals("")){
                            selectionKey.channel();
                            continue;
                        }

                        HttpResponse httpResponse = new HttpResponse();
                        httpResponse.setHttpRequest(httpRequest);
                        httpResponse.sendStaticResource(selectionKey);
                        System.out.println("httpResponse:"+httpResponse);
                    }
                }
                iterator.remove();
            }


        }
    }
}

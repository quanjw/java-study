package basic.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

public class HttpRequest {
    private String method;
    private String requestURI;
    private String version;

    private HashMap<String,String> headers = new HashMap<>();

    public void parse(SelectionKey selectionKey){
        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            StringBuilder stringBuilder = new StringBuilder();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len;
            while (((len = socketChannel.read(byteBuffer)) > 0)){
                byteBuffer.flip();
                //System.out.println(new String(byteBuffer.array(),0,len));
                stringBuilder.append(new String(byteBuffer.array(),0,len));
                byteBuffer.clear();
            }
            parseHttpRequest(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseHttpRequest(StringBuilder stringBuilder) {

        String httpRequestStr = stringBuilder.toString();
        String[] split = httpRequestStr.split("\r\n");

        String httpRequestLine = split[0];

        String[] httpRequestInfo = httpRequestLine.split(" ");
        this.setMethod(httpRequestInfo[0]);
        this.setRequestURI (httpRequestInfo[1]);
        this.setVersion(httpRequestInfo[2]);

        for (int i = 1; i < split.length ; i++) {
            String httpRequestHeaderInfo = split[i];
            String[] httpRequestHeaderInfoArr = httpRequestHeaderInfo.split(": ");
            this.headers.put(httpRequestHeaderInfoArr[0],httpRequestHeaderInfoArr[1]);
        }
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", requestURI='" + requestURI + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}

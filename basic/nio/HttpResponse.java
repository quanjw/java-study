package basic.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpResponse {
    private String version;
    private String status;
    private String desc;
    private String body;



    private HashMap<String,String> headers = new HashMap<>();

    private HttpRequest httpRequest;

    public void sendStaticResource(SelectionKey selectionKey){
        this.setVersion("HTTP/1.1");
        this.setStatus("200");
        this.setDesc("ok");
        String responseLine = this.getVersion()+" "+this.getStatus()+" "+this.getDesc()+"\r\n";

        headers.put("Content-Type","text/html;charset=UTF-8");

        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String,String>> entries = headers.entrySet();
        for (Map.Entry<String,String> entry:entries){
            stringBuilder.append(entry.getKey()+": "+entry.getValue()+"\r\n");
        }

        String emptyLine = "\r\n";
        String responseLineStr = responseLine+stringBuilder.toString()+emptyLine;

        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.wrap(responseLineStr.getBytes(StandardCharsets.UTF_8));
            socketChannel.write(byteBuffer);

            this.setBody("<body><h1>hellow world</h1></body>");
            ByteBuffer byteBuffer2 = ByteBuffer.wrap(this.getBody().getBytes(StandardCharsets.UTF_8));
            socketChannel.write(byteBuffer2);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                ", headers=" + headers +
                '}';
    }
}

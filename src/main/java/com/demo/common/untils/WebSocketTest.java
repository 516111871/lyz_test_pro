package com.demo.common.untils;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * /websocket.ws/{id} = /websocket.ws/{登录用户编号}
 */
@ServerEndpoint(value ="/websocket.ws/{id}")
public class WebSocketTest {

    private static final Map<String, WebSocketTest> WEBSOCKET = new ConcurrentHashMap<String, WebSocketTest>();

    private Session session;

    private String host;

    private HttpSession httpSession;
    /**
     * 用户登录账号
     */
    private String id;

    @OnOpen
    public void onOpen( Session session,EndpointConfig config,@PathParam("id") String id) {
        this.id = id;
        this.session = session;
        // 这里就获得到IP咯
        System.out.println("客户端请求IP："+session.getUserProperties().get("client-ip"));
        // ....
    }

    @OnClose
    public void onClose() {
        if (WEBSOCKET != null && WEBSOCKET.containsKey(id)){
            WebSocketTest webSocket = WEBSOCKET.get(id);
            if(webSocket.session.getId().equals(session.getId())){
                WEBSOCKET.remove(id);
            }
        }
        System.out.println("有一连接关闭！当前在线人数为" + WEBSOCKET.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        /* 不接收前端发送的消息 */
        System.out.println(message);

        sendMessage("收到");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    protected void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 广播
     *
     * @param message
     */
    public static void broadcast(String message) {
        for (Map.Entry<String, WebSocketTest> entry : WEBSOCKET.entrySet()) {
            entry.getValue().sendMessage(message);
        }
    }

    /**
     * 发送消息
     * @param id
     * @param message
     */
    public static void sendMessage(String id,String message){
        WEBSOCKET.get(id).sendMessage(message);
    }

}

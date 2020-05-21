package com.demo.common.untils;

import com.demo.common.DemoConfig;
import com.jfinal.server.undertow.UndertowServer;

public class Application {

    public static void main(String[] args) {
//        JFinal.start("webapp", 80, "/", 5);

        UndertowServer.create(DemoConfig.class).configWeb(builder  -> {
//            builder.addListener("com.demo.listener.WebServletRequestListener");
            builder.addWebSocketEndpoint("com.demo.common.untils.WebSocketTest");
        }).start();
    }
}

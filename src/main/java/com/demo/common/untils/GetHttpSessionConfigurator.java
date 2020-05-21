package com.demo.common.untils;


import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * 由于websocket的协议与Http协议是不同的，
 * 所以造成了无法直接拿到session。
 * 但是问题总是要解决的，不然这个websocket协议所用的场景也就没了
 * 重写modifyHandshake，HandshakeRequest request可以获取httpSession
 *
 * @author zlx-雄雄
 * @ClassNmae：GetHttpSessionConfigurator
 * @date 2017-11-3 15:47:13
 */
public class GetHttpSessionConfigurator extends Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

        HttpSession httpSession = (HttpSession) request.getHttpSession();

        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);

    }
}
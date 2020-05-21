package com.demo.common.untils;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
        /**
        * websocket请求handler
        */
public class WebSocketHandler extends Handler {

    private Pattern filterUrlRegxPattern;

    public WebSocketHandler(String filterUrlRegx) {
        if (StrKit.isBlank(filterUrlRegx))
            throw new IllegalArgumentException("The para filterUrlRegx can not be blank.");
        System.err.println("-----"+filterUrlRegx);
        filterUrlRegxPattern = Pattern.compile(filterUrlRegx);
    }
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
//        if (filterUrlRegxPattern.matcher(target).find()){
//            System.err.println("---==--"+filterUrlRegxPattern);
//            return ;
//        } else {
//            next.handle(target, request, response, isHandled);
//        }
        if(target.indexOf("/WSwebsocket") == -1){
            next.handle(target, request, response, isHandled);
            System.err.println(target);
        }
            System.err.println("SSSSSS");

    }

}





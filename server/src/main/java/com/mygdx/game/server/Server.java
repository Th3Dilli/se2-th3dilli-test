package com.mygdx.game.server;


import com.mygdx.game.Network.NetCore;

public class Server {

    public static void main(String[] args) {
        System.out.println("hi from server");
        System.out.println(NetCore.msg);
        System.out.println(NetCore.printMsg());
    }
}

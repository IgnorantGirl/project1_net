package TalkDemo;

public class TalkStudent {
    public static void main(String[] args) {
        //学生自己端口：7777------>发送给老师端口：9999
        //学生接收端口：8888
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"老师")).start();
    }
}

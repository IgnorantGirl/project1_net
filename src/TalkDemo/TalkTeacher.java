package TalkDemo;

public class TalkTeacher {
    public static void main(String[] args) {
        //老师自己端口:5555--->发送给学生端口：8888
        //老师接收端口：9999
        new Thread(new TalkSend(+5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}

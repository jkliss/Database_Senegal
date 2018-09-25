import javafx.application.Platform;
import javafx.scene.control.Label;

import java.net.InetAddress;

public class Connectivity implements Runnable {
    Label label;

    public boolean pingServer(String ip){
        boolean online = false;
        try{
            InetAddress address = InetAddress.getByName(ip);
            online = address.isReachable(100);
        } catch (Exception e){
            e.printStackTrace();
        }
        return online;
    }

    public void updateLoop(){
        while(true){
            if(pingServer("127.0.0.1")){
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        label.setText("Online");
                    }
                });
            } else {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        label.setText("Online");
                    }
                });
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public void run() {
        updateLoop();
    }
}

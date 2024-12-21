
package service;

import events.publicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import model.Mua;


public class Service {

    /**
     * @return the user
     */
 

    /**
     * @return the client
     */
 
    private static Service instance;
    private Socket client;
    private JTextArea textArea;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Mua user;
    
    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
        
    }
    private Service(){
        
    }
    
    public void startServer(){
        try {
        client = IO.socket("http://"+IP+ ":" +PORT_NUMBER);
        client.on("list_user", new Emitter.Listener() {
            @Override
            public void call(Object... os) {
                // list user
                List<Mua> user= new ArrayList<>();
                for(Object o:os){
                    user.add(new Mua(o));
                    
                }
                publicEvent.getInstance().getEevEventMenuL().newUser(user);
             }
        });
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }
       public Socket getClient() {
        return client;
    }
          public Mua getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Mua user) {
        this.user = user;
    }
    
    private void error(Exception e){
    
        System.err.println(e);
    }
     
}

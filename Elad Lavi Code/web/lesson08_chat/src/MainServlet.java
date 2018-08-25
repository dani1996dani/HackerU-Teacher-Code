
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends javax.servlet.http.HttpServlet {

    ArrayList<Message> messages;
    Map<String, String> users;

    @Override
    public void init() throws ServletException {
        messages = new ArrayList<>();
        users = new HashMap<>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String qs = request.getQueryString();
        if(qs == null)
            return;
        String[] params = qs.split("&");
        String action = params[0];
        String userName, password;
        switch (action){
            case "send":
                if(params.length != 4)
                    return;
                userName = params[2];
                password = params[3];
                if(!valid(userName, password))
                    return;

                messages.add(new Message(params[1], userName));
                response.getWriter().write("ok");
                break;
            case "receive":
                if(params.length != 4)
                    return;
                userName = params[2];
                password = params[3];
                if(!valid(userName, password))
                    return;
                int from = Integer.valueOf(params[1]);
                JSONArray jsonArray = new JSONArray();
                for (int i = from; i < messages.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("content", messages.get(i).content);
                        jsonObject.put("sender", messages.get(i).sender);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                }
                response.getWriter().write(jsonArray.toString());
                break;
            case "signup": {
                if (params.length != 3)
                    return;
                userName = params[1];
                password = params[2];
                if (users.containsKey(userName)) {
                    response.getWriter().write("user_name_taken");
                } else {
                    users.put(userName, password);
                    response.getWriter().write("ok");
                }
                break;
            }
            case "login":
                if(params.length != 3)
                    return;
                userName = params[1];
                password = params[2];
                response.getWriter().write(
                        valid(userName, password)
                                ? "ok" : "failure");
                break;
        }

    }

    boolean valid(String userName, String password){
        if(users.containsKey(userName)){
            if(users.get(userName).equals(password))
                return true;
        }
        return false;
    }

}
class Message{
    String content, sender;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }
}

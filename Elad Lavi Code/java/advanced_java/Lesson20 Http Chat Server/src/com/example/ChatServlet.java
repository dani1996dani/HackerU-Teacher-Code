package com.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ChatServlet extends javax.servlet.http.HttpServlet {


    public static final String SIGNUP = "signup";
    public static final String LOGIN = "login";
    public static final String PULL = "pull";
    public static final String SEND = "send";
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String SENDER = "sender";
    public static final String CONTENT = "content";
    //private List<Message> messages;
    //private Map<String, String> users;


    @Override
    public void init() throws ServletException {
        super.init();

        //messages = new ArrayList<>();
        //users = new HashMap<>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if(action == null)
            return;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(userName == null || password == null)
            return;
        switch (action) {
            case SIGNUP:
                response.getWriter().write(signup(userName,password) ? OK : ERROR);
                break;
            case LOGIN:
                response.getWriter().write(login(userName,password) ? OK : ERROR);
                break;
            case PULL:
                String fromString = request.getParameter("from");
                if(fromString == null)
                    return;
                int from = 0;
                try{
                    from = Integer.valueOf(fromString);
                }catch (Exception ex){
                    return;
                }
                response.getWriter().write(listToJson(pull(from)).toString());
                break;
            case SEND:
                String content = request.getParameter(CONTENT);
                if(content == null)
                    return;
                response.getWriter().write(send(userName,password,content) ? OK : ERROR);
                break;
            default:
                return;
        }


    }

    public static JSONArray listToJson(List<Message> messages){
        JSONArray jsonMessages = new JSONArray();

        for(Message message : messages){
            JSONObject jsonMessage = new JSONObject();

            try {
                jsonMessage.put(SENDER, message.getSender());
                jsonMessage.put(CONTENT, message.getContent());
                jsonMessage.put("messageId", message.getMessageId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonMessages.put(jsonMessage);
        }
        return jsonMessages;
    }


    private boolean validateUser(String userName, String password, Connection conn){
        if(userName == null || userName.length() == 0 || password == null || password.length() == 0){
            return false;
        }
        /*
        String pass = users.get(userName);
        return pass != null && pass.equals(password);
        */
        try(PreparedStatement statement = conn.prepareStatement("SELECT password FROM users WHERE user_name=?")){
            statement.setString(1, userName);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    String passFromDb = resultSet.getString(1);
                    return password.equals(passFromDb);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean signup(String userName, String password){
        if(userName == null || userName.length() == 0 || password == null || password.length() == 0){
            return false;
        }
        /*
        synchronized (users){
            if(!users.containsKey(userName)){
                users.put(userName,password);
                return true;
            }
        }
        */
        try(Connection conn = getConn()){
            try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE user_name=?")){
                statement.setString(1, userName);
                try(ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next())
                        return false;
                }
            }
            try(PreparedStatement statement = conn.prepareStatement("INSERT INTO users VALUES (?,?)")){
                statement.setString(1, userName);
                statement.setString(2, password);
                return statement.executeUpdate() == 1;
            }
        }catch (SQLIntegrityConstraintViolationException ex){
            return false;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean login(String userName, String password){
        try(Connection conn = getConn()){
            return validateUser(userName,password, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean send(String userName, String password, String content){
        //this.messages.add(new Message(userName,content));
        try(Connection conn = getConn()) {
            if(!validateUser(userName,password,conn))
                return false;
            try(PreparedStatement statement = conn.prepareStatement("INSERT INTO messages(content,user_name) VALUES (?,?)")){
                statement.setString(1,content);
                statement.setString(2,userName);
                return statement.executeUpdate() == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Message> pull(int from){
        List<Message> messages = new ArrayList<>();
        /*
        for (int i = from; i < this.messages.size(); i++) {
            messages.add(this.messages.get(i));
        }
        */
        try(Connection conn = getConn()){
            try(PreparedStatement statement = conn.prepareStatement("SELECT message_id,content,user_name FROM messages WHERE message_id>=?")){
                statement.setInt(1,from);
                try(ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        Message message = new Message(resultSet.getString(3), resultSet.getString(2));
                        message.setMessageId(resultSet.getInt(1));
                        messages.add(message);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }





    public static Connection getConn() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connection = "jdbc:mysql://localhost:3306/chatdb?useSSL=false";
        String user = "root";
        String password = "q1w2e3!";
        return DriverManager.getConnection(connection, user, password);
    }
}

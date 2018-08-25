import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends javax.servlet.http.HttpServlet {

    public static final String FAILURE = "FAILURE";
    public static final String OK = "OK";
    private Map<String, String> users;

    @Override
    public void init() throws ServletException {
        super.init();

        users = new HashMap<>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(action == null || userName == null || password == null)
            return;
        switch (action){
            case "login":
                response.getWriter().write(login(userName,password) ? OK : FAILURE);
                break;
            case "signup":
                response.getWriter().write(signup(userName,password) ? OK : FAILURE);
                break;
        }
    }

    private boolean login(String userName, String password){
        if(!users.containsKey(userName))
            return false;
        String existingPassword = users.get(userName);
        return existingPassword.equals(password);
    }

    private boolean signup(String userName, String password){
        boolean success = false;
        synchronized (users){
            if(!users.containsKey(userName)){
                users.put(userName,password);
                success = true;
            }
        }
        return success;
    }
}

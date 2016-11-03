package servlets;

import entity.ChatMessage;
import entity.ChatUser;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ChatServlet extends javax.servlet.http.HttpServlet {

    // Карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<ChatMessage> messages;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void init() throws ServletException {
        // Вызвать унаследованную от HttpServlet версию init()
        super.init();
        // Извлечь из контекста карту текущих пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>)
                getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>)
                getServletContext().getAttribute("messages");
        // Если карта пользователей ещѐ не определена ...
        if (activeUsers == null) {
            // Создать новую карту
            activeUsers = new HashMap<>();
            // Поместить еѐ в контекст сервлета,
            // чтобы другие сервлеты могли до неѐ добраться
            getServletContext().setAttribute("activeUsers", activeUsers);
        }
        // Если список сообщений ещѐ не определѐн ...
        if (messages == null) {
            // Создать новый список
            messages = new ArrayList<>(100);
            // Поместить его в контекст сервлета,
            // чтобы другие сервлеты могли до него добраться
            getServletContext().setAttribute("messages", messages);
        }
    }
}

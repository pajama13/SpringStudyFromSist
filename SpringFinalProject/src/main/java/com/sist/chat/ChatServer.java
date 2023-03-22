package com.sist.chat;
import java.util.*;
import java.net.HttpURLConnection;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
@ServerEndpoint("/site/chat/chat-ws") //=> Tiles 사용하지 않음
public class ChatServer {
	//접속한 유저들 저장, 중복 비허용
	private static List<Session> users=new ArrayList<Session>();
	
	//클라이언트가 입장했을 때
	@OnOpen
	public void onOpen(Session session)
	{
		//HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//		HttpSession se=request.getSession();
		users.add(session);
		System.out.println("클라이언트 접속..."+session.getId());
	}
	//클라이언트가 퇴장했을 때
	@OnClose
	public void onClose(Session session)
	{
		//HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//HttpSession se=request.getSession();
		users.remove(session);
		System.out.println("클라이언트 퇴장..."+session.getId());
	}
	//클라이언트가 채팅메세지를 전송했을 때
	@OnMessage
	public void onMessage(String message,Session session) throws Exception
	{
		System.out.println("수신메세지:"+message);
		//HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//HttpSession se=request.getSession();
		//String name=(String)se.getAttribute("name");
		Iterator<Session> iterator=users.iterator();
		System.out.println("채팅인원:"+users.size());
		while(iterator.hasNext()) //접속한 모든 사람
		{
			iterator.next().getBasicRemote().sendText(message); //접속한 모든사람 한테 값 보내기
		}
	}
}

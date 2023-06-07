package co.micol.notice.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.notice.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		session.invalidate(); //세션 삭제
		request.setAttribute("message", name+"님 로그아웃 되었습니다.");
		return "member/memberMessage" ;
	}

}

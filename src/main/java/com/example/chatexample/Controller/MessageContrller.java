package com.example.chatexample.Controller;

import com.example.chatexample.Service.MemberService;
import com.example.chatexample.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MessageContrller{

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String loginGet(Member member) {
        return "index";
    }
    @PostMapping("/")
    public String loginPost(HttpSession session, Member member) {
        Member memberNow = memberService.findByid(member.getId()).get();

        //로그인 성공
        if (memberNow.getPw().equals(member.getPw())){
            session.setAttribute("memberId", member.getId());
            System.out.printf("로그인 성공");
            return "redirect:/chat";
        }
        // 로그인 실패
        else {
            System.out.println("패스워드가 일치하지 않습니다.");
            return "redirect:/";
        }
    }
    @GetMapping("/join")
    public String joinGet(Member member) {
        return "join";
    }
    @PostMapping("/join")
    public String joinPost(Member member) {
        memberService.save(member);
        System.out.printf(member + "가 가입되었습니다");

        return "redirect:/";
    }
    @GetMapping("/chat")
    public String chatGET(HttpSession session) {
        System.out.printf("@MessageContrller, chat GET()");

        return "chat";
    }
}

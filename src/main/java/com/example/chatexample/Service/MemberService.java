package com.example.chatexample.Service;

import com.example.chatexample.Repository.MemberReopository;
import com.example.chatexample.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberReopository memberReopository;
    public void save(Member member){
        memberReopository.save(member);
    }
    public Optional<Member> findByid(String id) {
        return memberReopository.findById(id);
    }
}

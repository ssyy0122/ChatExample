package com.example.chatexample.Repository;

import com.example.chatexample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberReopository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);

}

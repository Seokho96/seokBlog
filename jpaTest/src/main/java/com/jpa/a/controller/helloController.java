package com.jpa.a.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.a.entity.member;
import com.jpa.a.repository.MemberRepository;


@RestController
@RequestMapping("/member")
public class helloController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	/*
	 @GetMapping("/insert") // CREATE
	    public member insert(){
	        return memberRepository.save(
	                new member("seokdata", 20, "인천")
	        );
	    }
	*/ 
	
	@PostMapping("/insert") // CREATE
    public member insert(@RequestBody Map<String, String> map){
        return memberRepository.save(
                new member(map.get("name"), intParser(map.get("age")), map.get("address"))
        );
    }

    @GetMapping("/select") // READ
    public List<member> selectAll(){
        return memberRepository.findAll();
    }

    @GetMapping("/select/{id}") // READ
    public member selectOne(@PathVariable("id") long id){
        return memberRepository.findById(id).orElse(null);
    }

    @PostMapping("/update/{id}") // UPDATE
    public member updateOne(@PathVariable("id") long id, @RequestBody Map<String, String> map){
        System.out.println(id);
        System.out.println(map);
        member member = memberRepository.findById(id).orElse(null);
        member.setName(map.get("name"));
        member.setAge(intParser(map.get("age")));
        member.setAddress(map.get("address"));
        return memberRepository.save(member);
    }

    @PostMapping("/delete/{id}") // DELETE
    public String deleteOne(@PathVariable("id") long id){
        memberRepository.deleteById(id);
        return "삭제 완료";
    }

    int intParser(String age){
        try{
            return Integer.parseInt(age);
        } catch(ClassCastException e){
            e.printStackTrace();
            return 0;
        }
    }

}

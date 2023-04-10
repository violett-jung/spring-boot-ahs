package studio.thinkground.testproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.testproject.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //http://localhost:8080/api/v1/put-api/default
    @PutMapping(value="/default")
    public String putMethod(){
        return "Hello World!";
    }

    //http://localhost:8080/api/v1/put-api/member
    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->
                sb.append(map.getKey() + " : " + map.getValue() + "\n"));

        return sb.toString();
    }

    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping("/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping("/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO){
        return memberDTO;
    }

    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping("/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }



}

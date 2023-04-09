package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String getHello(){
        return "hello world";
    }

    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "name") //@RequestMapping + GETmethod
    public String getName(){
        return "mimi";
    }

    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?
    //name=mimi&
    //email=mimi@gmail.com&
    //organization=thinkground
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + "," + email + "," + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=va1ue1&key2=value2
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        /* Stringbuilder 문자열을 효율적으로 처리하기 위한 클래스(연산시 새로운 객체 사용안해도됨 -> 성능향상)
         * Stringbuilder로 만든 객체의 값을 꺼내오려면 .toString() 사용해야함
         */

        param.entrySet().forEach(map ->
        {sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

//        for (Map.Entry<String, String> entrySet : param.entrySet()) {
//            sb.append(entrySet.getKey() + ":" + entrySet.getValue() + "\n");
//        }
        // 일반적인 for문으로 표현하면 다음과 같다

        return sb.toString();

        /* 맵에 저장된 모든 데이터를 가져오기 위해서는 Map 인터페이스의 entrySet 메서드를 사용
         * => Map 인터페이스에서는 entrySet() 메서드를 통해 맵에 저장된 모든 데이터를
         * Map.Entry 타입의 객체로 구성된 Set 컬렉션 형태로 반환
         * => 즉 Set<Map.Entry<K,V>> 으로 바꿔주며 Set의 각 요소는 Map.Entry<K,V>) */
    }

    //http://localhost:8080/api/v1/get-api/request3?name=mimi&email=mimi@gmail.com&organization=thinkground
    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        //return memberDTO.getName() + " " memberDTO.getEmail() + " " + memberDTO.getOrganization()
        return memberDTO.toString();
    }
}

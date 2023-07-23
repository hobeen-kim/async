package async.controller;

import async.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventListenerController {

    private final MemberService memberService;

    @GetMapping("/event")
    public String event(String username) {
        String savedMember = memberService.save(username);
        return savedMember;
    }

    @GetMapping("/eventException")
    public String eventException(String username) {
        String savedMember = memberService.saveException(username);
        return savedMember;
    }


}

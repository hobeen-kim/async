package async.service;

import async.event.dto.MemberEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public String save(String username){

        applicationEventPublisher.publishEvent(new MemberEventDto(username));

        log.info("member saving... : {}", username);
        log.info("member saved : {}", username);

        return username;
    }

    public String saveException(String username){

        applicationEventPublisher.publishEvent(new MemberEventDto(username));

        log.info("member saving... : {}", username);
        exception(username);
        return username;
    }

    public void exception(String username){
        log.info("member save Exception!! : {}", username);
        throw new RuntimeException("member save Exception!! : " + username);
    }
}

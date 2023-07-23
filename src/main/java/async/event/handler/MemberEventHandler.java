package async.event.handler;

import async.event.dto.MemberEventDto;
import async.event.transactionevent.AfterTransactionEvent;
import async.service.EmailService;
import async.service.PushService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
@RequiredArgsConstructor
public class MemberEventHandler {

    private final EmailService emailService;
    private final PushService pushService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void process(MemberEventDto memberEventDto) {
        emailService.sendEmail(memberEventDto.getUsername());
        pushService.sendPush(memberEventDto.getUsername());
    }
}

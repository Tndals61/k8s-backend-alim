package com.welab.k8s_backend_alim.event.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import com.welab.k8s_backend_alim.event.consumer.message.user.SiteUserInfoEvent;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageConsumer {
    @KafkaListener(topics = SiteUserInfoEvent.Topic, properties = {JsonDeserializer.VALUE_DEFAULT_TYPE+ ":com.welab.k8s_backend_alim.event.consumer.message.user.SiteUserInfoEvent"})
    void handleSiteUserInfoMessage(SiteUserInfoEvent event, Acknowledgment ack) {
        log.info("SiteUserInfoEvent 처리. userID={}", event.getUserId());

        ack.acknowledge();
    }
}

package ru.rtmis.melfor.calc.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.rtmis.melfor.calc.dto.CalcDto;
import ru.rtmis.melfor.calc.service.math.MathOperationService;

import static ru.rtmis.melfor.calc.util.KafkaConstants.ADDITION;
import static ru.rtmis.melfor.calc.util.KafkaConstants.CALC;
import static ru.rtmis.melfor.calc.util.KafkaConstants.KAFKA_LISTENER_CONTAINER_FACTORY;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimpleAdditionConsumerService implements AdditionConsumerService {
    private final ObjectMapper objectMapper;
    private final MathOperationService mathOperationService;

    @Override
    @KafkaListener(topics = {ADDITION}, containerFactory = KAFKA_LISTENER_CONTAINER_FACTORY, groupId = CALC)
    public void consume(CalcDto calcDto) {
        log.info("=> consumed {} from " + ADDITION, writeValueAsString(calcDto));
        mathOperationService.add(calcDto);
    }

    private String writeValueAsString(CalcDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}

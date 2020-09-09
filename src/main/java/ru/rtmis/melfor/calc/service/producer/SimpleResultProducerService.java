package ru.rtmis.melfor.calc.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.rtmis.melfor.calc.dto.ResultDto;

import static ru.rtmis.melfor.calc.util.KafkaConstants.RESULT;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleResultProducerService implements ResultProducerService {

    private final KafkaTemplate<Long, ResultDto> kafkaCalcTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void produce(ResultDto resultDto) {
        log.info("<= sending {} to {}", writeValueAsString(resultDto), RESULT);
        kafkaCalcTemplate.send(RESULT, resultDto);
    }

    private String writeValueAsString(ResultDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}

package ru.rtmis.melfor.calc.service.math;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rtmis.melfor.calc.dto.CalcDto;
import ru.rtmis.melfor.calc.dto.ResultDto;
import ru.rtmis.melfor.calc.service.producer.ResultProducerService;

@Service
@RequiredArgsConstructor
public class SimpleMathOperationService implements MathOperationService {
    private final ResultProducerService resultProducerService;

    @Override
    public void add(CalcDto calcDto) {
        ResultDto resultDto = new ResultDto(calcDto.getFirst() + calcDto.getSecond());
        resultProducerService.produce(resultDto);
    }

    @Override
    public void multiply(CalcDto calcDto) {
        ResultDto resultDto = new ResultDto(calcDto.getFirst() * calcDto.getSecond());
        resultProducerService.produce(resultDto);
    }
}

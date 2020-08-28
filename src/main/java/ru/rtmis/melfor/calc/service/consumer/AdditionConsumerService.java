package ru.rtmis.melfor.calc.service.consumer;

import ru.rtmis.melfor.calc.dto.CalcDto;

public interface AdditionConsumerService {
    void consume(CalcDto calcDto);
}

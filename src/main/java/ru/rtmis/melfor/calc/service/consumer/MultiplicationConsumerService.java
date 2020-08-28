package ru.rtmis.melfor.calc.service.consumer;

import ru.rtmis.melfor.calc.dto.CalcDto;

public interface MultiplicationConsumerService {
    void consume(CalcDto calcDto);
}

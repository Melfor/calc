package ru.rtmis.melfor.calc.service.producer;

import ru.rtmis.melfor.calc.dto.ResultDto;

public interface ResultProducerService {

    void produce(ResultDto resultDto);
}

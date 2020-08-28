package ru.rtmis.melfor.calc.service.math;

import ru.rtmis.melfor.calc.dto.CalcDto;

public interface MathOperationService {
    void add(CalcDto calcDto);

    void multiply(CalcDto calcDto);
}

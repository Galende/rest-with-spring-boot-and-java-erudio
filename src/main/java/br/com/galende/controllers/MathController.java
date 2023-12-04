package br.com.galende.controllers;

import br.com.galende.converters.NumberConverter;
import br.com.galende.exceptions.UnsupportedMathOperationException;
import br.com.galende.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();
    private String strNumber;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/subt/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subt (
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.subt(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult (
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mult(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div (
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.div(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media (
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.media(NumberConverter.convertToDouble(numberOne), (NumberConverter.convertToDouble(numberTwo)));
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt (
            @PathVariable (value = "number") String number
    ) throws Exception {
        if(!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sqrt(NumberConverter.convertToDouble(number));
    }
}

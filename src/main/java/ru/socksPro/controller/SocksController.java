package ru.socksPro.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.socksPro.DTO.SocksDTO;
import ru.socksPro.pojo.Operation;
import ru.socksPro.service.SocksService;

/**
 * Класс-кондроллер для работы со складом носков
 */
@RestController
@RequestMapping("/api/socks")
@Data
@RequiredArgsConstructor
public class SocksController {
    private final SocksService socksService;

    /**
     *Регистрирует приход носков на склад.

     */
     @PostMapping("/income")
    public void addSocks(@RequestBody SocksDTO socksDTO){
 socksService.addSocks(socksDTO);

    }
    /**
     *Регистрирует отпуск носков со склада.
     */
    @PostMapping("/outcome")
    public void removeSocksSocks(@RequestBody SocksDTO socksDTO){
      socksService.removeSocks(socksDTO);

    }
    /**
     * Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.
     */
    @GetMapping
    public Long acceptanceSocks(@RequestParam String color,
                                                 Operation operation,
                                                Long cottonPart){

        return socksService.getCountSocks(color, operation,  cottonPart);
    }

}

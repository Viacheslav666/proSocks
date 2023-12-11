package ru.socksPro.service;


import ru.socksPro.DTO.SocksDTO;
import ru.socksPro.pojo.Operation;

public interface SocksService {

    void addSocks(SocksDTO socksDTO);

    void removeSocks(SocksDTO socksDTO);

    Long getCountSocks(String color, Operation operation, Long cottonPart);
}

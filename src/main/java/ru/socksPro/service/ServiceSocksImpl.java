package ru.socksPro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.socksPro.DTO.SocksDTO;
import ru.socksPro.pojo.Operation;
import ru.socksPro.pojo.Socks;
import ru.socksPro.repository.SocksRepository;

@Service
@RequiredArgsConstructor
public class ServiceSocksImpl implements SocksService {
    private final SocksRepository socksRepository;

    @Override
    public void addSocks(SocksDTO socksDTO) {
        Socks socks = socksRepository.findByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
        if (socksDTO.getCottonPart() <= 100 && socksDTO.getQuantity() > 0) {
            if (socks != null) {
                socks.setQuantity(socks.getQuantity() + socksDTO.getQuantity());
                socksRepository.save(socks);
            } else if (socks == null) {
                socksRepository.save(SocksDTO.toSocks(socksDTO));
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public void removeSocks(SocksDTO socksDTO) {
        Socks socks = socksRepository.findByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
        if (socksDTO.getCottonPart() <= 100 && socksDTO.getQuantity() > 0) {
            if (socks != null && socksDTO.getQuantity()>0) {
                socks.setQuantity(socks.getQuantity() - socksDTO.getQuantity());
                socksRepository.save(socks);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Long getCountSocks(String color, Operation operation, Long cottonPart) {
        if (operation == Operation.valueOf(String.valueOf(Operation.moreThan))) {
            return socksRepository.getQuantityByColorAndCottonPartMoreThen(color, cottonPart);
        } else if (operation == Operation.valueOf(String.valueOf(Operation.lessThan))) {
            return socksRepository.getByQuantityByColorAndCottonPartLessThen(color, cottonPart);
        } else if (operation == Operation.valueOf(String.valueOf(Operation.equal))){
            return socksRepository.getQuantityByColorAndCottonPartEqualsThen(color, cottonPart);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
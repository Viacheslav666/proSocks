package ru.socksPro.DTO;

import lombok.Data;
import ru.socksPro.pojo.Socks;

@Data
public class SocksDTO {
    private String color;
    private Long cottonPart;
    private Long quantity;

    /**
     * Маппер для преобразоваия модели в DTO
     *
     * @param socks
     * @return socksDTO
     */
    public static SocksDTO fromSocks(Socks socks) {
        SocksDTO socksDTO = new SocksDTO();
        socksDTO.setColor(socks.getColor());
        socksDTO.setCottonPart(socks.getCottonPart());
        socksDTO.setQuantity(socks.getQuantity());
        return socksDTO;
    }

    public static Socks toSocks(SocksDTO socksDTO) {
        Socks socks = new Socks();
        socks.setColor(socksDTO.getColor());
        socks.setCottonPart(socksDTO.getCottonPart());
        socks.setQuantity(socksDTO.getQuantity());
        return socks;
    }
}
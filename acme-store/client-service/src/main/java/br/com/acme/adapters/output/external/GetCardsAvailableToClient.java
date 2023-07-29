package br.com.acme.adapters.output.external;

import br.com.acme.adapters.output.external.response.CardsAvailableClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "getcards", url ="${card.getcards.url}")
public interface GetCardsAvailableToClient {
    @GetMapping(value = "/{income}", consumes = "application/json")
    List<CardsAvailableClient> getCardsAvailable(@PathVariable("income") String income);
}

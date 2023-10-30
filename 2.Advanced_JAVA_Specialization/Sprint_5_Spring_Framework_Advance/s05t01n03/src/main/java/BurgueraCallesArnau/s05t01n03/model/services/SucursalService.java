package BurgueraCallesArnau.s05t01n03.model.services;

import BurgueraCallesArnau.s05t01n03.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n03.model.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SucursalService{
   /* @Autowired
    private SucursalRepository sucursalRepository;*/
   private final WebClient.Builder webClientBuilder;

    @Autowired
    public SucursalService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Sucursal> createSucursal(Sucursal sucursal) {
        return webClientBuilder
                .build()
                .post()
                .uri("/add") // Endpoint for creating a Sucursal in the existing API
                .body(Mono.just(sucursal), Sucursal.class)
                .retrieve()
                .bodyToMono(Sucursal.class);
    }

    public Mono<SucursalDTO> updateSucursal(Sucursal sucursal) {
        return webClientBuilder
                .build()
                .put()
                .uri("/update") // Endpoint for updating a Sucursal in the existing API
                .body(Mono.just(sucursal), Sucursal.class)
                .retrieve()
                .bodyToMono(SucursalDTO.class);
    }

    public Mono<Void> deleteSucursal(Integer id) {
        return webClientBuilder
                .build()
                .delete()
                .uri("/delete/{id}", id) // Endpoint for deleting a Sucursal by ID
                .retrieve()
                .toBodilessEntity()
                .then();
    }

    public Flux<SucursalDTO> getAllSucursals() {
        return webClientBuilder
                .build()
                .get()
                .uri("/getAll") // Endpoint for getting all Sucursals
                .retrieve()
                .bodyToFlux(SucursalDTO.class);
    }

    public Mono<SucursalDTO> getOneSucursal(Integer id) {
        return webClientBuilder
                .build()
                .get()
                .uri("/getOne/{id}", id) // Endpoint for getting a specific Sucursal by ID
                .retrieve()
                .bodyToMono(SucursalDTO.class);
    }
}

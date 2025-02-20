package springreactive.springwebflux.image.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import springreactive.springwebflux.image.handler.dto.ImageResponse;
import springreactive.springwebflux.image.service.ImageService;

@RequiredArgsConstructor
@Component
public class ImageHandler {
    private final ImageService imageService;
    public Mono<ServerResponse> getImageById(ServerRequest request) {
        var imageId = request.pathVariable("imageId");
        return imageService.getImageById(imageId)
                .map(image ->
                        new ImageResponse(image.getId(), image.getName(), image.getUrl())
                ).flatMap(imageResp -> ServerResponse.ok()
                        .bodyValue(imageResp)
                ).onErrorMap(e -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

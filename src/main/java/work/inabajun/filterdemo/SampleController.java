package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SampleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample")
    public ResponseEntity<String> sample() {
        LOGGER.info("Controller sample");
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/sample2")
    public ResponseEntity<String> sample2() {
        LOGGER.info("Controller throw error");
        throw new RuntimeException("Unhandled exception.");
    }

}
